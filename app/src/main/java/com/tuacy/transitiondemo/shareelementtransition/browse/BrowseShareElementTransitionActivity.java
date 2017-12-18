package com.tuacy.transitiondemo.shareelementtransition.browse;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;

import com.tuacy.transitiondemo.R;

import java.util.List;
import java.util.Map;


public class BrowseShareElementTransitionActivity extends AppCompatActivity {

	public static final String EXTRA_START_POSITION   = "start_position";
	public static final String EXTRA_CURRENT_POSITION = "current_position";

	private Activity     mActivity;
	private Context      mContext;
	private RecyclerView mRecyclerView;
	private Bundle       mReenterState;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_browse_share_element);
		initShareElement();
		mActivity = this;
		mContext = this;
		initView();
		initEvent();
		initData();
	}

	@Override
	public void onActivityReenter(int requestCode, Intent data) {
		super.onActivityReenter(requestCode, data);
		mReenterState = new Bundle(data.getExtras());
		int startingPosition = mReenterState.getInt(EXTRA_START_POSITION);
		int currentPosition = mReenterState.getInt(EXTRA_CURRENT_POSITION);
		if (startingPosition != currentPosition) {
			mRecyclerView.scrollToPosition(currentPosition);
		}
		postponeEnterTransition();
		mRecyclerView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
			@Override
			public boolean onPreDraw() {
				mRecyclerView.getViewTreeObserver().removeOnPreDrawListener(this);
				mRecyclerView.requestLayout();
				startPostponedEnterTransition();
				return true;
			}
		});
	}

	private void initView() {
		mRecyclerView = findViewById(R.id.recycler_share_element);
		mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
		mRecyclerView.setAdapter(new RecyclerCardAdapter(this, new RecyclerCardAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(View view, int position) {
				Intent intent = new Intent(mContext, ActivityBrowse.class);
				intent.putExtra(ActivityBrowse.EXTRA_START_POSITION, position);
				ActivityOptions compat = ActivityOptions.makeSceneTransitionAnimation(mActivity, view, view.getTransitionName());
				startActivity(intent, compat.toBundle());
			}
		}));
	}

	private void initEvent() {

	}

	private void initData() {

	}

	private void initShareElement() {
		setExitSharedElementCallback(mCallback);
	}

	private final SharedElementCallback mCallback = new SharedElementCallback() {

		@Override
		public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
			if (mReenterState != null) {
				//从别的界面返回当前界面
				int startingPosition = mReenterState.getInt(EXTRA_START_POSITION);
				int currentPosition = mReenterState.getInt(EXTRA_CURRENT_POSITION);
				if (startingPosition != currentPosition) {
					String newTransitionName = ImageConstants.IMAGE_SOURCE[currentPosition];
					View newSharedElement = mRecyclerView.findViewWithTag(newTransitionName);
					if (newSharedElement != null) {
						names.clear();
						names.add(newTransitionName);
						sharedElements.clear();
						sharedElements.put(newTransitionName, newSharedElement);
					}
				}
				mReenterState = null;
			} else {
				//从当前界面进入到别的界面
				View navigationBar = findViewById(android.R.id.navigationBarBackground);
				View statusBar = findViewById(android.R.id.statusBarBackground);
				if (navigationBar != null) {
					names.add(navigationBar.getTransitionName());
					sharedElements.put(navigationBar.getTransitionName(), navigationBar);
				}
				if (statusBar != null) {
					names.add(statusBar.getTransitionName());
					sharedElements.put(statusBar.getTransitionName(), statusBar);
				}
			}
		}
	};
}
