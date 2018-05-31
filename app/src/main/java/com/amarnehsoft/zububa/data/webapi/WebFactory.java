package com.amarnehsoft.zububa.data.webapi;

/**
 * Created by ALa on 3/22/2018.
 */

public class WebFactory {
    public static WebApi getWebService(){
        return WebDummy.getInstance();
    }
}
