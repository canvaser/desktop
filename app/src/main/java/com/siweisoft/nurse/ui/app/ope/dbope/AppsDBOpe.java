package com.siweisoft.nurse.ui.app.ope.dbope;

import android.content.Context;

import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.siweisoft.base.ui.ope.BaseDBOpe;
import com.siweisoft.nurse.ui.app.bean.dbbean.AppDBBean;
import com.siweisoft.util.LogUtil;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-12-26.
 */

public class AppsDBOpe extends BaseDBOpe<AppDBBean>{


    public AppsDBOpe(Context context, AppDBBean appDBBean) {
        super(context, appDBBean);
    }

    public void add(String groupName,String appName,String packageName){
        AppDBBean appDBBean = new AppDBBean();
        appDBBean.setGroupName(groupName);
        appDBBean.setAppName(appName);
        appDBBean.setPackageName(packageName);
        try {
            daoOpe.create(appDBBean);
        } catch (SQLException e) {
            LogUtil.E(e.getMessage());
            e.printStackTrace();
        }
    }

    public void add(ArrayList<AppDBBean> arrayList){
        for(int i=0;i<arrayList.size();i++){
            add(arrayList.get(i).getGroupName(),arrayList.get(i).getAppName(),arrayList.get(i).getPackageName());
        }
    }

    public ArrayList<AppDBBean> get(){
        ArrayList<AppDBBean> list = new ArrayList<>();
        try {
            ArrayList<AppDBBean> ll = (ArrayList<AppDBBean>) daoOpe.queryForAll();
            if(ll!=null && ll.size()>0){
                list.addAll(ll);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<AppDBBean> get(String groupName){
        ArrayList<AppDBBean> list = new ArrayList<>();
        QueryBuilder queryBuilder = daoOpe.queryBuilder();
        Where where = queryBuilder.where();
        try {
            where.eq(AppDBBean.GROUPNAME,groupName);
            ArrayList<AppDBBean> ll = (ArrayList<AppDBBean>) queryBuilder.query();
            if(ll!=null && ll.size()>0){
                list.addAll(ll);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void delete(String groupName,String appName){
        DeleteBuilder deleteBuilder = daoOpe.deleteBuilder();
        Where where = deleteBuilder.where();
        try {
            where.and(where.eq(AppDBBean.GROUPNAME,groupName),where.eq(AppDBBean.APPNAME,appName));
            deleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
