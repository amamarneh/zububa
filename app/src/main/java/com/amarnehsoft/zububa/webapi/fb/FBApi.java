package com.amarnehsoft.zububa.webapi.fb;

import android.support.annotation.NonNull;

import com.amarnehsoft.zububa.MainActivity;
import com.amarnehsoft.zububa.webapi.API;
import com.amarnehsoft.zububa.webapi.callBacks.ICallBack;
import com.amarnehsoft.zububa.webapi.callBacks.ISuccessCallBack;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
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
    public void saveItem(String childId,T item, ISuccessCallBack callBack) {
        DatabaseReference ref;
        try {
            ref = getFBRef().child(childId);
            ref.setValue(item).addOnSuccessListener(s->{
                callBack.success();
            })
            .addOnFailureListener(f->{
                callBack.error();
            });
        }catch (Exception e){
            callBack.error();
        }
    }

    @Override
    public void delete(String childId, ISuccessCallBack callBack) {
        delete(getFBRef().child(childId),callBack);
    }

    public void deleteAllInRef(ISuccessCallBack callBack){
        delete(getFBRef(),callBack);
    }

    protected void delete(DatabaseReference ref,ISuccessCallBack callBack){
        try {
            ref.removeValue();
            if (callBack != null)
                callBack.success();
        }catch (Exception e){
            if (callBack != null)
                callBack.error();
        }
    }
}
