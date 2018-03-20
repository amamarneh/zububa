package com.amarnehsoft.zububa.webapi.fb;

import com.amarnehsoft.zububa.model.Like;
import com.amarnehsoft.zububa.webapi.callBacks.ISuccessCallBack;
import com.amarnehsoft.zububa.webapi.fb.constants.FBConstants;
import com.amarnehsoft.zububa.webapi.fb.constants.FB_REF;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by user on 3/19/2018.
 */

public class LikesFBApi extends FBApi<Like> {

    private String ref;
    private String childId;

    public LikesFBApi(String ref,String childId){
        this.ref = ref;
        this.childId = childId;
    }

    @Override
    protected DatabaseReference getFBRef() {
            return FirebaseDatabase.getInstance().getReference()
                    .child(FB_REF.likes.name())
                    .child(FBConstants.VILLAGE_ZUBUBA)
                    .child(ref)
                    .child(childId);
    }

    @Override
    protected Class<Like> getEntityClass() {
        return Like.class;
    }
}
