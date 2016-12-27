package com.siweisoft.nurse.ui.app.bean.uibean;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.bean.uibean.BaseUIBean;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2016-12-26.
 */

public class AppUIBean extends BaseUIBean{

    @BindView(R.id.tv_app)
    TextView appTV;

    @BindView(R.id.iv_icon)
    ImageView appIV;



    public AppUIBean(Context context, View convertView) {
        super(context, convertView);

    }

    public TextView getAppTV() {
        return appTV;
    }

    public ImageView getAppIV() {
        return appIV;
    }
}
