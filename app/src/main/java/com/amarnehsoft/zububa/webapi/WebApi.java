package com.amarnehsoft.zububa.webapi;

import com.amarnehsoft.zububa.ICallBack;
import com.amarnehsoft.zububa.model.Baby;
import com.amarnehsoft.zububa.model.Blog;
import com.amarnehsoft.zububa.model.GalleryItem;
import com.amarnehsoft.zububa.model.Taxi;
import com.amarnehsoft.zububa.model.Wedding;

import java.util.List;

/**
 * Created by ALa on 3/17/2018.
 */

public interface WebApi {
    void getBlog(ICallBack<List<Blog>> callBack); // get list of blog from web server
    void getTaxiList(ICallBack<List<Taxi>> callBack); // get list of taxi contacts
    void getWeddings(ICallBack<List<Wedding>> callBack); // get list of weddings
    void getGallery(ICallBack<List<GalleryItem>> callBack); // get list of gallery items
    void getBabies(ICallBack<List<Baby>> callBack); // get list of babies
    // ..
}
