package com.amarnehsoft.zububa.data.webapi.fb;

import com.amarnehsoft.zububa.model.BaseModel;
import com.amarnehsoft.zububa.data.webapi.API;
import com.amarnehsoft.zububa.data.webapi.callBacks.ICompleteCallBack;
import com.amarnehsoft.zububa.data.webapi.callBacks.IListCallBack;
import com.amarnehsoft.zububa.data.webapi.fb.constants.FBConstants;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 3/19/2018.
 */

public abstract class FBApi<T extends BaseModel> implements API<T> {
    protected String separator = "/";

    protected abstract String getFBRefString();
    protected abstract Class<T> getEntityClass();


    protected DatabaseReference getFBRef(){
        return FirebaseDatabase.getInstance().getReference(getFBRefString());
    }

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
    public void saveItem(T item, ICompleteCallBack callBack)
    {
        FirebaseDatabase.getInstance().getReference().updateChildren(getHashMapToSave(item))
                .addOnSuccessListener(s->{callBack.completed(true);})
                .addOnFailureListener(f->{callBack.completed(false);});
    }

    @Override
    public void delete(String childId, ICompleteCallBack callBack) {
        FirebaseDatabase.getInstance().getReference().updateChildren(getHashMapToDelete(childId))
                .addOnSuccessListener(s->{callBack.completed(true);})
                .addOnFailureListener(s->{callBack.completed(false);});
    }

    public Task<Void> deleteAllInRef(ICompleteCallBack callBack){
        return FirebaseDatabase.getInstance().getReference().updateChildren(getHashMapToDeleteAll())
                .addOnSuccessListener(s->{callBack.completed(true);})
                .addOnFailureListener(f->{callBack.completed(false);});
    }

    protected HashMap<String,Object> getHashMapToSave(T item) {
        HashMap<String,Object> map = new HashMap<>();
        map.put(getFBRefString() + separator + item.getCode(),item);
        return map;
    }

    protected HashMap<String,Object> getHashMapToDelete(String childId){
        HashMap map = new HashMap<String,Object>();
        map.put(getFBRefString() + separator + childId,null);
        return map;
    }

    protected HashMap<String,Object> getHashMapToDeleteAll(){
        HashMap map = new HashMap<String,Object>();
        map.put(getFBRefString(),null);
        return map;
    }
}
