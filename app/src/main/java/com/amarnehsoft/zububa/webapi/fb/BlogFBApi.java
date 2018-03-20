package com.amarnehsoft.zububa.webapi.fb;

import com.amarnehsoft.zububa.model.Blog;
import com.amarnehsoft.zububa.webapi.callBacks.ISuccessCallBack;
import com.amarnehsoft.zububa.webapi.fb.constants.FBConstants;
import com.amarnehsoft.zububa.webapi.fb.constants.FB_REF;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by user on 3/19/2018.
 */

public class BlogFBApi extends FBHasCommentsApi<Blog> implements Uprovable<Blog>{

    private boolean approved = false;

    public BlogFBApi(boolean approved){
        this.approved = approved;
    }

    @Override
    protected DatabaseReference getFBRef() {
        if (approved){
            return FirebaseDatabase.getInstance().getReference()
                    .child(FB_REF.blogs.name())
                    .child(FBConstants.VILLAGE_ZUBUBA)
                    .child(FBConstants.APPROVED);
        }else {
            return FirebaseDatabase.getInstance().getReference()
                    .child(FB_REF.blogs.name())
                    .child(FBConstants.VILLAGE_ZUBUBA)
                    .child(FBConstants.NOT_APPROVED);
        }
    }

    @Override
    protected Class<Blog> getEntityClass() {
        return Blog.class;
    }

    @Override
    protected FB_REF getFB_REF() {
        return FB_REF.blogs;
    }
}
