package com.bwbrid.day01;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class SdCardStatusActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sd_status);
		
		SharedPreferences sp = getSharedPreferences("config", Context.MODE_PRIVATE);
		int mountCode = sp.getInt("isMounted", -1);
		
		TextView tv_status = (TextView) findViewById(R.id.tv_sd_status);
		
		if (mountCode == 1) {
			tv_status.setText("SD卡已挂载");
			
		} else if (mountCode == 0) {
			tv_status.setText("SD卡还未挂载");
			
		} else {
			tv_status.setText("SD卡状态未知");
		}
	}
}
