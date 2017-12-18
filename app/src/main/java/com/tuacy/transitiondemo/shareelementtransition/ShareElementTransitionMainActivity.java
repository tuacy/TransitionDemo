package com.tuacy.transitiondemo.shareelementtransition;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.tuacy.transitiondemo.R;
import com.tuacy.transitiondemo.shareelementtransition.browse.BrowseShareElementTransitionActivity;
import com.tuacy.transitiondemo.shareelementtransition.sample.SampleShareElementTransitionActivity;


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
				startActivity(new Intent(mContext, SampleShareElementTransitionActivity.class));
			}
		});

		findViewById(R.id.layout_share_element_browse).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(mContext, BrowseShareElementTransitionActivity.class));
			}
		});
	}
}
