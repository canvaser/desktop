package com.siweisoft.nurse.ui.day.ope.uiope;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.activity.BaseActivity;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.day.adapter.DayAdapter;
import com.siweisoft.nurse.ui.day.fragment.LeftDayFrag;
import com.siweisoft.nurse.ui.day.fragment.MidDayFrag;
import com.siweisoft.nurse.ui.day.fragment.RightDayFrag;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-12-30.
 */

public class DayUIOpe extends BaseNurseUIOpe{

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    public DayUIOpe(Context context, View containerView) {
        super(context, containerView);
    }

    public void init(Fragment fragment){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new LeftDayFrag());
        fragments.add(new MidDayFrag());
        fragments.add(new RightDayFrag());
        viewPager.setAdapter(new DayAdapter(fragment.getChildFragmentManager(),context,fragments));
    }

    public ViewPager getViewPager() {
        return viewPager;
    }
}
