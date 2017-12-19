package com.tuacy.transitiondemo.shareelementtransition.browse;

import android.view.View;

import java.util.List;
import java.util.Map;

/**
 * Created by tuacy on 17-12-17.
 */

public abstract class CallbackTemp {

	/**
	 *
	 * @param sharedElementNames
	 * @param sharedElements
	 * @param sharedElementSnapshots
	 */
	public void onSharedElementStart(List<String> sharedElementNames,
									 List<View> sharedElements, List<View> sharedElementSnapshots) {}

	public void onSharedElementEnd(List<String> sharedElementNames,
								   List<View> sharedElements, List<View> sharedElementSnapshots) {}

	public void onRejectSharedElements(List<View> rejectedSharedElements) {}

	/**
	 * 装载共享元素
	 * @param names
	 * @param sharedElements
	 */
	public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {}



}
