package com.amarnehsoft.zububa.webapi;

import android.content.Context;

import com.amarnehsoft.zububa.ICallBack;
import com.amarnehsoft.zububa.IRealTimeCallBack;
import com.amarnehsoft.zububa.firebase.FBConstants;
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
//        List<Blog> list = new ArrayList<>();
//        Blog blog = new Blog();
//        blog.setTitle("blog1");
//        blog.setContent("content");
//        blog.setImgUrl("non");
//
//        list.add(blog);
//        callBack.onResponse(list); // pass the list to callback

        // or by Firebase

        DatabaseReference mDataBlog = FirebaseDatabase.getInstance().getReference().child(FBConstants.REF_BLOGS)
                .child(FBConstants.VILLAGE_ZUBUBA);
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
    }

    @Override
    public void getTaxiList(final ICallBack<List<Taxi>> callBack) {
        DatabaseReference mRef = FirebaseDatabase.getInstance().getReference().child(FBConstants.REF_TAXIS)
                .child(FBConstants.VILLAGE_ZUBUBA);
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterator<DataSnapshot> iterator =  dataSnapshot.getChildren().iterator();
                ArrayList<Taxi> arrayList = new ArrayList<>();
                while (iterator.hasNext()){
                    DataSnapshot data = iterator.next();
                    Taxi b = data.getValue(Taxi.class);
                    arrayList.add(b);
                }

                callBack.onResponse(arrayList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                callBack.onError(databaseError.getMessage());
            }
        });
    }

    @Override
    public void getWeddings(final ICallBack<List<Wedding>> callBack) {
        DatabaseReference mRef = FirebaseDatabase.getInstance().getReference().child(FBConstants.REF_WEDDINGS)
                .child(FBConstants.VILLAGE_ZUBUBA);
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterator<DataSnapshot> iterator =  dataSnapshot.getChildren().iterator();
                ArrayList<Wedding> arrayList = new ArrayList<>();
                while (iterator.hasNext()){
                    DataSnapshot data = iterator.next();
                    Wedding b = data.getValue(Wedding.class);
                    arrayList.add(b);
                }

                callBack.onResponse(arrayList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                callBack.onError(databaseError.getMessage());
            }
        });
    }

    @Override
    public void getGallery(final ICallBack<List<GalleryItem>> callBack) {
        DatabaseReference mRef = FirebaseDatabase.getInstance().getReference().child(FBConstants.REF_GALLERIES)
                .child(FBConstants.VILLAGE_ZUBUBA);
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterator<DataSnapshot> iterator =  dataSnapshot.getChildren().iterator();
                ArrayList<GalleryItem> arrayList = new ArrayList<>();
                while (iterator.hasNext()){
                    DataSnapshot data = iterator.next();
                    GalleryItem b = data.getValue(GalleryItem.class);
                    arrayList.add(b);
                }

                callBack.onResponse(arrayList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                callBack.onError(databaseError.getMessage());
            }
        });
    }

    @Override
    public void getBabies(final ICallBack<List<Baby>> callBack) {
        DatabaseReference mRef = FirebaseDatabase.getInstance().getReference().child(FBConstants.REF_BABIES)
                .child(FBConstants.VILLAGE_ZUBUBA);
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterator<DataSnapshot> iterator =  dataSnapshot.getChildren().iterator();
                ArrayList<Baby> arrayList = new ArrayList<>();
                while (iterator.hasNext()){
                    DataSnapshot data = iterator.next();
                    Baby b = data.getValue(Baby.class);
                    arrayList.add(b);
                }

                callBack.onResponse(arrayList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                callBack.onError(databaseError.getMessage());
            }
        });
    }
}
