package com.leon.taobaodetailmock;

import android.app.Application;

/**
 * <br> ClassName: MyApplication
 * <br> Description: 自定义Application
 *
 * <br> Author: hemin
 * <br> Date: 2017/11/30 18:16
 */
public class MyApplication extends Application {

    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static MyApplication getInstance(){
        return instance;
    }
}
