package com.siweisoft.nurse.ui.app.bean.uibean;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-12-27.
 */

public class AppsUIBean extends BaseUIBean{

    @BindView(R.id.recycle)
    RecyclerView recyclerView;

    public AppsUIBean(Context context, View convertView) {
        super(context, convertView);
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }
}
