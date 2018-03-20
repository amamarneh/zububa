package com.amarnehsoft.zububa.webapi.fb;

import com.amarnehsoft.zububa.model.Baby;
import com.amarnehsoft.zububa.webapi.fb.constants.FBConstants;
import com.amarnehsoft.zububa.webapi.fb.constants.FB_REF;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by user on 3/19/2018.
 */

public class BabyFBApi extends FBApi<Baby> {

    private boolean approved = false;

    @Override
    protected DatabaseReference getFBRef() {
        if (approved){
            return FirebaseDatabase.getInstance().getReference()
                    .child(FB_REF.babies.name())
                    .child(FBConstants.VILLAGE_ZUBUBA)
                    .child(FBConstants.APPROVED);
        }else {
            return FirebaseDatabase.getInstance().getReference()
                    .child(FB_REF.babies.name())
                    .child(FBConstants.VILLAGE_ZUBUBA)
                    .child(FBConstants.NOT_APPROVED);
        }
    }

    public BabyFBApi(boolean approved){
            this.approved = approved;
    }

    @Override
    protected Class<Baby> getEntityClass() {
        return Baby.class;
    }
}
