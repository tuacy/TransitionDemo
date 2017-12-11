package com.tuacy.transitiondemo.activity;


import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.tuacy.transitiondemo.R;

public class ActivityTransitionActivity extends AppCompatActivity {

	private Context   mContext;
	private Activity  mActivity;
	private ImageView mImage0;
	private ImageView mImage1;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 允许使用transitions,也可以在主题里面设置android:windowContentTransitions
		getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
		setContentView(R.layout.activity_activity_animation);
		getWindow().setReturnTransition(new Fade());//new Slide()  new Fade()
		mContext = this;
		mActivity = this;
		initView();
		initEvent();
		initData();
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}

	private void initView() {
		mImage0 = findViewById(R.id.image_0);
		mImage1 = findViewById(R.id.image_1);
	}

	private void initEvent() {
		findViewById(R.id.button_custom_animation).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//第一个是指当前activity，第二个和第三个参数分别是进入动画和退出动画
				ActivityOptions compat = ActivityOptions.makeCustomAnimation(mContext, R.anim.top_in, R.anim.bottom_out);
				startActivity(new Intent(mContext, TransitionToActivity.class), compat.toBundle());
			}
		});

		findViewById(R.id.button_scale_up_animation).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ActivityOptionsCompat compat = ActivityOptionsCompat.makeScaleUpAnimation(mImage0, mImage0.getWidth() / 2,
																						  mImage0.getHeight() / 2, 0, 0);
				ActivityCompat.startActivity(mContext, new Intent(mContext, TransitionToActivity.class), compat.toBundle());
			}
		});

		findViewById(R.id.button_thumbnail_animation).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//第一个是指当前activity，第二个和第三个参数分别是进入动画和退出动画
				ActivityOptionsCompat compat = ActivityOptionsCompat.makeThumbnailScaleUpAnimation(mImage0, BitmapFactory.decodeResource(
					getResources(), R.mipmap.ic_launcher), mImage0.getWidth() / 2, mImage0.getHeight() / 2);
				ActivityCompat.startActivity(mContext, new Intent(mContext, TransitionToActivity.class), compat.toBundle());
			}
		});

		findViewById(R.id.layout_activity_transition).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//				ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(mActivity, mImage0, mContext.getString(R.string.activity_transition_scene_name_0));
				//				ActivityCompat.startActivity(mContext, new Intent(mContext, TransitionToActivity.class), compat.toBundle());
				Pair<View, String> imagePair0 = Pair.create((View) mImage0, getString(R.string.activity_transition_scene_name_0));
				Pair<View, String> imagePair1 = Pair.create((View) mImage1, getString(R.string.activity_transition_scene_name_1));
				ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(mActivity, imagePair0, imagePair1);
				ActivityCompat.startActivity(mContext, new Intent(mContext, TransitionToActivity.class), compat.toBundle());
			}
		});
	}

	private void initData() {

	}
}
