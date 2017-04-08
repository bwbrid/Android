package com.bwbrid.day01;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity implements OnClickListener {

	private Context context;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        
        Button btPhoneCall = (Button) findViewById(R.id.bt_ip_phone);
        Button btSdStatus = (Button) findViewById(R.id.bt_sd_status);
        btPhoneCall.setOnClickListener(this);
        btSdStatus.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_ip_phone:
			startIntent(IpPhoneCallActivity.class);
			break;
		case R.id.bt_sd_status:
			startIntent(SdCardStatusActivity.class);
			break;
		default:
			break;
		}
	}
	
	private void startIntent(Class<?> cls) {
		Intent intent = new Intent(context, cls);
		startActivity(intent);
	}
}
