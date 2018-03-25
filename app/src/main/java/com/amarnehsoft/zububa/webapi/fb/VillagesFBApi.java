package com.amarnehsoft.zububa.webapi.fb;

import com.amarnehsoft.zububa.model.Taxi;
import com.amarnehsoft.zububa.model.Village;
import com.amarnehsoft.zububa.webapi.fb.FBApi;
import com.amarnehsoft.zububa.webapi.fb.constants.FB_REF;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Ref;

/**
 * Created by user on 3/19/2018.
 */

public class VillagesFBApi extends FBApi<Village> {

    @Override
    protected String getFBRefString() {
        return FB_REF.villages.name();
    }

    @Override
    protected Class<Village> getEntityClass() {
        return Village.class;
    }
}
