package com.amarnehsoft.zububa.webapi.fb;

import com.amarnehsoft.zububa.model.BaseModel;
import com.amarnehsoft.zububa.webapi.API;
import com.amarnehsoft.zububa.webapi.callBacks.ICallBack;
import com.amarnehsoft.zububa.webapi.callBacks.ICompleteCallBack;
import com.amarnehsoft.zububa.webapi.callBacks.IListCallBack;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by user on 3/19/2018.
 */

public abstract class FBApi<T extends BaseModel> implements API<T> {

    protected abstract DatabaseReference getFBRef();

    protected abstract Class<T> getEntityClass();


    @Override
    public void getList(final IListCallBack<T> callBack) {
            getFBRef().addListenerForSingleValueEvent(new ValueEventListener() {
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
    public void saveItem(T item, ICompleteCallBack callBack) {
        DatabaseReference ref;
        try {
            ref = getFBRef().child(item.getCode());
            ref.setValue(item)
                    .addOnSuccessListener(s->{callBack.completed(true);})
                    .addOnFailureListener(f->{callBack.completed(false);});
        }catch (Exception e){
            callBack.completed(false);
        }
    }

    @Override
    public void delete(String childId, ICompleteCallBack callBack) {
        delete(getFBRef().child(childId),callBack);
    }

    public void deleteAllInRef(ICompleteCallBack callBack){
        delete(getFBRef(),callBack);
    }

    protected void delete(DatabaseReference ref,ICompleteCallBack callBack){
        try {
            ref.removeValue()
                    .addOnSuccessListener(s->{callBack.completed(true);})
                    .addOnFailureListener(f->{callBack.completed(false);});
        }catch (Exception e){
                callBack.completed(false);
        }
    }
}
