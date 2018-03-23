package com.amarnehsoft.zububa.controllers;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by user on 3/22/2018.
 */

public class SPController {
    private static final String SP_NAME = "name";

    private static final String ARG_LAST_NAME = "lastName";

    private SharedPreferences mSharedPreferences;

    public static SPController getInstance(Context context){
        SPController controller = new SPController(context);
        return controller;
    }

    private SPController(Context context){
        mSharedPreferences = context.getApplicationContext().getSharedPreferences(SP_NAME,Context.MODE_PRIVATE);
    }

    public String getLastName(){
        return mSharedPreferences.getString(ARG_LAST_NAME,"");
    }

    public void setLastName(String value){
        mSharedPreferences.edit().putString(ARG_LAST_NAME,value).apply();
    }
}
