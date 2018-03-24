package com.amarnehsoft.zububa.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.amarnehsoft.zububa.R;
import com.amarnehsoft.zububa.abstractAdapters.Holder;
import com.amarnehsoft.zububa.abstractAdapters.RecyclerAdapter;
import com.amarnehsoft.zububa.model.Baby;
import com.amarnehsoft.zububa.model.Blog;
import com.amarnehsoft.zububa.model.Comment;
import com.amarnehsoft.zububa.model.Post;
import com.amarnehsoft.zububa.model.Wedding;
import com.amarnehsoft.zububa.webapi.WebApi;
import com.amarnehsoft.zububa.webapi.WebFactory;
import com.amarnehsoft.zububa.webapi.callBacks.ICallBack;
import com.amarnehsoft.zububa.webapi.callBacks.IListCallBack;

import org.w3c.dom.Text;

import java.util.List;

public class CommentsFragment extends Fragment implements IListCallBack<Comment> {
    public final static int TYPE_POST = 1;
    public final static int TYPE_WEDDING = 2;
    public final static int TYPE_BLOG = 3;
    public final static int TYPE_BABY = 4;

    private EditText txtComment;
    private Button btnSend;
    private RecyclerView recyclerView;
    private ProgressBar progressBarLoading;
    private Object mModel;
    private int mType;
    private WebApi mWebApi = WebFactory.getWebService();
    private ICallBack<Boolean> commentListener;
    public CommentsFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mModel = getArguments().getParcelable("model");
        mType = getArguments().getInt("type");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_comments, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //binding
        txtComment = view.findViewById(R.id.txtComment);
        btnSend = view.findViewById(R.id.btnSend);
        recyclerView = view.findViewById(R.id.recyclerView);
        progressBarLoading = view.findViewById(R.id.progressBarLoading);

        //setup recycler
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        //setup progress
        progressBarLoading.setVisibility(View.VISIBLE);

        //setup listeners
        commentListener = new ICallBack<Boolean>() {
            @Override
            public void onResponse(Boolean sent) {
                if(sent)
                    Toast.makeText(getContext(),"Sent",Toast.LENGTH_SHORT).show();
                else
                    onError("error");
            }

            @Override
            public void onError(String err) {
                    Toast.makeText(getContext(),err,Toast.LENGTH_SHORT).show();
            }
        };

        //get Comments
        switch (mType){
            case TYPE_POST:
                mWebApi.getPostComments((Post) mModel, this);
                break;
            case TYPE_BLOG:
                mWebApi.getBlogComments((Blog) mModel, this);
                break;
            case TYPE_WEDDING:
                mWebApi.getWeddingComments((Wedding) mModel, this);
                break;
            case TYPE_BABY:
                mWebApi.getBabyComments((Baby) mModel, this);
                break;

        }
        btnSend.setOnClickListener(v -> {
                    Comment comment = new Comment();
                    comment.setComment(txtComment.getText().toString().trim());
            switch (mType){
                case TYPE_POST:
                    mWebApi.sendCommentForPost((Post)mModel,comment,commentListener);
                    break;
                case TYPE_BABY:
                    mWebApi.sendCommentForBaby((Baby) mModel,comment,commentListener);
                    break;
                case TYPE_BLOG:
                    mWebApi.sendCommentForBlog((Blog)mModel,comment,commentListener);
                    break;
                case TYPE_WEDDING:
                    mWebApi.sendCommentForWedding((Wedding) mModel,comment,commentListener);
                    break;

            }
        });


    }

    // comments available
    @Override
    public void onResponse(List<Comment> value) {
        progressBarLoading.setVisibility(View.GONE);
        MyAdapter adapter = new MyAdapter(value);
        recyclerView.setAdapter(adapter);
    }

    // error getting comments
    @Override
    public void onError(String err) {
        progressBarLoading.setVisibility(View.GONE);
        Toast.makeText(getContext(),err,Toast.LENGTH_SHORT).show();
    }

    class CommentHolder extends Holder<Comment>{
        private TextView tvComment;
        public CommentHolder(View itemView) {
            super(itemView);
            tvComment = itemView.findViewById(R.id.tvComment);
        }

        @Override
        public void bind(Comment item, int pos) {
            super.bind(item, pos);
            tvComment.setText(item.getComment());
        }

        @Override
        public void onClicked(View v) {
        }
    }
    class MyAdapter extends RecyclerAdapter<Comment>{

        public MyAdapter(List<Comment> items) {
            super(items);
        }

        @Override
        public int getLayoutId() {
            return R.layout.item_comment;
        }

        @Override
        public Holder getNewHolder(View v) {
            return new CommentHolder(v);
        }
    }
}
