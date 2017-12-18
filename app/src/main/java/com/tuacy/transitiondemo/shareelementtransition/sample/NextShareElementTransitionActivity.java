package com.tuacy.transitiondemo.shareelementtransition.sample;

import android.animation.Animator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.TextView;

import com.tuacy.transitiondemo.R;

import de.hdodenhof.circleimageview.CircleImageView;


public class NextShareElementTransitionActivity extends AppCompatActivity {

	private View            mViewBackground;
	//transition name 已经在layout文件中设置
	private CircleImageView mImageShare;
	private TextView        mTextInfo;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_next_share_element);
		initView();
		initEvent();
		initData();
		initShareTransition();
	}

	private void initView() {
		mViewBackground = findViewById(R.id.view_background);
		mImageShare = findViewById(R.id.image_view_share);
		mTextInfo = findViewById(R.id.text_info);
	}

	private void initEvent() {

	}

	private void initData() {

	}

	private void initShareTransition() {
		//直接在style里面设置了共享元素的Transition
		//		getWindow().setSharedElementEnterTransition(new ChangeBounds());
		//		getWindow().setSharedElementExitTransition(new ChangeBounds());
		//		getWindow().setSharedElementReenterTransition(new ChangeBounds());
		//		getWindow().setSharedElementReturnTransition(new ChangeBounds());
		getWindow().getSharedElementEnterTransition().addListener(new Transition.TransitionListener() {
			@Override
			public void onTransitionStart(Transition transition) {
				mTextInfo.setVisibility(View.GONE);
				mViewBackground.setVisibility(View.GONE);
			}

			@Override
			public void onTransitionEnd(Transition transition) {
				mTextInfo.setVisibility(View.VISIBLE);
				mViewBackground.setVisibility(View.VISIBLE);
				Animator animationBottom = ViewAnimationUtils.createCircularReveal(mTextInfo, mTextInfo.getWidth() / 2,
																				   mTextInfo.getHeight() / 2, 0,
																				   (float) Math.max(mTextInfo.getWidth() / 2,
																									mTextInfo.getHeight() / 2));

				animationBottom.setDuration(500L);
				animationBottom.start();

				mViewBackground.animate().alpha(1).setDuration(500L).start();

				getWindow().getSharedElementEnterTransition().removeListener(this);
			}

			@Override
			public void onTransitionCancel(Transition transition) {

			}

			@Override
			public void onTransitionPause(Transition transition) {

			}

			@Override
			public void onTransitionResume(Transition transition) {

			}
		});
	}
}
