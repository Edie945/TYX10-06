package com.erhuotu.rabbit.taoyouxian.view.adapter.Finddriends;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
public class FFThreeAdapter extends XRecyclerView.Adapter {
    private static final String TAG = "FFThreeAdapter";
    private List<String> list;
    private Context context;

    public FFThreeAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.findfriends_three_rv_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        final ViewHolder holder = (ViewHolder) viewHolder;
        holder.user_name.setText("昵称"+i);
        holder.user_authentication.setText("认证(O_o)??");
        Glide.with(context).load("http://img02.store.sogou.com/app/a/10010016/5654ecf05c472d486d767d9ce5740fa7").asBitmap().centerCrop().into(new BitmapImageViewTarget(holder.user_img) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                holder.user_img.setImageDrawable(circularBitmapDrawable);
            }
        });
        holder.add_friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick: 加好友" );
            }
        });
        holder.add_attention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick: 加关注" );
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends XRecyclerView.ViewHolder{
        ImageView user_img,add_friend,add_attention;
        TextView user_name,user_authentication;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            user_img = itemView.findViewById(R.id.findfriends_three_rv_item_user_img);
            user_authentication = itemView.findViewById(R.id.findfriends_three_rv_item_user_authentication);
            user_name = itemView.findViewById(R.id.findfriends_three_rv_item_user_name);
            add_attention = itemView.findViewById(R.id.add_attention);
            add_friend = itemView.findViewById(R.id.add_friends);
        }
    }

}
