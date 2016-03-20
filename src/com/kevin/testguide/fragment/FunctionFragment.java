package com.kevin.testguide.fragment;

import android.view.View;
import android.widget.TextView;

public class FunctionFragment extends BaseFragment {

	@Override
	public View initView() {
		TextView textView = new TextView(getActivity());
		textView.setText(getClass().getName());
		return textView;
	}

}
