package com.erhuotu.rabbit.taoyouxian.view.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.erhuotu.rabbit.taoyouxian.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TWO-2
 * 2018/9/25
 */
public class SchoolTabAdapter extends RecyclerView.Adapter {

    private List<String> list;
    private Context context;
    private List<String> imgslist = new ArrayList<>();

    public SchoolTabAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.school_tab_rv_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        final ViewHolder holder = (ViewHolder) viewHolder;
        for (int j = 0; j < 100; j++) {
            imgslist.add("http://img02.store.sogou.com/app/a/10010016/5654ecf05c472d486d767d9ce5740fa7");
        }
        /*holder.school_name.setText(list.get(i));
        holder.user_name.setText(list.get(i));
        holder.content_text.setText(list.get(i));
        holder.authentication_information_text.setText(list.get(i));
        holder.user_img.setImageURI(Uri.parse(list.get(i)));*/
        holder.school_name.setText(i+"麻省理工学院");
        holder.user_name.setText("张伟");
        holder.content_text.setText("精致钢铁侠M-47、血边战甲35:1模型 入手渠道：南锣鼓巷 转手原因：急需钱，急转 价格可再议 支持面交");
        holder.authentication_information_text.setText("学生认证");
//        holder.user_img.setImageURI(Uri.parse("http://img02.store.sogou.com/app/a/10010016/5654ecf05c472d486d767d9ce5740fa7"));
//        Glide.with(context).load("http://img02.store.sogou.com/app/a/10010016/5654ecf05c472d486d767d9ce5740fa7").into(holder.user_img);
        //Glide圆形加载图片
        Glide.with(context).load("http://img02.store.sogou.com/app/a/10010016/5654ecf05c472d486d767d9ce5740fa7").asBitmap().centerCrop().into(new BitmapImageViewTarget(holder.user_img) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                holder.user_img.setImageDrawable(circularBitmapDrawable);
            }
        });
        ImgsAdapter imgsAdapter = new ImgsAdapter(imgslist,context);
        holder.imgs_rv.setAdapter(imgsAdapter);
        holder.imgs_rv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView school_name,user_name,content_text,authentication_information_text;
        ImageView user_img;
        RecyclerView imgs_rv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            user_img = itemView.findViewById(R.id.user_img);
            school_name = itemView.findViewById(R.id.user_school);
            user_name = itemView.findViewById(R.id.user_name);
            content_text = itemView.findViewById(R.id.text_content);
            authentication_information_text = itemView.findViewById(R.id.authentication_information_text);
            imgs_rv = itemView.findViewById(R.id.content_imgs_rv);
        }
    }
}
