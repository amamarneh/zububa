package com.amarnehsoft.zububa.repo;

import com.amarnehsoft.zububa.data.webapi.WebFactory;
import com.amarnehsoft.zububa.data.webapi.callBacks.IListCallBack;
import com.amarnehsoft.zububa.model.Taxi;

import java.util.List;

public class TaxiRepo {
    public Task<List<Taxi>> getTaxis(){
        Task<List<Taxi>> task = new Task<>();
        WebFactory.getWebService().getTaxiList(new IListCallBack<Taxi>() {
            @Override
            public void onResponse(List<Taxi> value) {
                task.response(value,true);
            }

            @Override
            public void onError(String err) {
                task.response(null,false);
            }
        });
        return task;
    }
}
