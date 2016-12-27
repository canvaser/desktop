package com.siweisoft.nurse.ui.app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

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
import com.siweisoft.nurse.ui.app.ope.daope.AppDAOpe;
import com.siweisoft.nurse.ui.app.ope.uiope.AppUIOpe;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFragWithoutTitle;
import com.siweisoft.nurse.util.fragment.FragManager;
import com.siweisoft.util.IntentUtil;
import com.siweisoft.util.SheetDialogUtil;
import com.siweisoft.view.bottomdialogmenuview.BottomDialogMenuView;

import java.util.ArrayList;

import butterknife.OnClick;

/**
 * Created by ${viwmox} on 2016-12-27.
 */

public class AppFrag extends BaseNurseFragWithoutTitle<AppUIOpe,BaseNetOpe,BaseDBOpe,AppDAOpe>
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
    public BaseNurseOpes<AppUIOpe, BaseNetOpe, BaseDBOpe, AppDAOpe> getOpe() {
        if(baseNurseOpes==null){
            baseNurseOpes = new BaseNurseOpes(new AppUIOpe(activity,getView()),new BaseNetOpe(activity),null,new AppDAOpe(activity));
        }
        return baseNurseOpes;
    }

    @Override
    public int getContainView() {
        return R.layout.frag_app;
    }

    @Override
    public void onAppItemLongClick(View view, int position) {
        BottomDialogMenuView bottomDialogMenuView = new BottomDialogMenuView(activity,new String[]{"卸载","删除","添加组","加入组"});
        SheetDialogUtil.getInstance().showBottomSheet(activity, bottomDialogMenuView, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onAppItemClick(View view, int position) {
        IntentUtil.getInstance().IntentTo(activity,((AppAdapter)getOpe().getBaseNurseUIOpe().getRecyclerView().getAdapter()).getData().get(position).getPackageName());
    }

}
