package com.tuacy.transitiondemo.blol;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.View;

/**
 * Created by tuacy on 17-12-7.
 */

public class Temp {

//	/**
//	 * 和overridePendingTransition非常类似,设置跳转时候的进入动画和退出动画
//	 * @param context:指当前activity
//	 * @param enterResId：进入动画
//	 * @param exitResId：退出动画
//	 * @return：ActivityOptionsCompat
//	 */
//	public static ActivityOptionsCompat makeCustomAnimation(Context context, int enterResId, int exitResId);
//
//	/**
//	 * 通过放大新的Activity过渡到新的Activity
//	 * @param source:新的Activity相对于哪个view开始放大
//	 * @param startX:在View基础上，从那个ｘ点开始放大
//	 * @param startY:在View基础上，从那个ｘ点开始放大
//	 * @param startWidth:新的Activity从多大的宽度开始放大
//	 * @param startHeight:新的Activity从多大的高度开始放大
//	 * @return:ActivityOptionsCompat
//	 * 举一个简单的例子来理解source=view,startX=view.getWidth(),startY=view.getHeight(),startWidth=0,startHeight=0
//	 * 表明新的Activity从view的中心从无到有的过程
//	 */
//	public static ActivityOptionsCompat makeScaleUpAnimation(View source,
//															 int startX, int startY, int startWidth, int startHeight);
//
//	/**
//	 * 通过放大一个图片过渡到新的Activity
//	 * @param source:新的Activity相对于哪个view开始放大
//	 * @param thumbnail:要放大的图片
//	 * @param startX:在View基础上，从那个ｘ点开始放大
//	 * @param startY:在View基础上，从那个ｘ点开始放大
//	 * @return:ActivityOptionsCompat
//	 */
//	public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View source,
//																	  Bitmap thumbnail, int startX, int startY);
//
//	/**
//	 * 场景动画，在这里就体现在两个Activity中的某些view协同去完成过度动画
//	 * @param activity:当前Activity
//	 * @param sharedElement:当前Activity协同的完成动画的View
//	 * @param sharedElementName:view的android:transitionName
//	 * @return:ActivityOptionsCompat
//	 */
//	public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity activity,
//																	 View sharedElement, String sharedElementName);
//
//	/**
//	 * 同上是对多个View同时起作用
//	 */
//	public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity activity,
//																	 Pair<View, String>... sharedElements);
}
