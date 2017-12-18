package com.tuacy.transitiondemo.shareelementtransition.sample;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.tuacy.transitiondemo.R;

public class SampleShareElementTransitionActivity extends AppCompatActivity {

	private Context  mContext;
	private Activity mActivity;
	private View     mViewShare;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sample_share_element);
		mContext = this;
		mActivity = this;
		mViewShare = findViewById(R.id.text_share_element);
		findViewById(R.id.button_next_activity).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(mContext, NextShareElementTransitionActivity.class);
				ActivityOptions compat = ActivityOptions.makeSceneTransitionAnimation(mActivity, mViewShare,
																					  mViewShare.getTransitionName());
				startActivity(intent, compat.toBundle());
			}
		});
	}
}
