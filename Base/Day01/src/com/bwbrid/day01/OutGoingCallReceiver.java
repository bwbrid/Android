package com.bwbrid.day01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class OutGoingCallReceiver extends BroadcastReceiver {

	private final static String ZERO_STR = "0";
	@Override
	public void onReceive(Context context, Intent intent) {
		
		// 获取保存的电话号码
		SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		String number = sp.getString("phoneNumber", "");
		
		// 从广播中获取用户输入的电话号码, 并修改该号码
		String phoneNumber = getResultData();
		if (phoneNumber.startsWith(ZERO_STR)) {
			setResultData(number + phoneNumber);
		}
	}
}
