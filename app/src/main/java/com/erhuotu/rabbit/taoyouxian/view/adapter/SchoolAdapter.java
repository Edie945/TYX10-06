package com.erhuotu.rabbit.taoyouxian.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.erhuotu.rabbit.taoyouxian.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by TWO-2
 * 2018/9/26
 */
public class SchoolAdapter extends RecyclerView.Adapter {

    private List<String> list;
    private Context context;

    public SchoolAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.school_rv_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder holder = (ViewHolder) viewHolder;
        /*holder.school_img.setImageURI(Uri.parse(list.get(i)));
        holder.unfollow.setText(list.get(i));
        holder.school_name.setText(list.get(i));
        holder.school_people.setText(list.get(i));*/

//        holder.school_img.setImageURI(Uri.parse("http://img02.store.sogou.com/app/a/10010016/5654ecf05c472d486d767d9ce5740fa7"));
        Glide.with(context).load("http://img02.store.sogou.com/app/a/10010016/5654ecf05c472d486d767d9ce5740fa7").into(holder.school_img);
        Glide.with(context).load("http://img02.store.sogou.com/app/a/10010016/5654ecf05c472d486d767d9ce5740fa7").into(holder.img1);
        Glide.with(context).load("http://img02.store.sogou.com/app/a/10010016/5654ecf05c472d486d767d9ce5740fa7").into(holder.img2);
        Glide.with(context).load("http://img02.store.sogou.com/app/a/10010016/5654ecf05c472d486d767d9ce5740fa7").into(holder.img3);
        Glide.with(context).load("http://img02.store.sogou.com/app/a/10010016/5654ecf05c472d486d767d9ce5740fa7").into(holder.img4);
        holder.school_name.setText("燕北大学");
        holder.school_people.setText("34092");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView school_img,img1,img2,img3,img4;
        TextView school_name,school_people,unfollow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            school_img = itemView.findViewById(R.id.school_img);
            school_name = itemView.findViewById(R.id.school_name);
            school_people = itemView.findViewById(R.id.school_people);
            unfollow = itemView.findViewById(R.id.unfollow);
            img1 = itemView.findViewById(R.id.school_users_img1);
            img2 = itemView.findViewById(R.id.school_users_img2);
            img3 = itemView.findViewById(R.id.school_users_img3);
            img4 = itemView.findViewById(R.id.school_users_img4);
        }
    }
}
