package com.amarnehsoft.zububa.webapi;

import com.amarnehsoft.zububa.webapi.callBacks.ICallBack;
import com.amarnehsoft.zububa.webapi.callBacks.IDeleteCallBack;
import com.amarnehsoft.zububa.webapi.callBacks.ISaveCallBack;

/**
 * Created by user on 3/19/2018.
 */

public interface API<T> {
    void getList(ICallBack<T> callBack);
    void saveItem(String childId,T item,ISaveCallBack callBack);
    void delete(String childId, IDeleteCallBack callBack);
}
