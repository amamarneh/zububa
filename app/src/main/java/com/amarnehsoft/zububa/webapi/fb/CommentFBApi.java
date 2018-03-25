package com.amarnehsoft.zububa.webapi.fb;

import com.amarnehsoft.zububa.model.Comment;
import com.amarnehsoft.zububa.model.Like;
import com.amarnehsoft.zububa.webapi.fb.constants.FBConstants;
import com.amarnehsoft.zububa.webapi.fb.constants.FB_REF;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by user on 3/19/2018.
 */

public class CommentFBApi extends FBHasLikesApi<Comment> {

    private String ref;
    private String childId;
    private boolean approved = false;

    public CommentFBApi(String ref, String childId,boolean approved){
        super(approved);
        this.ref = ref;
        this.childId = childId;
    }

    @Override
    protected String getFBRefString() {
        String path = getFB_REF().name() + separator + FBConstants.VILLAGE_ZUBUBA + separator + ref + separator + childId + separator;
        if (approved)
            path+=FBConstants.APPROVED;
        else
            path+=FBConstants.NOT_APPROVED;
        return path;
    }

    @Override
    protected Class<Comment> getEntityClass() {
        return Comment.class;
    }

    @Override
    protected FB_REF getFB_REF() {
        return FB_REF.comments;
    }
}
