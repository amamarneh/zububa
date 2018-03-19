package com.amarnehsoft.zububa.webapi;

import android.content.Context;

import com.amarnehsoft.zububa.webapi.fb.FBConstants;
import com.amarnehsoft.zububa.model.FBModels.FBBaby;
import com.amarnehsoft.zububa.model.FBModels.FBBlog;
import com.amarnehsoft.zububa.model.FBModels.FBGalleryItem;
import com.amarnehsoft.zububa.model.FBModels.FBTaxi;
import com.amarnehsoft.zububa.model.FBModels.FBWedding;
import com.amarnehsoft.zububa.webapi.fb.FBFactory;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    public void getBlog(final ICallBack<FBBlog> callBack) {
        FBFactory.getBlogApi(true).getList(callBack);
    }

    @Override
    public void getTaxiList(final ICallBack<FBTaxi> callBack) {
        FBFactory.getTaxiApi(true).getList(callBack);
    }

    @Override
    public void getWeddings(final ICallBack<FBWedding> callBack) {
        FBFactory.getWeddingFBApi(true).getList(callBack);
    }

    @Override
    public void getGallery(final ICallBack<FBGalleryItem> callBack) {
        FBFactory.getGalleryFBApi(true).getList(callBack);
    }

    @Override
    public void getBabies(final ICallBack<FBBaby> callBack) {
        FBFactory.getBabyFBApi(true).getList(callBack);
    }
}
