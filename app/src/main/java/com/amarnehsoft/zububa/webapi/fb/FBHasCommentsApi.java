package com.amarnehsoft.zububa.webapi.fb;

import com.amarnehsoft.zububa.model.BaseModel;
import com.amarnehsoft.zububa.model.Comment;
import com.amarnehsoft.zububa.model.Like;
import com.amarnehsoft.zububa.webapi.callBacks.ICallBack;
import com.amarnehsoft.zububa.webapi.callBacks.ISuccessCallBack;

/**
 * Created by user on 3/19/2018.
 */

public abstract class FBHasCommentsApi<T extends BaseModel> extends FBHasLikesApi<T> {
    @Override
    public void delete(String childId, ISuccessCallBack callBack) {
        super.delete(childId,callBack);
        FBFactory.getCommentsFBApi(getFB_REF(),childId,true).deleteAllInRef(callBack);
    }

    public void getComments(String childId,boolean approved,ICallBack<Comment> callBack){
        FBFactory.getCommentsFBApi(getFB_REF(),childId,approved).getList(callBack);
    }

    public void putComment(String childId, Comment comment, ISuccessCallBack callBack){
        FBFactory.getCommentsFBApi(getFB_REF(),childId,false).saveItem(comment.getCode(),comment,callBack);
    }

    public void approveComment(String childId,Comment comment,ISuccessCallBack callBack){
        FBFactory.getCommentsFBApi(getFB_REF(),childId,false).delete(comment.getCode(), new ISuccessCallBack() {
            @Override
            public void success() {
                FBFactory.getCommentsFBApi(getFB_REF(),childId,true).saveItem(comment.getCode(),comment,callBack);
            }

            @Override
            public void error() {
                callBack.error();
            }
        });
    }
}
