package com.kevin.testguide;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.kevin.testguide.fragment.FunctionFragment;
import com.kevin.testguide.fragment.GovFragment;
import com.kevin.testguide.fragment.NewsCenterFragment;
import com.kevin.testguide.fragment.SettingsFragment;
import com.kevin.testguide.fragment.SmartServicesFragment;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class MainActivity extends FragmentActivity implements OnCheckedChangeListener {
	@ViewInject(R.id.main_radio)
	private RadioGroup main_Radio;
SharedPreferences sp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		sp = getSharedPreferences(ContentValue.config, MODE_PRIVATE);
		setContentView(R.layout.frag_home);
		sp.edit().putBoolean(ContentValue.isFirst, false).commit();//进入主界面以后就不再显示引导界面
		ViewUtils.inject(this);
		main_Radio.setOnCheckedChangeListener(this);
		main_Radio.check(R.id.rb_function);
	}
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		Fragment fragment = null;
		switch (checkedId) {
		case R.id.rb_function:
			fragment = new FunctionFragment();
			break;
		case R.id.rb_news_center:
			fragment = new NewsCenterFragment();
			break;
		case R.id.rb_smart_services:
			fragment = new SmartServicesFragment();
			break;
		case R.id.rb_settings:
			fragment = new SettingsFragment();
			break;
		case R.id.rb_gov_affairs:
			fragment = new GovFragment();
			break;

		default:
			break;
		}
		getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, fragment).commit();
		
	}
	


}
