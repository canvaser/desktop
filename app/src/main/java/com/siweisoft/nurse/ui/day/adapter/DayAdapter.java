package com.siweisoft.nurse.ui.day.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.siweisoft.base.ui.adapter.AppPagerAdapter;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-12-21.
 */

public class DayAdapter extends AppPagerAdapter{

    public DayAdapter(FragmentManager fm, Context context, ArrayList<Fragment> fragments) {
        super(fm, context, fragments);
    }
}
