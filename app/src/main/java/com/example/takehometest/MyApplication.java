package com.example.takehometest;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by 서대원 on 2017-04-13.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
