package com.amarnehsoft.zububa.webapi.fb;

import com.amarnehsoft.zububa.model.FBModels.FBBaby;
import com.amarnehsoft.zububa.model.FBModels.FBGalleryItem;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by user on 3/19/2018.
 */

public class GalleryFBApi extends FBApi<FBGalleryItem> {

    private boolean approved = false;

    @Override
    protected DatabaseReference getFBRef() {
        if (approved){
            return FirebaseDatabase.getInstance().getReference()
                    .child(FBConstants.REF_GALLERIES)
                    .child(FBConstants.VILLAGE_ZUBUBA)
                    .child(FBConstants.APPROVED);
        }else {
            return FirebaseDatabase.getInstance().getReference()
                    .child(FBConstants.REF_GALLERIES)
                    .child(FBConstants.VILLAGE_ZUBUBA)
                    .child(FBConstants.NOT_APPROVED);
        }
    }

    public GalleryFBApi(boolean approved){
            this.approved = approved;
    }

    @Override
    protected Class<FBGalleryItem> getEntityClass() {
        return FBGalleryItem.class;
    }
}
