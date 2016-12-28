package com.siweisoft.nurse.ui.app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.id.BaseID;
import com.siweisoft.base.ui.interf.OnNetFinishWithObjInter;
import com.siweisoft.base.ui.ope.BaseDBOpe;
import com.siweisoft.base.ui.ope.BaseNurseOpes;
import com.siweisoft.network.netadapter.OnNetWorkReqAdapter;
import com.siweisoft.nurse.ui.app.bean.dbbean.AppDBBean;
import com.siweisoft.nurse.ui.app.bean.netbean.AppReqBean;
import com.siweisoft.nurse.ui.app.ope.daope.AppsDAOpe;
import com.siweisoft.nurse.ui.app.ope.dbope.AppsDBOpe;
import com.siweisoft.nurse.ui.app.ope.netope.AppsNetOpe;
import com.siweisoft.nurse.ui.app.ope.uiope.AppsUIOpe;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.util.fragment.FragManager;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-12-21.
 */

public class AppsFrag extends BaseNurseFrag<AppsUIOpe,AppsNetOpe,BaseDBOpe,AppsDAOpe>{


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();
        AppReqBean baseReqBean =new AppReqBean();
        baseReqBean.setCredential("EBF8B1C43666A369B5E323D04C058F81");
        baseReqBean.setIdentifier("18965477896");
        baseReqBean.setIdentityType("1");
        baseReqBean.setUName("");
        getOpe().getBaseNetOpe().onNetLoadData(activity, "TCUser/LoginUser", baseReqBean, new OnNetWorkReqAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {

            }
        });
    }

    public void getData(){
        getOpe().getBaseDAOpe().getOrQuery(new OnNetFinishWithObjInter() {
            @Override
            public void onNetFinish(Object o) {
                getOpe().getBaseNurseUIOpe().initList(getOpe().getBaseDAOpe().getAppDABean());
            }
        });
    }


    @Override
    public int getContainView() {
        return R.layout.frag_apps;
    }

    @Override
    public BaseNurseOpes<AppsUIOpe, AppsNetOpe, BaseDBOpe, AppsDAOpe> getOpe() {
        if(baseNurseOpes==null){
            baseNurseOpes = new BaseNurseOpes(new AppsUIOpe(activity,getView()),new AppsNetOpe(activity),new AppsDBOpe(activity,new AppDBBean()),new AppsDAOpe(activity));
        }
        return baseNurseOpes;
    }

    @OnClick({BaseID.ID_MID})
    public void onClick(View v){
        switch (v.getId()){
            case BaseID.ID_MID:
                FragManager.getInstance().startFragment(getFragmentManager(),index,new AppGroupFrag());
                break;
        }
    }
}