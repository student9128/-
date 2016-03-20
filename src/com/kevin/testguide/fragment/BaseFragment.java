package com.kevin.testguide.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * ≥È»°ª˘¿‡BaseFragment
 * @author jing
 *
 */
public abstract class BaseFragment extends Fragment {
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	View view = initView();
	return view;
}

public abstract View initView();
}
