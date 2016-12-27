package com.siweisoft.nurse.ui.app.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.siweisoft.app.R;
import com.siweisoft.base.ui.adapter.AppPagerAdapter;
import com.siweisoft.nurse.ui.app.bean.dabean.AppDABean;
import com.siweisoft.nurse.ui.app.bean.uibean.AppHeadUIBean;
import com.siweisoft.nurse.ui.app.bean.uibean.AppUIBean;
import com.siweisoft.nurse.ui.app.bean.uibean.AppsUIBean;
import com.siweisoft.view.pinnedheaderexpandablelistview.expandable.ui.PinnedHeaderExpandableListView;

import java.util.ArrayList;

/**
 * Created by ${viwmox} on 2016-12-21.
 */

public class AppsAdapter extends AppPagerAdapter{

    public AppsAdapter(FragmentManager fm, Context context, ArrayList<Fragment> fragments) {
        super(fm, context, fragments);
    }
}
