package com.tuacy.transitiondemo.shareelementtransition.browse;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.tuacy.transitiondemo.R;

public class RecyclerCardAdapter extends RecyclerView.Adapter<RecyclerCardAdapter.CardHolder> {

	private Context             mContext;
	private OnItemClickListener mListener;

	public interface OnItemClickListener {

		void onItemClick(View view, int position);
	}

	public RecyclerCardAdapter(Context context, OnItemClickListener listener) {
		mContext = context;
		mListener = listener;
	}

	@Override
	public CardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		final CardHolder holder = new CardHolder(LayoutInflater.from(mContext).inflate(R.layout.item_card_album_image, parent, false));
		holder.mAlbumImage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mListener.onItemClick(holder.mAlbumImage, holder.getAdapterPosition());
			}
		});
		return holder;
	}

	@Override
	public void onBindViewHolder(CardHolder holder, int position) {
		Picasso.with(mContext).load(ImageConstants.IMAGE_SOURCE[position]).into(holder.mAlbumImage);
		/**
		 * 设置共享元素的名称
		 */
		holder.mAlbumImage.setTransitionName(ImageConstants.IMAGE_SOURCE[position]);
		holder.mAlbumImage.setTag(ImageConstants.IMAGE_SOURCE[position]);
	}

	@Override
	public int getItemCount() {
		return ImageConstants.IMAGE_SOURCE.length;
	}

	static class CardHolder extends RecyclerView.ViewHolder {

		final ImageView mAlbumImage;

		CardHolder(View itemView) {
			super(itemView);
			mAlbumImage = itemView.findViewById(R.id.main_card_album_image);
		}
	}
}
