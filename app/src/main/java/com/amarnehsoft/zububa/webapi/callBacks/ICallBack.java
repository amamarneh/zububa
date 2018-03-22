package com.amarnehsoft.zububa.webapi.callBacks;

import java.util.List;

/**
 * Created by ALa on 3/17/2018.
 */

public interface ICallBack<T> {
    void onResponse(T value);
    void onError(String err);
}
