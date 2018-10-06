package com.erhuotu.rabbit.taoyouxian.view.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.erhuotu.rabbit.taoyouxian.R;
import com.erhuotu.rabbit.taoyouxian.view.fragment.home.SchoolTab;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TWO-2
 * 2018/9/28
 */
public class Home_Tab_Adapter extends RecyclerView.Adapter{
    private Context context;
    private String[] titles;
    private List<Fragment> fragments;
    private FragmentManager manager;

    public Home_Tab_Adapter(Context context, String[] titles, List<Fragment> fragments, FragmentManager manager) {
        this.context = context;
        this.titles = titles;
        this.fragments = fragments;
        this.manager = manager;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context, R.layout.home_tab_layout,null);
        Home_Tab_ViewHolder home_tab_viewHolder = new Home_Tab_ViewHolder(view);
        return home_tab_viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Home_Tab_ViewHolder holder = (Home_Tab_ViewHolder) viewHolder;
        holder.viewPager.setId(i+1);
        holder.tab.setupWithViewPager(holder.viewPager);
        for (int j = 0; j < titles.length; j++) {
            holder.tab.addTab(holder.tab.newTab().setText(titles[j]));
        }

        fragments = new ArrayList<>();
        for (int j = 0; j < titles.length; j++) {
            SchoolTab fragment = new SchoolTab();
            //bundle传值
           /* Bundle bundle = new Bundle();
            bundle.putString("title", titles[j]);
            fragment.setArguments(bundle);*/
            fragments.add(fragment);
        }
        holder.viewPager.setAdapter(new FragmentPagerAdapter(manager) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });
    }

    @Override
    public int getItemCount() {
        /*if(titles == null){
            return 0;
        }else{
            return titles.length;
        }*/
        return 1;
    }
    public class Home_Tab_ViewHolder extends RecyclerView.ViewHolder{
        private TabLayout tab;
        private ViewPager viewPager;
        public Home_Tab_ViewHolder(@NonNull View itemView) {
            super(itemView);
            tab = itemView.findViewById(R.id.home_school_tablayout);
            viewPager = itemView.findViewById(R.id.home_school_tab_vp);
        }
    }
}
