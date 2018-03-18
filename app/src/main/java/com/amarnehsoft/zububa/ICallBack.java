package com.amarnehsoft.zububa;

/**
 * Created by ALa on 3/17/2018.
 */

public interface ICallBack<T> {
    void onResponse(T value);
    void onError(String err);
}
