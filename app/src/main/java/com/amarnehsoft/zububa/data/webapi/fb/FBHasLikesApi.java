package com.amarnehsoft.zububa.data.webapi.fb;

import android.content.Context;

import com.amarnehsoft.zububa.model.HasLikes;
import com.amarnehsoft.zububa.model.Like;
import com.amarnehsoft.zububa.model.Uprovable;
import com.amarnehsoft.zububa.data.webapi.callBacks.ICallBack;
import com.amarnehsoft.zububa.data.webapi.callBacks.ICompleteCallBack;
import com.amarnehsoft.zububa.data.webapi.callBacks.IListCallBack;
import com.amarnehsoft.zububa.data.webapi.fb.constants.FBConstants;
import com.amarnehsoft.zububa.data.webapi.fb.constants.FB_REF;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by user on 3/19/2018.
 */

public abstract class FBHasLikesApi<T extends HasLikes> extends FBUprovableApi<T>{

    public FBHasLikesApi(boolean approved){
        super(approved);
    }

    @Override
    protected HashMap<String, Object> getHashMapToDelete(String childId) {
        HashMap<String,Object> map = super.getHashMapToDelete(childId);
        map.putAll(FBFactory.getLikesFBApi(getFB_REF(),childId).getHashMapToDeleteAll());
        return map;
    }

    public void getLikes(String childId, IListCallBack<Like> callBack){
        FBFactory.getLikesFBApi(getFB_REF(),childId).getList(callBack);
    }

    public void putLike(T srcBean, Context context, ICompleteCallBack callBack){
        putLike(srcBean,new Like(context),callBack);
    }

    public void putLike(T srcBean, Like like, ICompleteCallBack callBack){
        //not accurate
        //need to be encapsulated in a transaction
        // TODO: 3/23/2018
        FBFactory.getLikesFBApi(getFB_REF(),srcBean.getCode()).saveItem(like,success -> {
            if (success){
                srcBean.setLikesCount(srcBean.getLikesCount()+1);
                saveItem(srcBean,callBack);
            }else
                callBack.completed(false);
        });
    }

    public void deleteLike(T srcBean,String likeCode,ICompleteCallBack callBack){
        FBFactory.getLikesFBApi(getFB_REF(),srcBean.getCode()).delete(likeCode,success -> {
            if (success){
                srcBean.setLikesCount(srcBean.getLikesCount()-1);
                saveItem(srcBean,callBack);
            } else{
                callBack.completed(false);
            }
        });
    }
}
