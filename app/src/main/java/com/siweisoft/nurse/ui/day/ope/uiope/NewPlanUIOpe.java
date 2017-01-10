package com.siweisoft.nurse.ui.day.ope.uiope;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.siweisoft.app.R;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.util.NullUtil;
import com.siweisoft.util.StringUtil;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-01-06.
 */

public class NewPlanUIOpe extends BaseNurseUIOpe{

    @BindView(R.id.tv_start)
    TextView startTV;

    @BindView(R.id.tv_end)
    TextView endTV;

    @BindView(R.id.et_content)
    EditText contentET;


    public NewPlanUIOpe(Context context, View containerView) {
        super(context, containerView);
        init();
    }

    private void init(){
        getMidTV().setText("添加");
        getMidTV().setVisibility(View.VISIBLE);
        getRightTV().setVisibility(View.VISIBLE);
        getRightTV().setText("确定");
    }

    public boolean meetCondition(){
        return NullUtil.isStrEmpty(startTV.getText().toString()) || NullUtil.isStrEmpty(endTV.getText().toString()) ||NullUtil.isStrEmpty(contentET.getText().toString()) ;
    }

    public EditText getContentET() {
        return contentET;
    }

    public void setContentET(EditText contentET) {
        this.contentET = contentET;
    }

    public TextView getEndTV() {
        return endTV;
    }

    public void setEndTV(TextView endTV) {
        this.endTV = endTV;
    }

    public TextView getStartTV() {
        return startTV;
    }

    public void setStartTV(TextView startTV) {
        this.startTV = startTV;
    }
}
