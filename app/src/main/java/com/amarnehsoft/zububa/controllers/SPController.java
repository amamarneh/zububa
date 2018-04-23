package com.amarnehsoft.zububa.controllers;

import android.content.Context;
import android.content.SharedPreferences;

import com.amarnehsoft.zububa.model.BaseModel;
import com.amarnehsoft.zububa.model.Post;

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

    public static void setLike(Context context, BaseModel model){
        SharedPreferences sp =  context.getSharedPreferences("model_likes",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(model.getCode(),true);
        editor.apply();
    }
    public static boolean isLiked(Context context, BaseModel model){
        SharedPreferences sp =  context.getSharedPreferences("model_likes",Context.MODE_PRIVATE);
        return sp.getBoolean(model.getCode(),false);
    }

}
