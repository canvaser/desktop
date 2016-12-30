package com.siweisoft.nurse.ui.day.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.ope.BaseDAOpe;
import com.siweisoft.base.ui.ope.BaseDBOpe;
import com.siweisoft.base.ui.ope.BaseNetOpe;
import com.siweisoft.base.ui.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.day.ope.uiope.DayUIOpe;

/**
 * Created by ${viwmox} on 2016-12-21.
 */

public class DayFrag extends BaseNurseFrag<DayUIOpe,BaseNetOpe,BaseDBOpe,BaseDAOpe>{

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getOpe().getBaseNurseUIOpe().init(fragment);
    }

    @Override
    public BaseNurseOpes<DayUIOpe,BaseNetOpe,BaseDBOpe,BaseDAOpe> getOpe() {
        if(baseNurseOpes==null){
            baseNurseOpes =new BaseNurseOpes(new DayUIOpe(activity,getView()),new BaseNetOpe(activity),null,null);
        }
        return baseNurseOpes;
    }

    @Override
    public int getContainView() {
        return R.layout.frag_day;
    }
}
