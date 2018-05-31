package com.amarnehsoft.zububa.data.webapi.fb;

import com.amarnehsoft.zububa.model.Blog;
import com.amarnehsoft.zububa.data.webapi.fb.constants.FBConstants;
import com.amarnehsoft.zububa.data.webapi.fb.constants.FB_REF;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by user on 3/19/2018.
 */

public class BlogFBApi extends FBHasCommentsApi<Blog>{

    public BlogFBApi(boolean approved) {
        super(approved);
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
