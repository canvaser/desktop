package com.siweisoft.nurse.ui.day.ope.uiope;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.siweisoft.app.R;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;
import com.siweisoft.nurse.ui.day.adapter.LeftDayAdapter;

import butterknife.BindView;

/**
 * Created by ${viwmox} on 2017-01-03.
 */

public class MidDayUIOpe extends BaseNurseUIOpe{

    @BindView(R.id.recycle)
    RecyclerView recyclerView;


    public MidDayUIOpe(Context context, View containerView) {
        super(context, containerView);
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void initList(){
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new LeftDayAdapter(context));
    }
}
