package com.siweisoft.nurse.ui.app.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.id.BaseID;
import com.siweisoft.base.ui.interf.view.OnAppItemClickListener;
import com.siweisoft.base.ui.interf.view.OnAppItemLongClickListener;
import com.siweisoft.base.ui.ope.BaseDBOpe;
import com.siweisoft.base.ui.ope.BaseNetOpe;
import com.siweisoft.base.ui.ope.BaseNurseOpes;
import com.siweisoft.constant.ValueConstant;
import com.siweisoft.nurse.ui.app.adapter.AppAdapter;
import com.siweisoft.nurse.ui.app.bean.dbbean.AppDBBean;
import com.siweisoft.nurse.ui.app.bean.dbbean.AppGroupDBBean;
import com.siweisoft.nurse.ui.app.ope.daope.AppDAOpe;
import com.siweisoft.nurse.ui.app.ope.dbope.AppsDBOpe;
import com.siweisoft.nurse.ui.app.ope.dbope.AppsGroupDBOpe;
import com.siweisoft.nurse.ui.app.ope.uiope.AppUIOpe;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFragWithoutTitle;
import com.siweisoft.nurse.util.fragment.FragManager;
import com.siweisoft.util.IntentUtil;
import com.siweisoft.util.LogUtil;
import com.siweisoft.util.SheetDialogUtil;
import com.siweisoft.view.bottomdialogmenuview.BottomDialogMenuView;

import java.util.ArrayList;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-12-27.
 */

public class AppFrag extends BaseNurseFragWithoutTitle<AppUIOpe,BaseNetOpe,AppsDBOpe,AppDAOpe>
        implements OnAppItemLongClickListener,OnAppItemClickListener{


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AppsFrag appsFrag = (AppsFrag) FragManager.getInstance().getFragMaps().get(2).get(FragManager.getInstance().getFragMaps().get(2).size()-1);
        getOpe().getBaseDAOpe().setData(appsFrag.getOpe().getBaseDAOpe().getAppDABean().getData().get(getArguments().getString(ValueConstant.DATA_DATA)));
        getOpe().getBaseNurseUIOpe().initList(getOpe().getBaseDAOpe().getData());
        ((AppAdapter)getOpe().getBaseNurseUIOpe().getRecyclerView().getAdapter()).setLongClickListener(this);
        ((AppAdapter)getOpe().getBaseNurseUIOpe().getRecyclerView().getAdapter()).setOnAppItemClickListener(this);
    }

    @Override
    public BaseNurseOpes<AppUIOpe, BaseNetOpe, AppsDBOpe, AppDAOpe> getOpe() {
        if(baseNurseOpes==null){
            baseNurseOpes = new BaseNurseOpes(new AppUIOpe(activity,getView()),new BaseNetOpe(activity),new AppsDBOpe(activity,new AppDBBean()),new AppDAOpe(activity));
        }
        return baseNurseOpes;
    }

    @Override
    public int getContainView() {
        return R.layout.frag_app;
    }

    @Override
    public void onAppItemLongClick(View view, final int position) {
        final AppDBBean appDBBean = (AppDBBean) view.getTag(R.id.data);
        BottomDialogMenuView bottomDialogMenuView = new BottomDialogMenuView(activity,getOpe().getBaseDAOpe().getList(activity));
        SheetDialogUtil.getInstance().showBottomSheet(activity, bottomDialogMenuView, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) v;
                String str = tv.getText().toString();
                if(str.startsWith("添加到")){
                    String ss = str.substring(3,str.length());
                    getOpe().getBaseDBOpe().add(ss,appDBBean.getAppName(),appDBBean.getPackageName());
                    AppsFrag appsFrag = (AppsFrag) FragManager.getInstance().getFragMaps().get(2).get(FragManager.getInstance().getFragMaps().get(index).size()-1);
                    appsFrag.getData();
                }
                switch (str){
                    case "换图":
                        IntentUtil.getInstance().photoShowFromphone(fragment, ValueConstant.CODE_REQUSET);
                        getOpe().getBaseDAOpe().setItem(getOpe().getBaseDAOpe().getData().get(position));
                        break;
                    case "删除":
                        getOpe().getBaseDBOpe().delete(getOpe().getBaseDAOpe().getData().get(position).getId());
                        AppsFrag appsFrag = (AppsFrag) FragManager.getInstance().getFragMaps().get(2).get(FragManager.getInstance().getFragMaps().get(index).size()-1);
                        appsFrag.getData();
                        break;
                }
                SheetDialogUtil.getInstance().dismess();
            }
        });
    }

    @Override
    public void onAppItemClick(View view, int position) {
        IntentUtil.getInstance().IntentTo(activity,((AppAdapter)getOpe().getBaseNurseUIOpe().getRecyclerView().getAdapter()).getData().get(position).getPackageName());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case ValueConstant.CODE_REQUSET:
                if(data==null || data.getData()==null){
                    return ;
                }
                AppDBBean appDBBean = getOpe().getBaseDAOpe().getItem();
                getOpe().getBaseDBOpe().updateIcon(appDBBean.getId(),data.getDataString());
                AppsFrag appsFrag = (AppsFrag) FragManager.getInstance().getFragMaps().get(2).get(FragManager.getInstance().getFragMaps().get(index).size()-1);
                appsFrag.getData();
                break;
        }
    }

}
