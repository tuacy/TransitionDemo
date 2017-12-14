package com.tuacy.transitiondemo.activitytransition.makescenetransition;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.transition.TransitionSet;
import android.view.Gravity;

import com.tuacy.transitiondemo.R;


public class MakeSceneTransitionActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_animation_to);
		//		//资源文件指定过渡动画
		//		getWindow().setEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.transition_target));
		//代码制定过渡动画
		TransitionSet transitionSet = new TransitionSet();
		Slide slide = new Slide(Gravity.BOTTOM);
		slide.addTarget(R.id.image_shared);
		transitionSet.addTransition(slide);
		Fade fade = new Fade();
		fade.excludeTarget(android.R.id.statusBarBackground, true);
		fade.excludeTarget(android.R.id.navigationBarBackground, true);
		fade.excludeTarget(R.id.image_shared, true);
		transitionSet.addTransition(fade);
		transitionSet.setOrdering(TransitionSet.ORDERING_SEQUENTIAL);
		getWindow().setEnterTransition(transitionSet);
	}
}