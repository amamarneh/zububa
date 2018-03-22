package com.amarnehsoft.zububa.webapi.fb;

import com.amarnehsoft.zububa.model.Taxi;
import com.amarnehsoft.zububa.webapi.fb.constants.FBConstants;
import com.amarnehsoft.zububa.webapi.fb.constants.FB_REF;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by user on 3/19/2018.
 */

public class TaxiFBApi extends FBHasCommentsApi<Taxi> {

    public TaxiFBApi(boolean approved){
        super(approved);
    }

    @Override
    protected Class<Taxi> getEntityClass() {
        return Taxi.class;
    }

    @Override
    protected FB_REF getFB_REF() {
        return FB_REF.taxies;
    }
}
