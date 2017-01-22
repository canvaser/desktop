package com.siweisoft.nurse.ui.home.fragment;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.ope.BaseDAOpe;
import com.siweisoft.base.ui.ope.BaseDBOpe;
import com.siweisoft.base.ui.ope.BaseNetOpe;
import com.siweisoft.base.ui.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.home.ope.HomeUIOpe;

/**
 * Created by ${viwmox} on 2016-12-21.
 */

public class HomeFrag extends BaseNurseFrag<HomeUIOpe,BaseNetOpe,BaseDBOpe,BaseDAOpe>{


    @Override
    public int getContainView() {
        return R.layout.index_home;
    }

    @Override
    public BaseNurseOpes<HomeUIOpe, BaseNetOpe, BaseDBOpe, BaseDAOpe> getOpe() {
        if(baseNurseOpes==null){
            baseNurseOpes = new BaseNurseOpes(new HomeUIOpe(activity,getView()),null,null,null);
        }
        return baseNurseOpes;
    }
}
