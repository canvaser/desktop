package com.joybar.librarycalendar.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.joybar.librarycalendar.data.CalendarDate;
import com.joybar.librarycalendar.fragment.CalendarViewFragment;
import com.joybar.librarycalendar.utils.DateUtils;
import com.siweisoft.base.ui.fragment.NullUIFragment;
import com.siweisoft.util.LogUtil;


/**
 * Created by joybar on 4/27/16.
 */
public class CalendarViewPagerAdapter extends FragmentStatePagerAdapter{

    public static final int NUM_ITEMS = 200;
    public static final int NUM_ITEMS_CURRENT = NUM_ITEMS/2;
    private int mThisMonthPosition = DateUtils.getYear()*12+DateUtils.getMonth()-1;//---100 -position
    private int number = mThisMonthPosition - NUM_ITEMS_CURRENT;
    private boolean isChoiceModelSingle;
    CalendarViewFragment.OnDateClickListener onDateClickListener;
    CalendarViewFragment.OnDateCancelListener onDateCancelListener;
    public CalendarViewPagerAdapter(FragmentManager fm,boolean isChoiceModelSingle) {
        super(fm);
        this.isChoiceModelSingle = isChoiceModelSingle;
    }

    @Override
    public Fragment getItem(int position) {
        int year = getYearByPosition(position);
        int month = getMonthByPosition(position);
        CalendarViewFragment fragment = CalendarViewFragment.newInstance(year,month,isChoiceModelSingle);
        fragment.setOnDateCancelListener(onDateCancelListener);
        fragment.setOnDateClickListener(onDateClickListener);
//        Fragment fragment = new NullUIFragment();
        return  fragment;
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    public int getYearByPosition(int position){
        int year = (position+number)/12;
        return year;
    }
    public  int getMonthByPosition(int position){
        int month = (position + number) % 12 + 1;
        return month;
    }


    public void setOnDateCancelListener(CalendarViewFragment.OnDateCancelListener onDateCancelListener) {
        this.onDateCancelListener = onDateCancelListener;
    }

    public void setOnDateClickListener(CalendarViewFragment.OnDateClickListener onDateClickListener) {
        this.onDateClickListener = onDateClickListener;
    }
}
