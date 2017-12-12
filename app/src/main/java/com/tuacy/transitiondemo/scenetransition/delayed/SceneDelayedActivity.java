package com.tuacy.transitiondemo.scenetransition.delayed;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.tuacy.transitiondemo.R;

import de.hdodenhof.circleimageview.CircleImageView;


public class SceneDelayedActivity extends AppCompatActivity {

	private ViewGroup       mViewSceneRoot;
	private CircleImageView mImageOne;
	private CircleImageView mImageTwo;
	private CircleImageView mImageThree;
	private CircleImageView mImageFour;
	private boolean         mStartScene;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scene_delayed);
		initView();
		initEvent();
		initData();
	}

	private void initView() {
		mViewSceneRoot = findViewById(R.id.layout_scene_delayed_root);
		mImageOne = findViewById(R.id.image_scene_delayed_one);
		mImageTwo = findViewById(R.id.image_scene_delayed_two);
		mImageThree = findViewById(R.id.image_scene_delayed_three);
		mImageFour = findViewById(R.id.image_scene_delayed_four);
	}

	private void initEvent() {
		findViewById(R.id.button_scene_transition_toggle).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				toggleScene();
			}
		});
	}

	private void initData() {
		mStartScene = true;
	}

	private void toggleScene() {
		TransitionManager.beginDelayedTransition(mViewSceneRoot, TransitionInflater.from(this)
																				   .inflateTransition(
																					   R.transition.change_bounds_and_change_transform));
		/**
		 * 四个角的View相互交换位置
		 */
		if (mStartScene) {
			RelativeLayout.LayoutParams oneParams = (RelativeLayout.LayoutParams) mImageOne.getLayoutParams();
			oneParams.removeRule(RelativeLayout.ALIGN_PARENT_START);
			oneParams.removeRule(RelativeLayout.ALIGN_PARENT_TOP);
			oneParams.removeRule(RelativeLayout.ALIGN_PARENT_END);
			oneParams.removeRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
			oneParams.addRule(RelativeLayout.ALIGN_PARENT_END);
			oneParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
			mImageOne.setLayoutParams(oneParams);

			RelativeLayout.LayoutParams twoParams = (RelativeLayout.LayoutParams) mImageTwo.getLayoutParams();
			twoParams.removeRule(RelativeLayout.ALIGN_PARENT_START);
			twoParams.removeRule(RelativeLayout.ALIGN_PARENT_TOP);
			twoParams.removeRule(RelativeLayout.ALIGN_PARENT_END);
			twoParams.removeRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
			twoParams.addRule(RelativeLayout.ALIGN_PARENT_START);
			twoParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
			mImageTwo.setLayoutParams(twoParams);

			RelativeLayout.LayoutParams threeParams = (RelativeLayout.LayoutParams) mImageThree.getLayoutParams();
			threeParams.removeRule(RelativeLayout.ALIGN_PARENT_START);
			threeParams.removeRule(RelativeLayout.ALIGN_PARENT_TOP);
			threeParams.removeRule(RelativeLayout.ALIGN_PARENT_END);
			threeParams.removeRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
			threeParams.addRule(RelativeLayout.ALIGN_PARENT_START);
			threeParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
			mImageThree.setLayoutParams(threeParams);

			RelativeLayout.LayoutParams fourParams = (RelativeLayout.LayoutParams) mImageFour.getLayoutParams();
			fourParams.removeRule(RelativeLayout.ALIGN_PARENT_START);
			fourParams.removeRule(RelativeLayout.ALIGN_PARENT_TOP);
			fourParams.removeRule(RelativeLayout.ALIGN_PARENT_END);
			fourParams.removeRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
			fourParams.addRule(RelativeLayout.ALIGN_PARENT_END);
			fourParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
			mImageFour.setLayoutParams(fourParams);

			mImageTwo.setScaleX(0.5f);
			mImageTwo.setScaleY(0.5f);
			mImageFour.setRotation(90);
		} else {
			RelativeLayout.LayoutParams oneParams = (RelativeLayout.LayoutParams) mImageOne.getLayoutParams();
			oneParams.removeRule(RelativeLayout.ALIGN_PARENT_START);
			oneParams.removeRule(RelativeLayout.ALIGN_PARENT_TOP);
			oneParams.removeRule(RelativeLayout.ALIGN_PARENT_END);
			oneParams.removeRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
			oneParams.addRule(RelativeLayout.ALIGN_PARENT_START);
			oneParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
			mImageOne.setLayoutParams(oneParams);

			RelativeLayout.LayoutParams twoParams = (RelativeLayout.LayoutParams) mImageTwo.getLayoutParams();
			twoParams.removeRule(RelativeLayout.ALIGN_PARENT_START);
			twoParams.removeRule(RelativeLayout.ALIGN_PARENT_TOP);
			twoParams.removeRule(RelativeLayout.ALIGN_PARENT_END);
			twoParams.removeRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
			twoParams.addRule(RelativeLayout.ALIGN_PARENT_END);
			twoParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
			mImageTwo.setLayoutParams(twoParams);

			RelativeLayout.LayoutParams threeParams = (RelativeLayout.LayoutParams) mImageThree.getLayoutParams();
			threeParams.removeRule(RelativeLayout.ALIGN_PARENT_START);
			threeParams.removeRule(RelativeLayout.ALIGN_PARENT_TOP);
			threeParams.removeRule(RelativeLayout.ALIGN_PARENT_END);
			threeParams.removeRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
			threeParams.addRule(RelativeLayout.ALIGN_PARENT_END);
			threeParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
			mImageThree.setLayoutParams(threeParams);

			RelativeLayout.LayoutParams fourParams = (RelativeLayout.LayoutParams) mImageFour.getLayoutParams();
			fourParams.removeRule(RelativeLayout.ALIGN_PARENT_START);
			fourParams.removeRule(RelativeLayout.ALIGN_PARENT_TOP);
			fourParams.removeRule(RelativeLayout.ALIGN_PARENT_END);
			fourParams.removeRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
			fourParams.addRule(RelativeLayout.ALIGN_PARENT_START);
			fourParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
			mImageFour.setLayoutParams(fourParams);

			mImageTwo.setScaleX(1f);
			mImageTwo.setScaleY(1f);
			mImageFour.setRotation(0);
		}
		mStartScene = !mStartScene;
	}
}
