package com.amarnehsoft.zububa.webapi.fb;

import com.amarnehsoft.zububa.model.FBModels.FBTaxi;
import com.amarnehsoft.zububa.model.FBModels.FBWedding;
import com.amarnehsoft.zububa.webapi.fb.FBApi;
import com.amarnehsoft.zububa.webapi.fb.FBConstants;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by user on 3/19/2018.
 */

public class WeddingFBApi extends FBApi<FBWedding> {

    private boolean approved = false;

    public WeddingFBApi(boolean approved){
        this.approved = approved;
    }

    @Override
    protected DatabaseReference getFBRef() {
        if (approved){
            return FirebaseDatabase.getInstance().getReference()
                    .child(FBConstants.REF_WEDDINGS)
                    .child(FBConstants.VILLAGE_ZUBUBA)
                    .child(FBConstants.APPROVED);
        }else {
            return FirebaseDatabase.getInstance().getReference()
                    .child(FBConstants.REF_WEDDINGS)
                    .child(FBConstants.VILLAGE_ZUBUBA)
                    .child(FBConstants.NOT_APPROVED);
        }
    }

    @Override
    protected Class<FBWedding> getEntityClass() {
        return FBWedding.class;
    }
}
