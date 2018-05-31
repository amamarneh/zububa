package com.amarnehsoft.zububa.repo;

import android.support.annotation.Nullable;

/*
    Created By ALa
 */

public class Task<T> {
    private T result;
    private boolean isSuccessful=false;
    private TaskResponse<T> mListener;
    private boolean isCompleted=false;


    public Task(TaskResponse<T> mListener) {
        this.mListener = mListener;
    }
    public void addOnCompleteListener(TaskResponse<T> response){
        this.mListener = response;
        notifyResponse();
    }

    public Task() {
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    private void setResult(T result){
        this.result = result;
    }
    public T getResult(){
        return result;
    }
    public synchronized void response(@Nullable T result, boolean isSuccessful){
        this.isCompleted=true;
        this.isSuccessful=isSuccessful;
        if(isSuccessful){
            setResult(result);
        }else{
            //
        }
        notifyResponse();

    }
    private void notifyResponse(){
        if(!isCompleted)
            return;
        if(mListener != null)
            mListener.onResponse(this);
    }

    public synchronized void cancel(){
        mListener = null;
    }

    public interface TaskResponse<T>{
        void onResponse(Task<T> task);
    }
}
