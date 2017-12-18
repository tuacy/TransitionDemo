package com.tuacy.transitiondemo.shareelementtransition.browse;


import android.app.SharedElementCallback;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tuacy.transitiondemo.R;

import java.util.List;
import java.util.Map;

public class ActivityBrowse extends AppCompatActivity {

	public static final String EXTRA_START_POSITION = "start_position";

	private int            mStartPosition;
	private int            mCurrentPosition;
	private DetailFragment mCurrentDetailsFragment;
	private boolean        mIsReturning;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_browse);
		initShareElement();
		mStartPosition = getIntent().getIntExtra(EXTRA_START_POSITION, 0);
		initView();
		initEvent();
		initData();
	}

	@Override
	public void finishAfterTransition() {
		mIsReturning = true;
		Intent data = new Intent();
		data.putExtra(BrowseShareElementTransitionActivity.EXTRA_START_POSITION, mStartPosition);
		data.putExtra(BrowseShareElementTransitionActivity.EXTRA_CURRENT_POSITION, mCurrentPosition);
		setResult(RESULT_OK, data);
		super.finishAfterTransition();
	}

	private void initView() {
		mCurrentPosition = mStartPosition;
		ViewPager pager = findViewById(R.id.pager);
		pager.setAdapter(new DetailsFragmentPagerAdapter(getSupportFragmentManager()));
		pager.setCurrentItem(mCurrentPosition);
		pager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				mCurrentPosition = position;
			}
		});
	}

	private void initEvent() {

	}

	private void initData() {

	}

	private void initShareElement() {
		postponeEnterTransition();
		setEnterSharedElementCallback(mCallback);
	}

	private final SharedElementCallback mCallback = new SharedElementCallback() {

		@Override
		public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
			if (mIsReturning) {
				ImageView sharedElement = mCurrentDetailsFragment.getAlbumImage();
				if (sharedElement == null) {
					names.clear();
					sharedElements.clear();
				} else if (mStartPosition != mCurrentPosition) {
					names.clear();
					names.add(sharedElement.getTransitionName());
					sharedElements.clear();
					sharedElements.put(sharedElement.getTransitionName(), sharedElement);
				}
			}
		}
	};


	private class DetailsFragmentPagerAdapter extends FragmentStatePagerAdapter {

		DetailsFragmentPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return DetailFragment.newInstance(position, mStartPosition);
		}

		@Override
		public void setPrimaryItem(ViewGroup container, int position, Object object) {
			super.setPrimaryItem(container, position, object);
			mCurrentDetailsFragment = (DetailFragment) object;
		}

		@Override
		public int getCount() {
			return ImageConstants.IMAGE_SOURCE.length;
		}
	}
}
