package com.tuacy.transitiondemo.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Window;

import com.tuacy.transitiondemo.R;

public class TransitionToActivity extends AppCompatActivity{

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
		setContentView(R.layout.activity_activity_transition_to);
		getWindow().setEnterTransition(new Slide());//new Slide()  new Fade()
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		ActivityCompat.finishAfterTransition(this);
	}
}
