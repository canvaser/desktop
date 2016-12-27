package com.siweisoft.nurse.ui.app.ope.daope;

import android.content.Context;

import com.siweisoft.base.ui.ope.BaseDAOpe;
import com.siweisoft.nurse.ui.app.bean.dbbean.AppDBBean;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-12-27.
 */

public class AppDAOpe extends BaseDAOpe{

    ArrayList<AppDBBean> data;

    public AppDAOpe(Context context) {
        super(context);
    }

    public ArrayList<AppDBBean> getData() {
        return data;
    }

    public void setData(ArrayList<AppDBBean> data) {
        this.data = data;
    }
}
