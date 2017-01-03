package com.siweisoft.nurse.ui.day.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.adapter.AppRecycleAdapter;
import com.siweisoft.nurse.ui.day.bean.uibean.LeftDayUIBean;

/**
 * Created by ${viwmox} on 2017-01-03.
 */

public class LeftDayAdapter extends AppRecycleAdapter{




    public LeftDayAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.list_left_day,parent,false);
        LeftDayUIBean uiBean = new LeftDayUIBean(context,v);
        return uiBean;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        LeftDayUIBean uiBean = (LeftDayUIBean) holder;
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public void onClick(View v) {

    }
}
