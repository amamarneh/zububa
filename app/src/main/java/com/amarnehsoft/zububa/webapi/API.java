package com.amarnehsoft.zububa.webapi;

import com.amarnehsoft.zububa.webapi.ICallBack;
import com.amarnehsoft.zububa.webapi.ISaveCallBack;

/**
 * Created by user on 3/19/2018.
 */

public interface API<T> {
    void getList(ICallBack<T> callBack);
    void uploadItem(T item,ISaveCallBack callBack);
    void updateItem(String childId,T item,ISaveCallBack callBack);
}
