package com.amarnehsoft.zububa;

/**
 * Created by user on 3/19/2018.
 */

public interface IRealTimeCallBack<T> extends ICallBack<T>{
    void childAdded(T bean);
}
