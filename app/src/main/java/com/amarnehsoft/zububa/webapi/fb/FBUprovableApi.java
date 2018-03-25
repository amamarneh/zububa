package com.amarnehsoft.zububa.webapi.fb;

import android.content.Context;

import com.amarnehsoft.zububa.model.HasLikes;
import com.amarnehsoft.zububa.model.Like;
import com.amarnehsoft.zububa.model.Uprovable;
import com.amarnehsoft.zububa.webapi.callBacks.ICompleteCallBack;
import com.amarnehsoft.zububa.webapi.callBacks.IListCallBack;
import com.amarnehsoft.zububa.webapi.fb.constants.FBConstants;
import com.amarnehsoft.zububa.webapi.fb.constants.FB_REF;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by user on 3/19/2018.
 */

public abstract class FBUprovableApi<T extends Uprovable> extends FBApi<T>{

    protected abstract FB_REF getFB_REF();

    protected boolean approved;
    public FBUprovableApi(boolean approved){
        this.approved = approved;
    }

    @Override
    protected String getFBRefString() {
        String path= getFB_REF().name() + separator + FBConstants.VILLAGE_ZUBUBA + separator;
        if (approved)
            path+=FBConstants.APPROVED;
        else
            path+=FBConstants.NOT_APPROVED;
        return path;
    }

    public void approve(T bean, ICompleteCallBack callBack) {
        //delete and then push to approved
        if (!approved){
            HashMap map = getHashMapToDelete(bean.getCode());
            bean.setAdminCode("admin");
            bean.setApproveDate(new Date().getTime());
            map.putAll(getHashMapToSave(bean,true));
            FirebaseDatabase.getInstance().getReference().updateChildren(map)
                    .addOnSuccessListener(s->{callBack.completed(true);})
                    .addOnFailureListener(f->{callBack.completed(false);});
        }else {
            throw new RuntimeException("you are trying to approve a bean in already approved section");
        }
    }

    protected HashMap<String,Object> getHashMapToSave(T item,boolean approved) {
        HashMap<String,Object> map = new HashMap<>();
        String  path = getFBRefString().substring(0,getFBRefString().lastIndexOf(separator)+1);
        if (approved)
            path += FBConstants.APPROVED;
        else
            path += FBConstants.NOT_APPROVED;

        map.put(path + separator + item.getCode(),item);
        return map;
    }

    @Override
    public Task<Void> deleteAllInRef(ICompleteCallBack callBack) {
        return super.deleteAllInRef(callBack);
    }

    public void deleteAllApprovedAndNotApprovedInRef(ICompleteCallBack callBack){
        FirebaseDatabase.getInstance().getReference().updateChildren(getHasMapToDeleteAllApprovedAndNotApprovedInRef())
                .addOnSuccessListener(s->{callBack.completed(true);})
                .addOnFailureListener(f->{callBack.completed(false);});
    }

    public HashMap<String,Object> getHasMapToDeleteAllApprovedAndNotApprovedInRef(){
        HashMap<String ,Object> map = super.getHashMapToDeleteAll();
        String path = getFBRefString().substring(0,getFBRefString().lastIndexOf(separator)+1);
        String approvedPath = path + FBConstants.APPROVED;
        String notApprovedPath = path + FBConstants.NOT_APPROVED;
        map.put(approvedPath,null);
        map.put(notApprovedPath,null);
        return map;
    }
}
