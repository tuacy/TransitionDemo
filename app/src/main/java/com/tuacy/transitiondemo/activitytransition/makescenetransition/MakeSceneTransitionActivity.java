package com.tuacy.transitiondemo.activitytransition.makescenetransition;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionSet;
import android.view.Gravity;

import com.tuacy.transitiondemo.R;


public class MakeSceneTransitionActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_animation_to);
//		TransitionSet transitionSet = new TransitionSet();
//		Slide slideLeft = new Slide(Gravity.START);
//		slideLeft.addTarget(R.id.image_one);
//		transitionSet.addTransition(slideLeft);
//		Slide slideRight = new Slide(Gravity.END);
//		slideLeft.addTarget(R.id.image_two);
//		transitionSet.addTransition(slideRight);
//		Slide slideTop = new Slide(Gravity.TOP);
//		slideTop.addTarget(R.id.image_three);
//		slideTop.addTarget(R.id.image_four);
//		transitionSet.addTransition(slideTop);
//		Fade fade = new Fade();
//		fade.excludeTarget(R.id.image_one, true);
//		fade.excludeTarget(R.id.image_two, true);
//		fade.excludeTarget(R.id.image_three, true);
//		fade.excludeTarget(R.id.image_four, true);
//		transitionSet.addTransition(fade);
//		getWindow().setEnterTransition(transitionSet);
	}
}
