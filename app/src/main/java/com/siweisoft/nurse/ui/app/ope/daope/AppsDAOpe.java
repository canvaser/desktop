package com.siweisoft.nurse.ui.app.ope.daope;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import com.siweisoft.base.ui.interf.OnNetFinishWithObjInter;
import com.siweisoft.base.ui.ope.BaseDAOpe;
import com.siweisoft.nurse.ui.app.bean.dabean.AppDABean;
import com.siweisoft.nurse.ui.app.bean.dbbean.AppDBBean;
import com.siweisoft.nurse.ui.app.bean.dbbean.AppGroupDBBean;
import com.siweisoft.nurse.ui.app.ope.dbope.AppsDBOpe;
import com.siweisoft.nurse.ui.app.ope.dbope.AppsGroupDBOpe;
import com.siweisoft.util.PackageUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${viwmox} on 2016-12-21.
 */

public class AppsDAOpe extends BaseDAOpe{


    AppsDBOpe appsDBOpe;

    AppsGroupDBOpe appsGroupDBOpe;

    AppDABean appDABean = new AppDABean();

    public AppsDAOpe(Context context) {
        super(context);
        appsDBOpe = new AppsDBOpe(context,new AppDBBean());
        appsGroupDBOpe = new AppsGroupDBOpe(context,new AppGroupDBBean());
    }

    public void getApps(final String type, final OnNetFinishWithObjInter ObjInter){
        PackageUtil.getInstance().getPackageInfoList(context, type, new OnNetFinishWithObjInter() {
            @Override
            public void onNetFinish(Object o) {
                List<ApplicationInfo> applicationInfos = (List<ApplicationInfo>) o;
                ArrayList<AppDBBean> appDBBeen = new ArrayList<AppDBBean>();
                for(int i=0;i<applicationInfos.size();i++){
                    AppDBBean a = new AppDBBean();
                    a.setGroupName(type);
                    a.setAppName(""+applicationInfos.get(i).loadLabel(context.getPackageManager()));
                    a.setPackageName(applicationInfos.get(i).packageName);
                    appDBBeen.add(a);
                }
                if(ObjInter!=null){
                    ObjInter.onNetFinish(appDBBeen);
                }
            }
        });
    }

    public AppDABean getOrQuery(final OnNetFinishWithObjInter objInter){
        appsGroupDBOpe.get();
        ArrayList<AppDBBean> sysList = appsDBOpe.get("系统");
        ArrayList<AppDBBean> userList = appsDBOpe.get("用户");
        if(sysList.size()==0){
            final ArrayList<AppDBBean> finalUserList = userList;
            getApps("系统",new OnNetFinishWithObjInter() {
                @Override
                public void onNetFinish(Object o) {
                    ArrayList<AppDBBean> appDBBeen= (ArrayList<AppDBBean>) o;
                    appsDBOpe.add(appDBBeen);
                    if(finalUserList.size()==0){
                        getApps("用户",new OnNetFinishWithObjInter() {
                            @Override
                            public void onNetFinish(Object o) {
                                ArrayList<AppDBBean> appDBBeen= (ArrayList<AppDBBean>) o;
                                appsDBOpe.add(appDBBeen);
                                appDABean.getData().put("系统", appsDBOpe.get("系统"));
                                appDABean.getData().put("用户", appsDBOpe.get("用户"));
                                objInter.onNetFinish(appDBBeen);
                            }
                        });
                    }
                }
            });
        }else{
            appDABean.getData().put("系统", appsDBOpe.get("系统"));
            appDABean.getData().put("用户", appsDBOpe.get("用户"));
            initIcon();
            objInter.onNetFinish(appDABean);
        }
        return appDABean;
    }

    public void initIcon(){
        String[] keys = new String[appDABean.getData().keySet().size()];
        keys = appDABean.getData().keySet().toArray(keys);
        PackageManager pm =context.getPackageManager();
        for(int i=0;i<keys.length;i++){
            ArrayList<AppDBBean> appDBBeen =appDABean.getData().get(keys[i]);
            for(int j=0;j<appDBBeen.size();j++){
                try {
                    appDBBeen.get(j).setIcon(pm.getApplicationIcon(appDBBeen.get(j).getPackageName()));
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public AppDABean getAppDABean() {
        return appDABean;
    }
}
