package com.tuacy.transitiondemo.activitytransition.makescenetransition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewAnimationUtils;

import com.tuacy.transitiondemo.R;


public class MakeSceneTransitionActivity extends AppCompatActivity {

	private View mViewBackgroundTop;
	private View mViewBackgroundBottom;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initTransition();
		setContentView(R.layout.activity_activity_animation_to);
		mViewBackgroundTop = findViewById(R.id.view_parent_background);
		mViewBackgroundBottom = findViewById(R.id.view_background_bottom);
	}

	private void initTransition() {
		//		//资源文件指定过渡动画
		//		getWindow().setEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.transition_target));
		//代码制定过渡动画
		final TransitionSet transitionSet = new TransitionSet();
		Slide slide = new Slide(Gravity.BOTTOM);
		slide.addTarget(R.id.image_shared);
		transitionSet.addTransition(slide);
		Explode explode = new Explode();
		explode.excludeTarget(android.R.id.statusBarBackground, true);
		explode.excludeTarget(android.R.id.navigationBarBackground, true);
		explode.excludeTarget(R.id.image_shared, true);
		transitionSet.addTransition(explode);
		transitionSet.setOrdering(TransitionSet.ORDERING_SEQUENTIAL);
		getWindow().setEnterTransition(transitionSet);
		transitionSet.addListener(new Transition.TransitionListener() {
			@Override
			public void onTransitionStart(Transition transition) {
				mViewBackgroundTop.setVisibility(View.GONE);
				mViewBackgroundBottom.setVisibility(View.GONE);
			}

			@Override
			public void onTransitionEnd(Transition transition) {
				mViewBackgroundTop.setVisibility(View.VISIBLE);
				mViewBackgroundBottom.setVisibility(View.VISIBLE);
				Animator animationTop = ViewAnimationUtils.createCircularReveal(mViewBackgroundTop, mViewBackgroundTop.getWidth() / 2,
																				mViewBackgroundTop.getHeight() / 2, 0,
																				Math.max(mViewBackgroundTop.getWidth() / 2,
																						 mViewBackgroundTop.getHeight() / 2));
				Animator animationBottom = ViewAnimationUtils.createCircularReveal(mViewBackgroundBottom, mViewBackgroundBottom.getWidth(),
																				   mViewBackgroundBottom.getHeight(), 0,
																				   (float) Math.hypot(mViewBackgroundBottom.getWidth(),
																									  mViewBackgroundBottom.getHeight()));

				AnimatorSet animatorSet = new AnimatorSet();
				animatorSet.setDuration(500L);
				animatorSet.playTogether(animationTop, animationBottom);
				animatorSet.start();
				transitionSet.removeListener(this);
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