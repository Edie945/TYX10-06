package com.erhuotu.rabbit.taoyouxian.view.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
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
public class HomeFriendsTabFriends extends BaseFragment {
    private View view;
    private XRecyclerView mXrv;
    private List<String> list = new ArrayList<>();
    private int index = 10;

    @Override
    protected void initView(View view) {

        mXrv = (XRecyclerView) view.findViewById(R.id.xrv);
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
        return R.layout.rv_item;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < index; i++) {
            list.add("http://img02.store.sogou.com/app/a/10010016/5654ecf05c472d486d767d9ce5740fa7");
        }
        mXrv.setLayoutManager(new LinearLayoutManager(getContext()));
        SchoolTabAdapter adapter = new SchoolTabAdapter(list, getContext());
        //调用Adapter展示数据，这个判断是为了不重复创建MyAdapter的对象
            adapter=new SchoolTabAdapter(list,getContext());
            mXrv.setAdapter(adapter);
//        mXrv.setAdapter(adapter);
        mXrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                list.clear();
                index = 0;
                for (int i = 0; i < index; i++) {
                    list.add("http://img02.store.sogou.com/app/a/10010016/5654ecf05c472d486d767d9ce5740fa7");
                }
               mXrv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                index+=10;
                for (int i = 0; i < index; i++) {
                    list.add("http://img02.store.sogou.com/app/a/10010016/5654ecf05c472d486d767d9ce5740fa7");
                }
                mXrv.loadMoreComplete();
            }
        });

    }

}
