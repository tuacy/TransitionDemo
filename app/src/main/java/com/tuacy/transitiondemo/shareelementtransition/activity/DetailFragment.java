package com.tuacy.transitiondemo.shareelementtransition.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tuacy.transitiondemo.R;
import com.tuacy.transitiondemo.shareelementtransition.ImageConstants;

public class DetailFragment extends Fragment {

	public static final String ARG_CURRENT_POSITION = "current_position";
	public static final String ARG_START_POSITION   = "start_position";

	public static DetailFragment newInstance(int currentPosition, int startPosition) {
		Bundle args = new Bundle();
		args.putInt(ARG_CURRENT_POSITION, currentPosition);
		args.putInt(ARG_START_POSITION, startPosition);
		DetailFragment fragment = new DetailFragment();
		fragment.setArguments(args);
		return fragment;
	}

	private int       mCurrentPosition;
	private int       mStartPosition;
	private boolean   mShareElement;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mCurrentPosition = getArguments().getInt(ARG_CURRENT_POSITION);
		mStartPosition = getArguments().getInt(ARG_START_POSITION);
		mShareElement = savedInstanceState == null && mCurrentPosition == mStartPosition;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
		ImageView imagePicture = rootView.findViewById(R.id.image_detail_picture);
		Picasso.with(getActivity()).load(ImageConstants.IMAGE_SOURCE[mCurrentPosition]).into(imagePicture);
		TextView textTitle = rootView.findViewById(R.id.text_detail_title);
		textTitle.setText("美女" + mCurrentPosition);
		if (mShareElement) {
			imagePicture.setTransitionName(ImageConstants.IMAGE_SOURCE[mStartPosition]);
		}
		return rootView;
	}
}
