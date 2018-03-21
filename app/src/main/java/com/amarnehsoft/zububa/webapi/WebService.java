package com.amarnehsoft.zububa.webapi;

import android.content.Context;

import com.amarnehsoft.zububa.model.Baby;
import com.amarnehsoft.zububa.model.Blog;
import com.amarnehsoft.zububa.model.GalleryItem;
import com.amarnehsoft.zububa.model.Taxi;
import com.amarnehsoft.zububa.model.Wedding;
import com.amarnehsoft.zububa.webapi.callBacks.ICallBack;
import com.amarnehsoft.zububa.webapi.callBacks.IListCallBack;
import com.amarnehsoft.zububa.webapi.fb.FBFactory;

/**
 * Created by ALa on 3/17/2018.
 */

/**
 * WebApi implementations
 */
public class WebService implements WebApi{
    private static WebService instance;
    private Context mContext;

    // initializing
    public static void init(Context context){
        if(instance == null)
            instance = new WebService(context);
    }

    public WebService(Context mContext) {
        this.mContext = mContext;
    }
    public static WebService getInstance(){return instance;}


    @Override
    public void getBlog(final IListCallBack<Blog> callBack) {
        FBFactory.getBlogApi(true).getList(callBack);
    }

    @Override
    public void getTaxiList(final IListCallBack<Taxi> callBack) {
        FBFactory.getTaxiApi(true).getList(callBack);
    }

    @Override
    public void getWeddings(final IListCallBack<Wedding> callBack) {
        FBFactory.getWeddingFBApi(true).getList(callBack);
    }

    @Override
    public void getGallery(final IListCallBack<GalleryItem> callBack) {
        FBFactory.getGalleryFBApi(true).getList(callBack);
    }

    @Override
    public void getBabies(final IListCallBack<Baby> callBack) {
        FBFactory.getBabyFBApi(true).getList(callBack);
    }
}
