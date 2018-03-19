package com.amarnehsoft.zububa.webapi.fb;

import com.amarnehsoft.zububa.model.Blog;
import com.amarnehsoft.zububa.model.FBModels.FBBlog;
import com.amarnehsoft.zububa.model.FBModels.FBComment;
import com.amarnehsoft.zububa.webapi.fb.FBApi;
import com.amarnehsoft.zububa.webapi.fb.FBConstants;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by user on 3/19/2018.
 */

public class BlogFBApi extends FBApi<FBBlog> {

    private boolean approved = false;

    public BlogFBApi(boolean approved){
        this.approved = approved;
    }

    @Override
    protected DatabaseReference getFBRef() {
        if (approved){
            return FirebaseDatabase.getInstance().getReference()
                    .child(FBConstants.REF_BLOGS)
                    .child(FBConstants.VILLAGE_ZUBUBA)
                    .child(FBConstants.APPROVED);
        }else {
            return FirebaseDatabase.getInstance().getReference()
                    .child(FBConstants.REF_BLOGS)
                    .child(FBConstants.VILLAGE_ZUBUBA)
                    .child(FBConstants.NOT_APPROVED);
        }
    }

    @Override
    protected Class<FBBlog> getEntityClass() {
        return FBBlog.class;
    }
}
