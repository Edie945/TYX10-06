package com.erhuotu.rabbit.taoyouxian.view.fragment.home;

import android.os.Bundle;
import android.os.Handler;
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
public class HomeHot extends BaseFragment {
    private View view;
    private XRecyclerView mHomeHotRv;
    private List<String> list = new ArrayList<>();
    private int index = 10;
    @Override
    protected void initView(View view) {
        mHomeHotRv = (XRecyclerView) view.findViewById(R.id.home_hot_rv);
        mHomeHotRv.setLayoutManager(new LinearLayoutManager(getContext()));
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
        return R.layout.home_hot;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < index; i++) {
            list.add("http://img02.store.sogou.com/app/a/10010016/5654ecf05c472d486d767d9ce5740fa7");
        }
        final SchoolTabAdapter adapter = new SchoolTabAdapter(list, getContext());
        mHomeHotRv.setAdapter(adapter);
        mHomeHotRv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        /*con=1;//con不等于0就执行上啦加载
                        okhttp(i);//okhttp解析数据
                        RV_all.loadMoreComplete();    //加载数据完成（取消加载动画）*/
                        list.clear();
                        index = 10;
                        adapter.notifyDataSetChanged();
                        for (int i = 0; i < index; i++) {
                            list.add("http://img02.store.sogou.com/app/a/10010016/5654ecf05c472d486d767d9ce5740fa7");
                        }
                        mHomeHotRv.refreshComplete();
                    }
                },2000);
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        index += 10;
                        for (int i = 0; i < index; i++) {
                            list.add("http://img02.store.sogou.com/app/a/10010016/5654ecf05c472d486d767d9ce5740fa7");
                        }
                        mHomeHotRv.loadMoreComplete();
                    }
                },2000);
            }
        });
    }
}
