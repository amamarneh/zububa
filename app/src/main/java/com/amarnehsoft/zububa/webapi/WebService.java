package com.amarnehsoft.zububa.webapi;

import android.content.Context;

import com.amarnehsoft.zububa.ICallBack;
import com.amarnehsoft.zububa.model.Baby;
import com.amarnehsoft.zububa.model.Blog;
import com.amarnehsoft.zububa.model.GalleryItem;
import com.amarnehsoft.zububa.model.Taxi;
import com.amarnehsoft.zububa.model.Wedding;
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
    public void getBlog(final ICallBack<List<Blog>> callBack) {
        // dummy blog
        List<Blog> list = new ArrayList<>();
        Blog blog = new Blog();
        blog.setTitle("blog1");
        blog.setContent("content");
        blog.setImgUrl("non");

        list.add(blog);
        callBack.onResponse(list); // pass the list to callback

        // or by Firebase
        /*
        DatabaseReference mDataBlog = FirebaseDatabase.getInstance().getReference().child("blog");
        mDataBlog.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterator<DataSnapshot> iterator =  dataSnapshot.getChildren().iterator();
                ArrayList<Blog> arrayList = new ArrayList<>();
                while (iterator.hasNext()){
                    DataSnapshot data = iterator.next();
                    Blog b = data.getValue(Blog.class);
                    arrayList.add(b);
                }

                callBack.onResponse(arrayList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                callBack.onError(databaseError.getMessage());
            }
        });

        */


    }

    @Override
    public void getTaxiList(ICallBack<List<Taxi>> callBack) {

    }

    @Override
    public void getWeddings(ICallBack<List<Wedding>> callBack) {

    }

    @Override
    public void getGallery(ICallBack<List<GalleryItem>> callBack) {

    }

    @Override
    public void getBabies(ICallBack<List<Baby>> callBack) {

    }
}
