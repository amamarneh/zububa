package com.amarnehsoft.zububa.webapi.fb;

import com.amarnehsoft.zububa.model.Admin;
import com.amarnehsoft.zububa.model.Baby;
import com.amarnehsoft.zububa.webapi.fb.constants.FBConstants;
import com.amarnehsoft.zububa.webapi.fb.constants.FB_REF;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by user on 3/19/2018.
 */

public class AdminFBApi extends FBApi<Admin> {

    @Override
    protected DatabaseReference getFBRef() {
        return FirebaseDatabase.getInstance().getReference()
                .child(FB_REF.users.name())
                .child(FBConstants.USER_ADMIN);
    }

    @Override
    protected Class<Admin> getEntityClass() {
        return Admin.class;
    }
}
