package com.siweisoft.nurse.ui.calendar.fragment;

import android.content.Intent;
import android.provider.Settings;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.id.BaseID;
import com.siweisoft.base.ui.interf.OnFinishListener;
import com.siweisoft.base.ui.ope.BaseDAOpe;
import com.siweisoft.base.ui.ope.BaseDBOpe;
import com.siweisoft.base.ui.ope.BaseNetOpe;
import com.siweisoft.base.ui.ope.BaseNurseOpes;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.calendar.ope.daope.AddDayRecordDAOpe;
import com.siweisoft.nurse.ui.calendar.ope.netope.CalendarNetOpe;
import com.siweisoft.nurse.ui.calendar.ope.uiope.AddDayRecordUIOpe;
import com.siweisoft.nurse.util.fragment.FragManager;
import com.siweisoft.util.BitmapUtil;
import com.siweisoft.util.IntentUtil;
import com.siweisoft.util.LoadUtil;
import com.siweisoft.util.LogUtil;
import com.siweisoft.util.dialog.DialogUtil;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2017-01-24.
 */

public class AddDayRecordFrag extends BaseNurseFrag<AddDayRecordUIOpe,CalendarNetOpe,BaseDBOpe,AddDayRecordDAOpe>{


    @Override
    public BaseNurseOpes<AddDayRecordUIOpe, CalendarNetOpe, BaseDBOpe, AddDayRecordDAOpe> getOpe() {
        if(baseNurseOpes==null){
            baseNurseOpes = new BaseNurseOpes(new AddDayRecordUIOpe(activity,getView()),new CalendarNetOpe(activity),null,new AddDayRecordDAOpe(activity));
        }
        return baseNurseOpes;
    }

    @OnClick({BaseID.ID_RIGHT,R.id.iv_image})
    public void onClick(View v){
        switch (v.getId()){
            case BaseID.ID_RIGHT:
                LogUtil.E(System.currentTimeMillis());
                if(!getOpe().getBaseNurseUIOpe().isFit()){
                    return;
                }
                LoadUtil.getInstance().onStartLoading(activity,AddDayRecordFrag.class.getName());
                getOpe().getBaseNetOpe().addRecord(getOpe().getBaseNurseUIOpe().getAddET().getText().toString(), getOpe().getBaseDAOpe().getUrl(),new OnFinishListener() {
                    @Override
                    public void onFinish(Object o) {
                        LogUtil.E(System.currentTimeMillis());
                        DayRecordFrag dayRecordFrag = (DayRecordFrag) FragManager.getInstance().getFragMaps().get(3).get(0);
                        getOpe().getBaseNurseUIOpe().getAddET().setText("");
                        getOpe().getBaseDAOpe().setUrl(null);
                        getOpe().getBaseNurseUIOpe().getImageIV().setImageDrawable(null);
                        dayRecordFrag.getOpe().getBaseNurseUIOpe().getViewPager().setCurrentItem(1);
                        LoadUtil.getInstance().onStopLoading(AddDayRecordFrag.class.getName());
                    }
                });
                break;
            case R.id.iv_image:
                IntentUtil.getInstance().photoShowFromphone(fragment, ValueConstant.CODE_REQUSET);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case ValueConstant.CODE_REQUSET:
                if(data==null || data.getData()==null){
                    return ;
                }
                getOpe().getBaseDAOpe().setUrl(data.getData());
                BitmapUtil.getInstance().setBg(activity,getOpe().getBaseNurseUIOpe().getImageIV(),getOpe().getBaseDAOpe().getUrl());
                break;
        }
    }

    @Override
    public int getContainView() {
        return R.layout.frag_addrecord;
    }
}
