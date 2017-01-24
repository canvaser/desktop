package com.siweisoft.nurse.ui.calendar.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;

import com.joybar.librarycalendar.data.CalendarDate;
import com.joybar.librarycalendar.fragment.CalendarViewFragment;
import com.joybar.librarycalendar.fragment.CalendarViewPagerFragment;
import com.siweisoft.app.R;
import com.siweisoft.base.ui.id.BaseID;
import com.siweisoft.base.ui.interf.OnFinishListener;
import com.siweisoft.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.base.ui.ope.BaseDBOpe;
import com.siweisoft.base.ui.ope.BaseNetOpe;
import com.siweisoft.base.ui.ope.BaseNurseOpes;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.calendar.adapter.CalendarListAdapter;
import com.siweisoft.nurse.ui.calendar.bean.netbean.DayBean;
import com.siweisoft.nurse.ui.calendar.ope.daope.CalendarDAOpe;
import com.siweisoft.nurse.ui.calendar.ope.netope.CalendarNetOpe;
import com.siweisoft.nurse.ui.calendar.ope.uiope.CalendarUIOpe;
import com.siweisoft.nurse.util.fragment.FragManager;
import com.siweisoft.util.ToastUtil;
import com.siweisoft.util.data.DateFormatUtil;
import com.siweisoft.view.refreshlayout.MaterialRefreshLayout;
import com.siweisoft.view.refreshlayout.MaterialRefreshListener;

import java.util.List;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-12-21.
 */

public class CalendarFrag extends BaseNurseFrag<CalendarUIOpe,CalendarNetOpe,BaseDBOpe,CalendarDAOpe> implements
        CalendarViewPagerFragment.OnPageChangeListener,
        CalendarViewFragment.OnDateClickListener,
        OnAppItemClickListener,
        CalendarViewFragment.OnDateCancelListener{


    @Override
    public int getContainView() {
        return R.layout.frag_calendar;
    }

    @Override
    public BaseNurseOpes<CalendarUIOpe, CalendarNetOpe, BaseDBOpe, CalendarDAOpe> getOpe() {
        if(baseNurseOpes==null){
            baseNurseOpes = new BaseNurseOpes(new CalendarUIOpe(activity,getView()),new CalendarNetOpe(activity),null,new CalendarDAOpe(activity));
        }
        return baseNurseOpes;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getOpe().getBaseNurseUIOpe().iniListener(this,this,this);
        getOpe().getBaseNurseUIOpe().getRefreshLayout().setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                getOpe().getBaseNetOpe().getNetRecordListWithDate(getOpe().getBaseDAOpe().getYear(),getOpe().getBaseDAOpe().getMonth(),getOpe().getBaseDAOpe().getDay(),new OnFinishListener() {
                    @Override
                    public void onFinish(Object o) {
                        List<DayBean> data = (List<DayBean>) o;
                        getOpe().getBaseNurseUIOpe().initList(data);
                        getOpe().getBaseNurseUIOpe().getRefreshLayout().finishRefresh();
                        ((CalendarListAdapter)getOpe().getBaseNurseUIOpe().getRecyclerView().getAdapter()).setOnAppItemClickListener(CalendarFrag.this);
                    }
                });
            }
        });
        getOpe().getBaseNurseUIOpe().getRefreshLayout().autoRefresh(500);
    }

    @OnClick({BaseID.ID_MID,BaseID.ID_RIGHT,BaseID.ID_BACK})
    public void onClick(View v){
        switch (v.getId()){
            case BaseID.ID_MID:
                if(getOpe().getBaseDAOpe().doubleClick(System.currentTimeMillis())){
                    getOpe().getBaseNurseUIOpe().init();
                    getOpe().getBaseNurseUIOpe().iniListener(this,this,this);
                }
                break;
            case BaseID.ID_RIGHT:
                v.setSelected(!v.isSelected());
                getOpe().getBaseNurseUIOpe().getCanlendarV().setVisibility(v.isSelected()?View.GONE:View.VISIBLE);
                break;
        }
    }


    @Override
    public void onDateClick(CalendarDate calendarDate) {

        int year = calendarDate.getSolar().solarYear;
        int month = calendarDate.getSolar().solarMonth;
        int day = calendarDate.getSolar().solarDay;
        ToastUtil.getInstance().show(activity,year+":"+month+":"+day);
        getOpe().getBaseDAOpe().setYear(year);
        getOpe().getBaseDAOpe().setMonth(month);
        getOpe().getBaseDAOpe().setDay(day);
        getOpe().getBaseNetOpe().getNetRecordListWithDate(year,month,day,new OnFinishListener() {
            @Override
            public void onFinish(Object o) {
                List<DayBean> data = (List<DayBean>) o;
                getOpe().getBaseNurseUIOpe().initList(data);
                getOpe().getBaseNurseUIOpe().getRefreshLayout().finishRefresh();
                ((CalendarListAdapter)getOpe().getBaseNurseUIOpe().getRecyclerView().getAdapter()).setOnAppItemClickListener(CalendarFrag.this);
            }
        });

    }

    @Override
    public void onDateCancel(CalendarDate calendarDate) {

    }

    @Override
    public void onPageChange(int year, int month) {
        getOpe().getBaseNurseUIOpe().initTitle(year,month);
    }

    @Override
    public void onAppItemClick(View view, int position) {
        DayBean dayBean = (DayBean) view.getTag(R.id.data);
        Bundle bundle = new Bundle();
        bundle.putSerializable(ValueConstant.DATA_DATA,dayBean);
        FragManager.getInstance().startFragment(activity.getSupportFragmentManager(),3,new DayRecordDetailFrag(),bundle);
    }
}
