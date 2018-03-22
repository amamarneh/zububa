package com.amarnehsoft.zububa.utils;

import android.content.Context;

/**
 * Created by user on 3/21/2018.
 */

public class SystemUtils {

    public static String getDeviceId(Context context){
        return DeviceUtils.getANDROID_ID(context);
    }

}
