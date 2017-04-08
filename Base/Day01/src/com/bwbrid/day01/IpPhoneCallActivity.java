package com.bwbrid.day01;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IpPhoneCallActivity extends Activity {

	SharedPreferences sp;
	EditText etNumber;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ip_phone);
        
        sp = getSharedPreferences("config", Context.MODE_PRIVATE);
        etNumber = (EditText) findViewById(R.id.et_number);
        etNumber.setText(sp.getString("phoneNumber", ""));
        
        // 设置按钮的点击事件
        Button btSave = (Button) findViewById(R.id.bt_save);
        btSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String number = etNumber.getText().toString();
				if (TextUtils.isEmpty(number)) {
					Toast.makeText(getApplicationContext(), "请输入电话号码", Toast.LENGTH_SHORT).show();
					return;
				}
				
				Editor editor = sp.edit();
				editor.putString("phoneNumber", number);
				editor.commit();
				Toast.makeText(getApplicationContext(), "号码保存成功", Toast.LENGTH_SHORT).show();
			}
		});
    }
}
