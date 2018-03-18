package com.amarnehsoft.zububa.firebase;

/**
 * Created by user on 3/18/2018.
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ProgressBar;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;

public abstract class FirebaseHelper<T> {
    //T : Model
    protected Class<T> entityClass;
    protected RecyclerView.Adapter<RecyclerView.ViewHolder> mAdapter;
    private Listiner mListener;
    private ProgressDialog mProgressDialog;
    private String dialogMsg = "getting data ...";
    protected Context mContext;
    protected ProgressBar mProgressBar;

    DatabaseReference db;
    Boolean saved=null;
    ArrayList<T> beans = new ArrayList<>();

    protected boolean showProgressDialog(){
        return false;
    }

    protected FirebaseHelper(){}

    public FirebaseHelper(Class<T> entityClass, Context context,boolean retrive){
        mContext = context;
        this.entityClass = entityClass;
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        int level = 0;
        while (getRefName(level) != null){
            if (level == 0){
                this.db = database.getReference(getRefName(level));
            }else {
                db = db.child(getRefName(level));
            }
            Log.e("Amarneh","level=" + level + ",,ref="+getRefName(level));
            level++;
        }


        if (retrive) {
            if (showProgressDialog()) {
                mProgressDialog = new ProgressDialog(context);
                mProgressDialog.setMessage(dialogMsg);
                mProgressDialog.setCancelable(false);
            }
            retrieve();
        }
    }

    public void setListener(Listiner listener){
        this.mListener = listener;
    }

    public void setAdapter(RecyclerView.Adapter adapter){
        mAdapter = adapter;
    }

    public void setDialogMsg(String msg){
        dialogMsg = msg; // this is redundant
        if (mProgressDialog != null)
            mProgressDialog.setMessage(msg);
    }

    protected T newBean(){
        T bean = null;
        try {
            bean = (T)entityClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return bean;
    }

    //SAVE
    public Boolean save(T bean,String code)
    {
        if(bean==null)
        {
            saved=false;
        }else {
            try
            {
//                    db.push().setValue(bean);
                db.child(code).setValue(bean);
                saved=true;
            }catch (DatabaseException e)
            {
                e.printStackTrace();
                saved=false;
            }
        }
        return saved;
    }

    public Boolean delete(String code)
    {
        if(false)
        {
            saved=false;
        }else {
            try
            {
//                    db.push().setValue(bean);
                db.child(code).removeValue();
                saved=true;
            }catch (DatabaseException e)
            {
                e.printStackTrace();
                saved=false;
            }
        }
        return saved;
    }
    //READ
    public ArrayList<T> retrieve()
    {
        Log.e("Amarneh","start retrieving .. ");
        if (mProgressDialog != null)
            mProgressDialog.show();

        ChildEventListener l = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String code) {
                Log.e("Amarneh","FirebaseHelper.retrieve.onChildAdded.code="+code);
                FirebaseHelper.this.onChildAdded(dataSnapshot,code);
                if (mProgressDialog != null)
                    mProgressDialog.dismiss();
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                //FirebaseHelper.this.onChildAdded(dataSnapshot);
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };

        Query q = orderBy(db);

        if (q != null){
            q.addChildEventListener(l);
        }else {
            db.addChildEventListener(l);
        }

        return beans;
    }

    private void onChildAdded(DataSnapshot dataSnapshot,String code)
    {
        Log.e("Amarneh","on child added");
        T bean = dataSnapshot.getValue(entityClass);

        if (addBeanToList(bean)){
            beans.add(bean);
            if (mListener != null)
                mListener.onChildAdded(bean,code);

            if (mAdapter != null)
                mAdapter.notifyDataSetChanged();
        }

        afterChildAdded(bean,code);
    }

    protected void afterChildAdded(T bean,String code){}

    public List<T> getList(){
        return beans;
    }

    protected boolean addBeanToList(T bean){
        return true;
    }

    protected abstract String getRefName(int level);

    protected Query orderBy(DatabaseReference db){
        return null;
    }

    public List<T> search(String query){
        List<T> result = new ArrayList<>();
        for (T bean : beans){
            if (addBeanToSearchList(bean,query))
                result.add(bean);
        }
        return result;
    }

    protected abstract boolean addBeanToSearchList(T bean,String query);

    public interface Listiner{
        void onChildAdded(Object bean,String code);
    }
}