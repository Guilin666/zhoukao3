package bwie.example.com.guilin20181119.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import bwie.example.com.guilin20181119.greendao.DaoMaster;
import bwie.example.com.guilin20181119.greendao.DaoSession;
import bwie.example.com.guilin20181119.model.DataBean;

public class GreenSqlUtils {

    private SQLiteDatabase dp;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    public GreenSqlUtils(Context context) {
        init(context);
    }

    public void init(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "lin");
        dp = helper.getWritableDatabase();
        daoMaster = new DaoMaster(dp);
        daoSession = daoMaster.newSession();
    }

    public void insert(DataBean dataBean) {
        daoSession.getDataBeanDao().insert(dataBean);
    }

    public List<DataBean> selectAll() {
        return daoSession.getDataBeanDao().loadAll();
    }

    public void deleteAll() {
        daoSession.getDataBeanDao().deleteAll();
    }


}