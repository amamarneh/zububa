package com.amarnehsoft.zububa.webapi.fb;

import com.amarnehsoft.zububa.model.Comment;
import com.amarnehsoft.zububa.model.HasComments;
import com.amarnehsoft.zububa.model.Uprovable;
import com.amarnehsoft.zububa.webapi.callBacks.ICallBack;
import com.amarnehsoft.zububa.webapi.callBacks.ICompleteCallBack;
import com.amarnehsoft.zububa.webapi.callBacks.IListCallBack;
import com.amarnehsoft.zububa.webapi.fb.constants.FBConstants;

/**
 * Created by user on 3/19/2018.
 */

public abstract class FBHasCommentsApi<T extends HasComments> extends FBHasLikesApi<T> {

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

    public void putComment(T srcBean, Comment comment, ICompleteCallBack callBack){
        FBFactory.getCommentsFBApi(getFB_REF(),srcBean.getCode(),false).saveItem(comment,callBack);
    }

    public void approveComment(T srcBean,Comment comment,ICompleteCallBack callBack){
        // TODO: 3/23/2018
        //should be encapsulated in one transaction
        FBFactory.getCommentsFBApi(getFB_REF(),srcBean.getCode(),false).delete(comment.getCode(), (success -> {
            if (success){
                FBFactory.getCommentsFBApi(getFB_REF(),srcBean.getCode(),true).saveItem(comment,success1 -> {
                    if (success1){
                        srcBean.setCommentsCount(srcBean.getCommentsCount()+1);
                        saveItem(srcBean,callBack);
                    }else
                        callBack.completed(false);
                });
            }else {
                callBack.completed(false);
            }
        }));
    }

    public void deleteComment(T srcBean,String commentCode,boolean commentApproved,ICompleteCallBack callBack){
        FBFactory.getCommentsFBApi(getFB_REF(),srcBean.getCode(),commentApproved).delete(commentCode,success -> {
            if (success){
                if (commentApproved){
                    srcBean.setCommentsCount(srcBean.getCommentsCount()-1);
                    saveItem(srcBean,callBack);
                }else{
                    callBack.completed(true);
                }
            }else{
                callBack.completed(false);
            }
        });
    }
}
