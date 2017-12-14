package com.tuacy.transitiondemo.activitytransition;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.tuacy.transitiondemo.R;
import com.tuacy.transitiondemo.activitytransition.makecustom.MakeCustomerAnimationActivity;
import com.tuacy.transitiondemo.activitytransition.makescaleup.MakeScaleUpAnimationActivity;
import com.tuacy.transitiondemo.activitytransition.makescenetransition.MakeSceneTransitionActivity;
import com.tuacy.transitiondemo.activitytransition.makethumbnailscaleup.MakeThumbnailScaleUpAnimationActivity;

import de.hdodenhof.circleimageview.CircleImageView;


public class ActivityTransitionMainActivity extends AppCompatActivity {

	private Context         mContext;
	private Activity        mActivity;
	private CircleImageView mImage;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_transition_main);
		mContext = this;
		mActivity = this;
		initView();
		initEvent();
	}

	private void initView() {
		mImage = findViewById(R.id.image);
	}

	private void initEvent() {
		findViewById(R.id.layout_make_customer).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				/**
				 * 注意这里启动方式和API 21之前的不一样了
				 */
				ActivityOptions compat = ActivityOptions.makeCustomAnimation(mContext, R.anim.top_in, R.anim.bottom_out);
				startActivity(new Intent(mContext, MakeCustomerAnimationActivity.class), compat.toBundle());
			}
		});

		findViewById(R.id.layout_make_scale_up).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				/**
				 * 从mImage的中心开始放大Activity,底部进来，底部出去
				 */
				ActivityOptions compat = ActivityOptions.makeScaleUpAnimation(mImage, mImage.getWidth() / 2, mImage.getHeight() / 2, 0, 0);
				startActivity(new Intent(mContext, MakeScaleUpAnimationActivity.class), compat.toBundle());
			}
		});

		findViewById(R.id.layout_make_thumbnail_scale_up).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				/**
				 * 从mImage的中心开始放大Activity
				 */
				ActivityOptions compat = ActivityOptions.makeThumbnailScaleUpAnimation(mImage, BitmapFactory.decodeResource(getResources(),
																															R.mipmap.ic_launcher_round),
																					   mImage.getWidth() / 2, mImage.getHeight() / 2);
				startActivity(new Intent(mContext, MakeThumbnailScaleUpAnimationActivity.class), compat.toBundle());
			}
		});

		findViewById(R.id.layout_make_scene_transition).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				/**
				 * 注意这里，没有带共享元素哦(共享元素的打算放到下面讲)
				 */
				ActivityOptions compat = ActivityOptions.makeSceneTransitionAnimation(mActivity);
				startActivity(new Intent(mContext, MakeSceneTransitionActivity.class), compat.toBundle());
			}
		});
	}
}

