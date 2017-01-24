package com.siweisoft.nurse.ui.calendar.ope.uiope;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.fragment.BaseFrg;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.calendar.adapter.DayRecordPagerAdapter;
import com.siweisoft.nurse.ui.calendar.fragment.AddDayRecordFrag;
import com.siweisoft.nurse.ui.calendar.fragment.CalendarFrag;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-01-24.
 */
public class DayRecordUIOpe extends BaseNurseUIOpe {

    @BindView(R.id.vp_vp)
    ViewPager viewPager;

    public DayRecordUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init() {

    }

    public void initPager(Fragment f){
        ArrayList<BaseFrg> frags = new ArrayList<>();
        frags.add(new AddDayRecordFrag());
        frags.add(new CalendarFrag());
        viewPager.setAdapter(new DayRecordPagerAdapter(f.getChildFragmentManager(),context,frags));
    }


    public ViewPager getViewPager() {
        return viewPager;
    }

}
