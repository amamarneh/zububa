package com.amarnehsoft.zububa.webapi.fb;

import com.amarnehsoft.zububa.model.FBModels.FBBaby;
import com.amarnehsoft.zububa.model.FBModels.FBLike;
import com.amarnehsoft.zububa.model.FBModels.FBWedding;
import com.amarnehsoft.zububa.webapi.ICallBack;
import com.amarnehsoft.zububa.webapi.fb.FBApi;
import com.amarnehsoft.zububa.webapi.fb.FBConstants;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by user on 3/19/2018.
 */

public class BabyFBApi extends FBApi<FBBaby> {

    private boolean approved = false;

    @Override
    protected DatabaseReference getFBRef() {
        if (approved){
            return FirebaseDatabase.getInstance().getReference()
                    .child(FBConstants.REF_BABIES)
                    .child(FBConstants.VILLAGE_ZUBUBA)
                    .child(FBConstants.APPROVED);
        }else {
            return FirebaseDatabase.getInstance().getReference()
                    .child(FBConstants.REF_BABIES)
                    .child(FBConstants.VILLAGE_ZUBUBA)
                    .child(FBConstants.NOT_APPROVED);
        }
    }

    public BabyFBApi(boolean approved){
            this.approved = approved;
    }

    @Override
    protected Class<FBBaby> getEntityClass() {
        return FBBaby.class;
    }
}
