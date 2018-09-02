package com.bwie.main.zk1_lian02.app;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.bwie.main.zk1_lian02.bean.DaoMaster;
import com.bwie.main.zk1_lian02.bean.DaoSession;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by admin on 2018/9/2.
 */

public class app extends Application {

    private DaoSession daoSession;
    private static app app;

    @Override
    public void onCreate() {
        super.onCreate();
        //上下文
        app = app.this;
        //初始化
        Fresco.initialize(this);
        //获得具体事务
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"bwie");
        //获得可读可写数据库
        SQLiteDatabase db = helper.getWritableDatabase();
        //配置默认信息
        DaoMaster daoMaster = new DaoMaster(db);
        //做增删改查
        daoSession = daoMaster.newSession();
    }
    public static app getinstance(){
        if (app == null){
            app = new app();
        }
        return app;
    }
    //提供方法
    public DaoSession daoSession(){
        return daoSession;
    }
}
