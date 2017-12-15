package com.tuacy.transitiondemo.shareelementtransition.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.tuacy.transitiondemo.R;
import com.tuacy.transitiondemo.shareelementtransition.ImageConstants;

public class ActivityBrowse extends AppCompatActivity{

	public static final String EXTRA_START_POSITION = "start_position";

	private int mStartPosition;
	private int mCurrentPosition;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_browse);
		mStartPosition = getIntent().getIntExtra(EXTRA_START_POSITION, 0);
		initView();
		initEvent();
		initData();
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
//			mCurrentDetailsFragment = (DetailsFragment) object;
		}

		@Override
		public int getCount() {
			return ImageConstants.IMAGE_SOURCE.length;
		}
	}
}
