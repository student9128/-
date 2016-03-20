package com.kevin.testguide.fragment;

import com.kevin.testguide.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Fragment2 extends Fragment {
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	ImageView imageView = new ImageView(getActivity());
	imageView.setImageResource(R.drawable.guide_2);
	return imageView;
}
}
