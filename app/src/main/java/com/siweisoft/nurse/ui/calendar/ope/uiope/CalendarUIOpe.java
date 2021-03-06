package com.siweisoft.nurse.ui.calendar.ope.uiope;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.joybar.librarycalendar.adapter.CalendarViewPagerAdapter;
import com.joybar.librarycalendar.fragment.CalendarViewFragment;
import com.joybar.librarycalendar.fragment.CalendarViewPagerFragment;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.siweisoft.app.R;
import com.siweisoft.base.ui.interf.OnFinishListener;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.calendar.adapter.CalendarListAdapter;
import com.siweisoft.nurse.ui.calendar.bean.netbean.DayBean;
import com.siweisoft.util.FragmentUtil;
import com.siweisoft.util.LogUtil;
import com.siweisoft.view.ItemDecoration.MyItemDecoration;
import com.siweisoft.view.ItemDecoration.MyItemDecoration2;
import com.siweisoft.view.refreshlayout.MaterialRefreshLayout;

import java.util.Calendar;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-01-23.
 */
public class CalendarUIOpe extends BaseNurseUIOpe {


    @BindView(R.id.calendarView)
    MaterialCalendarView calendarPickerView;

    @BindView(R.id.recycle)
    RecyclerView recyclerView;

    @BindView(R.id.refresh)
    MaterialRefreshLayout refreshLayout;

    public CalendarUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    public void init() {
        getMidTV().setText("日程");
        getBackTV().setVisibility(View.VISIBLE);
        getBackTV().setText("+");
        getRightTV().getLayoutParams().width= ValueConstant.DIMEN_1*25;
        getRightTV().getLayoutParams().height= ValueConstant.DIMEN_1*25;
        getRightTV().requestLayout();
        getRightTV().setBackgroundResource(R.drawable.drawable_esccol);

        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);
        getCalendarPickerView().state().edit()
                .setFirstDayOfWeek(Calendar.WEDNESDAY)
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();

    }

    public void coll(){
        getCalendarPickerView().state().edit()
                .setFirstDayOfWeek(Calendar.WEDNESDAY)
                .setCalendarDisplayMode(CalendarMode.WEEKS)
                .commit();

    }

    public void expand(){
        getCalendarPickerView().state().edit()
                .setFirstDayOfWeek(Calendar.WEDNESDAY)
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();

    }

    public void initTitle(int year,int month){
        getMidTV().setText(""+year+"-"+month);
    }




    public void initList(List<DayBean> data){
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new CalendarListAdapter(context,data));
    }



    public RecyclerView getRecyclerView() {
        return recyclerView;
    }


    @Nullable
    @Override
    public MaterialRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }

    public MaterialCalendarView getCalendarPickerView() {
        return calendarPickerView;
    }
}
