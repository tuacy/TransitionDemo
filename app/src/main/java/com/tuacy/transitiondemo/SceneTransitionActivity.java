package com.tuacy.transitiondemo;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

public class SceneTransitionActivity extends AppCompatActivity{
	private     Scene   mSceneLeft;
	private Scene   mSceneRight;
	private boolean isSceneSecond;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scene_animation);
		ViewGroup sceneRoot = findViewById(R.id.layout_transition_root);
		mSceneLeft = Scene.getSceneForLayout(sceneRoot, R.layout.scene_first, this);
		mSceneRight = Scene.getSceneForLayout(sceneRoot, R.layout.scene_second, this);
		TransitionManager.go(mSceneLeft);

		findViewById(R.id.button_transition_change).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				transitionChange();
			}
		});
	}

	private void transitionChange() {
		TransitionManager.go(isSceneSecond ? mSceneLeft : mSceneRight, new ChangeBounds());
		isSceneSecond = !isSceneSecond;
	}
}
