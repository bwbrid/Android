package com.bwbrid.day01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SdCardReceiver extends BroadcastReceiver {

	private final static String MEDIA_MOUNTED = "android.intent.action.MEDIA_MOUNTED";
	private final static String MEDIA_UNMOUNTED = "android.intent.action.MEDIA_UNMOUNTED";
	
	@Override
	public void onReceive(Context context, Intent intent) {
		
		SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		
		// 获取广播事件的类型
		String action = intent.getAction();
		
		if (MEDIA_MOUNTED.equals(action)) {
			editor.putInt("isMounted", 1);
			
		} else if (MEDIA_UNMOUNTED.equals(action)) {
			editor.putInt("isMounted", 0);
		} else {
			editor.putInt("isMounted", -1);
		}
		
		editor.commit();
	}
}
