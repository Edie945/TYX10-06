package com.erhuotu.rabbit.taoyouxian.view.adapter.Mine;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.erhuotu.rabbit.taoyouxian.R;

import java.util.List;

/**
 * Created by TWO-2
 * 2018/9/29
 */
public class MineListAdapter extends BaseAdapter {

    private List<String> list;
    private Context context;

    public MineListAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = View.inflate(context, R.layout.mine_item, null);
            holder = new ViewHolder();
            holder.item_tv = convertView.findViewById(R.id.item_name);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.item_tv.setText(list.get(position));
//        holder.item_tv.setText("啦啦啦啦德玛西亚");
        return convertView;
    }

    public class ViewHolder {
        TextView item_tv;
    }

}
