package com.siweisoft.nurse.ui.day.fragment;

import android.os.Bundle;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.ope.BaseDAOpe;
import com.siweisoft.base.ui.ope.BaseDBOpe;
import com.siweisoft.base.ui.ope.BaseNetOpe;
import com.siweisoft.base.ui.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFragWithoutTitle;
import com.siweisoft.nurse.ui.day.ope.uiope.LeftDayUIOpe;

/**
 * Created by ${viwmox} on 2016-12-30.
 */

public class LeftDayFrag extends BaseNurseFragWithoutTitle<LeftDayUIOpe,BaseNetOpe,BaseDBOpe,BaseDAOpe>{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getOpe().getBaseNurseUIOpe().initList();
    }

    @Override
    public int getContainView() {
        return R.layout.frag_leftday;
    }

    @Override
    public BaseNurseOpes<LeftDayUIOpe, BaseNetOpe, BaseDBOpe, BaseDAOpe> getOpe() {
        if(baseNurseOpes==null){
            baseNurseOpes = new BaseNurseOpes(new LeftDayUIOpe(activity,getView()),null,null,null);
        }
        return baseNurseOpes;
    }
}
