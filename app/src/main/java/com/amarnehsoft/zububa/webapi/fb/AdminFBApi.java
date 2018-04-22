package com.amarnehsoft.zububa.webapi.fb;

import com.amarnehsoft.zububa.model.Admin;
import com.amarnehsoft.zububa.model.Baby;
import com.amarnehsoft.zububa.webapi.fb.constants.FBConstants;
import com.amarnehsoft.zububa.webapi.fb.constants.FB_REF;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

/**
 * Created by user on 3/19/2018.
 */

public class AdminFBApi extends FBApi<Admin> {

    @Override
    protected String getFBRefString() {
        return FB_REF.users.name() + separator + FBConstants.USER_ADMIN;
    }

    @Override
    protected Class<Admin> getEntityClass() {
        return Admin.class;
    }


}
