package com.erhuotu.rabbit.taoyouxian.view.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erhuotu.rabbit.taoyouxian.R;
import com.erhuotu.rabbit.taoyouxian.view.adapter.SchoolTabAdapter;
import com.erhuotu.two_2.mvp.BaseFragment;
import com.erhuotu.two_2.mvp.MVP.BaseModel;
import com.erhuotu.two_2.mvp.MVP.BasePresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TWO-2
 * 2018/9/28
 */
public class HomeFriendsTab extends BaseFragment {
    private View view;
    private XRecyclerView mHomeFriendsTabRv;
    private List<String> list = new ArrayList<>();

    @Override
    protected void initView(View view) {
        mHomeFriendsTabRv = (XRecyclerView) view.findViewById(R.id.home_friends_tab_rv);
        mHomeFriendsTabRv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected BaseModel initModel() {
        return null;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayoutid() {
        return R.layout.home_friends_tab;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 10; i++) {
            list.add("http://img02.store.sogou.com/app/a/10010016/5654ecf05c472d486d767d9ce5740fa7");
        }
        SchoolTabAdapter adapter = new SchoolTabAdapter(list, getContext());
        mHomeFriendsTabRv.setAdapter(adapter);
    }

}
