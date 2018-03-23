package com.amarnehsoft.zububa.core;

import android.app.Application;

import com.amarnehsoft.zububa.utils.SystemUtils;
import com.amarnehsoft.zububa.webapi.WebService;

/**
 * Created by ALa on 3/18/2018.
 */

public class FireApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        // initialize WebService
        WebService.init(getApplicationContext());
    }
}
