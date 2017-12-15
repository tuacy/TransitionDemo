package com.tuacy.transitiondemo.shareelementtransition.activity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tuacy.transitiondemo.R;
import com.tuacy.transitiondemo.activitytransition.makescenetransition.MakeSceneTransitionActivity;
import com.tuacy.transitiondemo.shareelementtransition.adapter.RecyclerCardAdapter;


public class ActivityShareElementTransitionActivity extends AppCompatActivity {

	private Activity     mActivity;
	private Context      mContext;
	private RecyclerView mRecyclerView;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_share_element);
		mActivity = this;
		mContext = this;
		initView();
		initEvent();
		initData();
	}

	private void initView() {
		mRecyclerView = findViewById(R.id.recycler_share_element);
		mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
		mRecyclerView.setAdapter(new RecyclerCardAdapter(this, new RecyclerCardAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(View view, int position) {
				ActivityOptions compat = ActivityOptions.makeSceneTransitionAnimation(mActivity, view, view.getTransitionName());
				startActivity(new Intent(mContext, ActivityBrowse.class), compat.toBundle());
			}
		}));
	}

	private void initEvent() {

	}

	private void initData() {

	}
}
