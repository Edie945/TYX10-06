package com.erhuotu.rabbit.taoyouxian.view.fragment.Findfriends;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erhuotu.rabbit.taoyouxian.R;
import com.erhuotu.rabbit.taoyouxian.view.adapter.Finddriends.FFThreeAdapter;
import com.erhuotu.two_2.mvp.BaseFragment;
import com.erhuotu.two_2.mvp.MVP.BaseModel;
import com.erhuotu.two_2.mvp.MVP.BasePresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TWO-2
 * 2018/9/29
 */
public class FindFriendsThree extends BaseFragment {
    private View view;
    private XRecyclerView mFindfriendsThreeRv;
    private List<String> list = new ArrayList<>();
    private int index = 10;

    @Override
    protected void initView(View view) {
        mFindfriendsThreeRv = (XRecyclerView) view.findViewById(R.id.findfriends_three_rv);
        mFindfriendsThreeRv.setLayoutManager(new LinearLayoutManager(getContext()));
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
        return R.layout.findfriendsthree;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < index; i++) {
            list.add("1");
        }
        final FFThreeAdapter adapter = new FFThreeAdapter(list, getContext());
        mFindfriendsThreeRv.setAdapter(adapter);
        mFindfriendsThreeRv.setLoadingListener(new XRecyclerView.LoadingListener() {
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
                        mFindfriendsThreeRv.refreshComplete();
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
                        mFindfriendsThreeRv.loadMoreComplete();
                    }
                },2000);
            }
        });
    }
}
