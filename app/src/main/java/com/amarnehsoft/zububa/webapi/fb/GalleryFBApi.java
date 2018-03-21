package com.amarnehsoft.zububa.webapi.fb;

import com.amarnehsoft.zububa.model.GalleryItem;
import com.amarnehsoft.zububa.webapi.fb.constants.FBConstants;
import com.amarnehsoft.zububa.webapi.fb.constants.FB_REF;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by user on 3/19/2018.
 */

public class GalleryFBApi extends FBHasLikesApi<GalleryItem> {

    public GalleryFBApi(boolean approved) {
        super(approved);
    }

    @Override
    protected Class<GalleryItem> getEntityClass() {
        return GalleryItem.class;
    }

    @Override
    protected FB_REF getFB_REF() {
        return FB_REF.galleries;
    }
}
