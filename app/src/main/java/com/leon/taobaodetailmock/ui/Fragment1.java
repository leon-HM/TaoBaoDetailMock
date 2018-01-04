package com.leon.taobaodetailmock.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leon.taobaodetailmock.R;


/**
 * <br> ClassName: Fragment1
 * <br> Description: 长的详情
 *
 * <br> Author: hemin
 * <br> Date: 2017/11/20 17:18
 */
public class Fragment1 extends Fragment {
    View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_container1,container,false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }

    public static Fragment1 newInstance() {
        Bundle args = new Bundle();
//        args.putInt(ID,id);
        Fragment1 fragment = new Fragment1();
        fragment.setArguments(args);
        return fragment;
    }

}
