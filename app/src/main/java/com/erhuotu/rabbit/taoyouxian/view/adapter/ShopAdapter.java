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
 * 2018/9/25
 */
public class ShopAdapter extends RecyclerView.Adapter {

    private List<String> list;
    private Context context;

    public ShopAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.home_shop_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder holder = (ViewHolder) viewHolder;
        holder.shop_name.setText("Android官方旗舰店");
//        holder.shop_img.setImageURI(list.get(i));
        Glide.with(context).load(list.get(i)).into(holder.shop_img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView shop_img;
        TextView shop_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shop_img = itemView.findViewById(R.id.shop_img);
            shop_name = itemView.findViewById(R.id.shop_name);
        }
    }
}
