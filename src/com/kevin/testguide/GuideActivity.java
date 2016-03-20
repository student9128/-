package com.kevin.testguide;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.kevin.testguide.fragment.Fragment1;
import com.kevin.testguide.fragment.Fragment2;
import com.kevin.testguide.fragment.Fragment3;

public class GuideActivity extends FragmentActivity {
	private ViewPager viewPager;
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guide);
		viewPager = (ViewPager) findViewById(R.id.view_pager);
		button = (Button) findViewById(R.id.button);
		initData();// 将图片初始化
		// MyAdapter adapter = new MyAdapter();
		MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(
				getSupportFragmentManager());
		viewPager.setAdapter(adapter);
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				if (position == imageResId.length - 1) {
					button.setVisibility(View.VISIBLE);
					button.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							startActivity(new Intent(GuideActivity.this,
									MainActivity.class));
							finish();

						}
					});
				}

			}

			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPixels) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int state) {
				// TODO Auto-generated method stub

			}
		});
	}

	private int[] imageResId = new int[] { R.drawable.guide_1,
			R.drawable.guide_2, R.drawable.guide_3 };
	private List<ImageView> imageViewList = new ArrayList<ImageView>();

	private void initData() {
		for (int i = 0; i < imageResId.length; i++) {
			ImageView imageView = new ImageView(getBaseContext());
			imageView.setImageResource(imageResId[i]);
			imageView.setScaleType(ScaleType.FIT_XY);
			imageViewList.add(imageView);// 放入集合中
		}

	}

	public class MyAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return imageResId.length;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// 根据位置获取图片
			ImageView imageView = imageViewList.get(position);
			container.addView(imageView);// 将图片添加到容器中
			return imageView;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// 将图片从容器中移除
			((ViewPager) container).removeView((View) object);

		}

		/**
		 * objcet指的是容器中的对象,view指的是instantiateItem返回的imageView
		 */
		@Override
		public boolean isViewFromObject(View view, Object object) {

			return view == object;
		}
	}

	public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

		public MyFragmentPagerAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int position) {
			Fragment fragment = null;
			switch (position) {
			case 0:
				fragment = new Fragment1();
				break;
			case 1:
				fragment = new Fragment2();
				break;
			case 2:
				fragment = new Fragment3();
				break;

			default:
				break;
			}
			return fragment;
		}

		@Override
		public int getCount() {
			return imageResId.length;
		}

	}
}
