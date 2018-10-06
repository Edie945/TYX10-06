package com.erhuotu.rabbit.taoyouxian.view.adapter.Post;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.erhuotu.rabbit.taoyouxian.R;

import java.util.List;

/**
 * Created by TWO-2
 * 2018/9/27
 */
public class Post_Images_Adapter extends RecyclerView.Adapter {
    private static final String TAG = "Post_Images_Adapter";
    private List<Uri> list;
    private Context context;

    public Post_Images_Adapter(List<Uri> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.post_imgs_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder holder = (ViewHolder) viewHolder;
//        Glide.with(context).load(list.get(i).toString()).into(holder.img);
        for (int j = 0; j < list.size(); j++) {
            Glide.with(context).load("http://img02.store.sogou.com/app/a/10010016/5654ecf05c472d486d767d9ce5740fa7").into(holder.img);
            Log.e(TAG, "onBindViewHolder: "+list.toString() );
            Log.e(TAG, "onBindViewHolder: 111111111111111111111" );
            Log.e(TAG, "onBindViewHolder: "+list.get(i).toString() );
        }

    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    public void setData(List<Uri> data) {
        if(data!=null){
            this.list = data;
            notifyDataSetChanged();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.post_imgs);
        }
    }

}
