package com.tuacy.transitiondemo.shareelementtransition.browse;


import android.animation.Animator;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.Transition;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.tuacy.transitiondemo.R;

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
	private ImageView mAlbumImage;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mCurrentPosition = getArguments().getInt(ARG_CURRENT_POSITION);
		mStartPosition = getArguments().getInt(ARG_START_POSITION);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
		final View viewBackground = rootView.findViewById(R.id.view_background);
		mAlbumImage = rootView.findViewById(R.id.image_detail_picture);
		TextView textTitle = rootView.findViewById(R.id.text_detail_title);
		textTitle.setText("美女" + mCurrentPosition);
		mAlbumImage.setTransitionName(ImageConstants.IMAGE_SOURCE[mCurrentPosition]);
		RequestCreator albumImageRequest = Picasso.with(getActivity()).load(ImageConstants.IMAGE_SOURCE[mCurrentPosition]);
		albumImageRequest.into(mAlbumImage, mImageCallback);
		if (mStartPosition == mCurrentPosition) {
			getActivity().getWindow().getSharedElementEnterTransition().addListener(new Transition.TransitionListener() {
				@Override
				public void onTransitionStart(Transition transition) {
					viewBackground.setVisibility(View.GONE);
				}

				@Override
				public void onTransitionEnd(Transition transition) {
					viewBackground.setVisibility(View.VISIBLE);
					Animator animationBottom = ViewAnimationUtils.createCircularReveal(viewBackground, viewBackground.getWidth(),
																					   viewBackground.getHeight(), 0,
																					   (float) Math.hypot(viewBackground.getWidth(),
																										  viewBackground.getHeight()));

					animationBottom.setDuration(500L);
					animationBottom.start();
					getActivity().getWindow().getSharedElementEnterTransition().removeListener(this);
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
		return rootView;
	}


	/**
	 * Returns the shared element that should be transitioned back to the previous Activity,
	 * or null if the view is not visible on the screen.
	 */
	@Nullable
	public ImageView getAlbumImage() {
		if (isViewInBounds(getActivity().getWindow().getDecorView(), mAlbumImage)) {
			return mAlbumImage;
		}
		return null;
	}

	/**
	 * Returns true if {@param view} is contained within {@param container}'s bounds.
	 */
	private static boolean isViewInBounds(@NonNull View container, @NonNull View view) {
		Rect containerBounds = new Rect();
		container.getHitRect(containerBounds);
		return view.getLocalVisibleRect(containerBounds);
	}

	public void startPostponedEnterTransition() {
		if (mCurrentPosition == mStartPosition) {
			mAlbumImage.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
				@Override
				public boolean onPreDraw() {
					mAlbumImage.getViewTreeObserver().removeOnPreDrawListener(this);
					getActivity().startPostponedEnterTransition();
					return true;
				}
			});
		}
	}

	private final Callback mImageCallback = new Callback() {
		@Override
		public void onSuccess() {
			startPostponedEnterTransition();
		}

		@Override
		public void onError() {
			startPostponedEnterTransition();
		}
	};
}
