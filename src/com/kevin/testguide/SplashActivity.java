package com.kevin.testguide;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.Window;

public class SplashActivity extends Activity {

	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			boolean isFirst = sp.getBoolean(ContentValue.isFirst, true);// Ĭ���ǵ�һ��
			if (isFirst) {// ����ǵ�һ�δ򿪣���ת����������
				Intent intent = new Intent(SplashActivity.this,
						GuideActivity.class);
				startActivity(intent);
				finish();
			} else {
				// ��ת��������
				Intent intent = new Intent(SplashActivity.this,
						MainActivity.class);
				startActivity(intent);
				finish();
			}
		};
	};
	public SharedPreferences sp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		sp = getSharedPreferences(ContentValue.config, MODE_PRIVATE);
		setContentView(R.layout.activity_splash);
		handler.sendEmptyMessageDelayed(0, 2000);// �ӳ�������ת
	}

}
