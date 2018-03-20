package com.amarnehsoft.zububa.webapi;

import com.amarnehsoft.zububa.model.Baby;
import com.amarnehsoft.zububa.model.Blog;
import com.amarnehsoft.zububa.model.GalleryItem;
import com.amarnehsoft.zububa.model.Taxi;
import com.amarnehsoft.zububa.model.Wedding;
import com.amarnehsoft.zububa.webapi.callBacks.ICallBack;

/**
 * Created by ALa on 3/17/2018.
 */

public interface WebApi {
    void getBlog(ICallBack<Blog> callBack); // get list of blog from web server
    void getTaxiList(ICallBack<Taxi> callBack); // get list of taxi contacts
    void getWeddings(ICallBack<Wedding> callBack); // get list of weddings
    void getGallery(ICallBack<GalleryItem> callBack); // get list of gallery items
    void getBabies(ICallBack<Baby> callBack); // get list of babies
    // ..
}
