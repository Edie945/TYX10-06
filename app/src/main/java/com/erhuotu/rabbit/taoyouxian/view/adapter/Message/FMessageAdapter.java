package com.erhuotu.rabbit.taoyouxian.view.adapter.Message;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.erhuotu.rabbit.taoyouxian.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by TWO-2
 * 2018/9/29
 */
public class FMessageAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {

    private List<String> list;
    private Context context;

    public FMessageAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.friends_message_xrv_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        final ViewHolder holder = (ViewHolder) viewHolder;
        holder.message_time.setText("2018-10-01");
        holder.message_name.setText("筱帝"+i);
        holder.message_content.setText("嘿，十.一出来耍啊");
//        Glide.with(context).load("").transform()
        Glide.with(context).load("http://img02.store.sogou.com/app/a/10010016/5654ecf05c472d486d767d9ce5740fa7").asBitmap().centerCrop().into(new BitmapImageViewTarget(holder.user_img) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                holder.user_img.setImageDrawable(circularBitmapDrawable);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends XRecyclerView.ViewHolder{
        ImageView user_img;
        TextView message_time,message_content,message_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            user_img = itemView.findViewById(R.id.fm_user_img);
            message_content = itemView.findViewById(R.id.fm_user_message_content);
            message_name = itemView.findViewById(R.id.fm_message_user_name);
            message_time = itemView.findViewById(R.id.fm_user_message_time);
        }
    }
}
