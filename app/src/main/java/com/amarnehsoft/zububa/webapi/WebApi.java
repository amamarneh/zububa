package com.amarnehsoft.zububa.webapi;

import com.amarnehsoft.zububa.model.Baby;
import com.amarnehsoft.zububa.model.FBModels.FBBaby;
import com.amarnehsoft.zububa.model.FBModels.FBBlog;
import com.amarnehsoft.zububa.model.FBModels.FBGalleryItem;
import com.amarnehsoft.zububa.model.FBModels.FBTaxi;
import com.amarnehsoft.zububa.model.FBModels.FBWedding;

import java.util.List;

/**
 * Created by ALa on 3/17/2018.
 */

public interface WebApi {
    void getBlog(ICallBack<FBBlog> callBack); // get list of blog from web server
    void getTaxiList(ICallBack<FBTaxi> callBack); // get list of taxi contacts
    void getWeddings(ICallBack<FBWedding> callBack); // get list of weddings
    void getGallery(ICallBack<FBGalleryItem> callBack); // get list of gallery items
    void getBabies(ICallBack<FBBaby> callBack); // get list of babies
    // ..
}
