package com.amarnehsoft.zububa.core;

import android.app.Application;

import com.amarnehsoft.zububa.data.webapi.WebDummy;
import com.amarnehsoft.zububa.data.webapi.WebService;

/**
 * Created by ALa on 3/18/2018.
 */

public class FireApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        // initialize WebService
        WebService.init(getApplicationContext());
        WebDummy.init(getApplicationContext());
    }
}
