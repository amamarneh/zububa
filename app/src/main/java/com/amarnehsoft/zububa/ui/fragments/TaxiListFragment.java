package com.amarnehsoft.zububa.ui.fragments;

import android.view.View;
import android.widget.TextView;

import com.amarnehsoft.zububa.R;
import com.amarnehsoft.zububa.repo.TaxiRepo;
import com.amarnehsoft.zububa.ui.abstractAdapters.Holder;
import com.amarnehsoft.zububa.ui.abstractAdapters.RecyclerAdapter;
import com.amarnehsoft.zububa.model.Taxi;
import com.amarnehsoft.zububa.data.webapi.WebApi;
import com.amarnehsoft.zububa.data.webapi.WebFactory;
import com.amarnehsoft.zububa.data.webapi.callBacks.IListCallBack;
import com.amarnehsoft.zububa.ui.adapters.TaxiAdapter;

import java.util.List;

/**
 * Created by ALa on 3/21/2018.
 */

public class TaxiListFragment extends ListFragment {
    @Override
    public void setupRecyclerViewAdapter() {
        showLoading();
        new TaxiRepo().getTaxis()
                .addOnCompleteListener(task -> {
                    showContent();
                    if(task.isSuccessful()){
                        TaxiAdapter adapter = new TaxiAdapter(task.getResult());
                        mRecyclerView.setAdapter(adapter);
                    }
                });
    }

    @Override
    protected void loadDataFromWeb() {

    }

}
