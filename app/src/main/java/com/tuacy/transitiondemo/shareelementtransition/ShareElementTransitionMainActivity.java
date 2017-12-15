package com.tuacy.transitiondemo.shareelementtransition;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.tuacy.transitiondemo.R;
import com.tuacy.transitiondemo.scenetransition.SceneTransitionMainActivity;
import com.tuacy.transitiondemo.shareelementtransition.activity.ActivityShareElementTransitionActivity;
import com.tuacy.transitiondemo.shareelementtransition.fragment.FragmentShareElementTransitionActivity;


public class ShareElementTransitionMainActivity extends AppCompatActivity {

	private Context mContext;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_share_element_transition_main);
		mContext = this;
		initEvent();
	}

	private void initEvent() {
		findViewById(R.id.layout_activity_share_element).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(mContext, ActivityShareElementTransitionActivity.class));
			}
		});

		findViewById(R.id.layout_fragment_share_element).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(mContext, FragmentShareElementTransitionActivity.class));
			}
		});
	}
}
