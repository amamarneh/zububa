package com.amarnehsoft.zububa.webapi.fb;

import com.amarnehsoft.zububa.model.FBModels.FBBaby;
import com.amarnehsoft.zububa.model.FBModels.FBLike;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by user on 3/19/2018.
 */

public class LikesFBApi extends FBApi<FBLike> {

    private String ref;
    private String childId;

    public LikesFBApi(String ref,String childId){
        this.ref = ref;
        this.childId = childId;
    }

    @Override
    protected DatabaseReference getFBRef() {
            return FirebaseDatabase.getInstance().getReference()
                    .child(FBConstants.REF_LIKES)
                    .child(FBConstants.VILLAGE_ZUBUBA)
                    .child(ref)
                    .child(childId);
    }

    @Override
    protected Class<FBLike> getEntityClass() {
        return FBLike.class;
    }
}
