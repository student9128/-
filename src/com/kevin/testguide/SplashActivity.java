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
			boolean isFirst = sp.getBoolean(ContentValue.isFirst, true);// 默认是第一次
			if (isFirst) {// 如果是第一次打开，跳转到引导界面
				Intent intent = new Intent(SplashActivity.this,
						GuideActivity.class);
				startActivity(intent);
				finish();
			} else {
				// 跳转到主界面
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
		handler.sendEmptyMessageDelayed(0, 2000);// 延迟两秒跳转
	}

}
