package com.siweisoft.nurse.ui.calendar.ope.uiope;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.siweisoft.app.R;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-01-24.
 */
public class AddDayRecordUIOpe extends BaseNurseUIOpe {

    @BindView(R.id.et_addrecord)
    EditText addET;


    @BindView(R.id.iv_image)
    ImageView imageIV;

    public AddDayRecordUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init() {
        getRightTV().setText("完成");

    }

    public boolean isFit(){
        return !TextUtils.isEmpty(addET.getText());
    }


    public EditText getAddET() {
        return addET;
    }

    public ImageView getImageIV() {
        return imageIV;
    }
}
