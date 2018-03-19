package com.amarnehsoft.zububa.webapi.fb;

import com.amarnehsoft.zububa.webapi.API;
import com.amarnehsoft.zububa.webapi.ICallBack;
import com.amarnehsoft.zububa.webapi.ISaveCallBack;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by user on 3/19/2018.
 */

public abstract class FBApi<T> implements API<T> {

    protected abstract DatabaseReference getFBRef();

    protected abstract Class<T> getEntityClass();


    @Override
    public void getList(final ICallBack<T> callBack) {
            DatabaseReference mDataBlog = getFBRef();
            mDataBlog.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Iterator<DataSnapshot> iterator =  dataSnapshot.getChildren().iterator();
                    ArrayList<T> arrayList = new ArrayList<>();
                    while (iterator.hasNext()){
                        DataSnapshot data = iterator.next();
                        T b = data.getValue(getEntityClass());
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
    public void uploadItem(T item, ISaveCallBack callBack) {
        try {
            getFBRef().push().setValue(item);
            if (callBack != null){
                callBack.success();
            }
        }catch (Exception e){
            if (callBack != null)
                callBack.error();
        }
    }

    @Override
    public void updateItem(String childId, T item, ISaveCallBack callBack) {
        try {
            getFBRef().child(childId).setValue(item);
            if (callBack != null){
                callBack.success();
            }
        }catch (Exception e){
            if (callBack != null)
                callBack.error();
        }
    }
}
