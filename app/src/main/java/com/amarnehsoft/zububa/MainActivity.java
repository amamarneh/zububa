package com.amarnehsoft.zububa;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.amarnehsoft.zububa.model.Baby;
import com.amarnehsoft.zububa.webapi.fb.FBFactory;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Baby baby = new Baby();
        baby.setCode("b2");
        baby.setName("not approved baby");
        FBFactory.getBabyFBApi(false).approve(baby,success -> {
            Log.e("Amarneh","completed with success="+success);
        });
    }
}
