package com.amarnehsoft.zububa.webapi.fb;

import com.amarnehsoft.zububa.model.Comment;
import com.amarnehsoft.zububa.model.Uprovable;
import com.amarnehsoft.zububa.webapi.callBacks.ICallBack;
import com.amarnehsoft.zububa.webapi.callBacks.ICompleteCallBack;
import com.amarnehsoft.zububa.webapi.callBacks.IListCallBack;

/**
 * Created by user on 3/19/2018.
 */

public abstract class FBHasCommentsApi<T extends Uprovable> extends FBHasLikesApi<T> {

    public FBHasCommentsApi(boolean approved) {
        super(approved);
    }

    @Override
    public void delete(String childId, ICompleteCallBack callBack) {
        super.delete(childId,callBack);
        FBFactory.getCommentsFBApi(getFB_REF(),childId,true).deleteAllInRef(callBack);
    }

    public void getComments(String childId,boolean approved,IListCallBack<Comment> callBack){
        FBFactory.getCommentsFBApi(getFB_REF(),childId,approved).getList(callBack);
    }

    public void putComment(String childId, Comment comment, ICompleteCallBack callBack){
        FBFactory.getCommentsFBApi(getFB_REF(),childId,false).saveItem(comment,callBack);
    }

    public void approveComment(String childId,Comment comment,ICompleteCallBack callBack){
        FBFactory.getCommentsFBApi(getFB_REF(),childId,false).delete(comment.getCode(), (success -> {
            if (success){
                FBFactory.getCommentsFBApi(getFB_REF(),childId,true).saveItem(comment,callBack);
            }else {
                callBack.completed(false);
            }
        }));
    }
}
