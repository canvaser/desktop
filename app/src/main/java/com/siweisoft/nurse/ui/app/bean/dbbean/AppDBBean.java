package com.siweisoft.nurse.ui.app.bean.dbbean;

import android.graphics.drawable.Drawable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.siweisoft.base.ui.bean.dbbean.BaseDbBean;

/**
 * Created by ${viwmox} on 2016-12-26.
 */

@DatabaseTable(tableName = "table_apps")
public class AppDBBean extends BaseDbBean{

    public static final String GROUPNAME ="groupName";
    @DatabaseField(columnName = GROUPNAME)
    private String groupName;

    public static final String APPNAME ="appName";
    @DatabaseField(columnName = APPNAME)
    private String appName;

    public static final String PACKAGENAME ="packageName";
    @DatabaseField(columnName = PACKAGENAME)
    private String packageName;

    private Drawable icon;

    public AppDBBean() {
    }

    public AppDBBean(String groupName, String appName, String packageName) {
        this.groupName = groupName;
        this.appName = appName;
        this.packageName = packageName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
}