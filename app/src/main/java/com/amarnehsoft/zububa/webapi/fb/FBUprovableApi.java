package com.amarnehsoft.zububa.webapi.fb;

import android.content.Context;

import com.amarnehsoft.zububa.model.HasLikes;
import com.amarnehsoft.zububa.model.Like;
import com.amarnehsoft.zububa.model.Uprovable;
import com.amarnehsoft.zububa.webapi.callBacks.ICompleteCallBack;
import com.amarnehsoft.zububa.webapi.callBacks.IListCallBack;
import com.amarnehsoft.zububa.webapi.fb.constants.FBConstants;
import com.amarnehsoft.zububa.webapi.fb.constants.FB_REF;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

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
    protected DatabaseReference getFBRef() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference()
                .child(getFB_REF().name())
                .child(FBConstants.VILLAGE_ZUBUBA);
        if (approved){
            return ref.child(FBConstants.APPROVED);
        }else {
            return ref.child(FBConstants.NOT_APPROVED);
        }
    }

    public void approve(T bean, ICompleteCallBack callBack) {
        //delete and then push to approved
        delete(bean.getCode(), (success)->{
            if (success){
                bean.setAdminCode("admin");
                bean.setApproveDate(new Date().getTime());
                saveItem(getFBRef().getParent().child(FBConstants.APPROVED),bean,callBack);
            }else {
                callBack.completed(false);
            }
        });
    }
}
