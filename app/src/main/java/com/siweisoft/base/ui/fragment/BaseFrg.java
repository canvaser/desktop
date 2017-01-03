package com.siweisoft.base.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;

import butterknife.ButterKnife;
import com.siweisoft.nurse.ui.setting.bean.dbbean.BackUIDBBean;
import com.siweisoft.nurse.ui.setting.ope.dbope.BackUIDBOpe;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-11-10.
 */
public class BaseFrg extends Fragment{

    protected FragmentActivity activity;


    protected LayoutInflater layoutInflater;

    protected Handler handler=new Handler();

    protected  Fragment fragment;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layoutInflater=LayoutInflater.from(getActivity());
        fragment = this;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentActivity){
            activity = (FragmentActivity) context;
        }
    }
}
