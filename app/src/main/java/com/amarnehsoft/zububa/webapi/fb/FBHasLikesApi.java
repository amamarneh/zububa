package com.amarnehsoft.zububa.webapi.fb;

import com.amarnehsoft.zububa.model.Like;
import com.amarnehsoft.zububa.webapi.callBacks.ICallBack;
import com.amarnehsoft.zububa.webapi.callBacks.ISuccessCallBack;
import com.amarnehsoft.zububa.webapi.fb.constants.FB_REF;

/**
 * Created by user on 3/19/2018.
 */

public abstract class FBHasLikesApi<T> extends FBApi<T> {

    protected abstract FB_REF getFB_REF();

    @Override
    public void delete(String childId, ISuccessCallBack callBack) {
        super.delete(childId,callBack);
        FBFactory.getLikesFBApi(getFB_REF(),childId).deleteAllInRef(callBack);
    }

    public void getLikes(String childId,ICallBack<Like> callBack){
        FBFactory.getLikesFBApi(getFB_REF(),childId).getList(callBack);
    }

    public void putLike(String childId,Like like,ISuccessCallBack callBack){
        FBFactory.getLikesFBApi(getFB_REF(),childId).saveItem(like.getCode(),like,callBack);
    }
}