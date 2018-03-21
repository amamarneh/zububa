package com.amarnehsoft.zububa.webapi.fb;

import com.amarnehsoft.zububa.model.Like;
import com.amarnehsoft.zububa.model.Uprovable;
import com.amarnehsoft.zububa.webapi.callBacks.ICallBack;
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

public abstract class FBHasLikesApi<T extends Uprovable> extends FBApi<T> implements IUprovable<T> {

    protected abstract FB_REF getFB_REF();

    protected boolean approved;
    public FBHasLikesApi(boolean approved){
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

    @Override
    public void delete(String childId, ICompleteCallBack callBack) {
        super.delete(childId,callBack);
        FBFactory.getLikesFBApi(getFB_REF(),childId).deleteAllInRef(callBack);
    }

    public void getLikes(String childId,IListCallBack<Like> callBack){
        FBFactory.getLikesFBApi(getFB_REF(),childId).getList(callBack);
    }

    public void putLike(String childId,Like like,ICompleteCallBack callBack){
        FBFactory.getLikesFBApi(getFB_REF(),childId).saveItem(like,callBack);
    }

    @Override
    public void approve(T bean, ICompleteCallBack callBack) {
        //delete and then push to approved
        delete(bean.getCode(), (success)->{
            if (success){
                bean.setAdminCode("admin");
                bean.setApproveDate(new Date().getTime());
                saveItem(bean,callBack);
            }else {
                callBack.completed(false);
            }
        });
    }
}
