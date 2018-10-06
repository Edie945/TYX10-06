package com.erhuotu.rabbit.taoyouxian.view.fragment.message;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erhuotu.rabbit.taoyouxian.R;
import com.erhuotu.rabbit.taoyouxian.view.adapter.Message.FMessageAdapter;
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
public class Friends_message extends BaseFragment {
    private View view;
    private XRecyclerView mFriendsMessageXrv;
    private List<String> list = new ArrayList<>();
    private int index = 10;
    @Override
    protected void initView(View view) {
        mFriendsMessageXrv = (XRecyclerView) view.findViewById(R.id.friends_message_xrv);
        mFriendsMessageXrv.setLayoutManager(new LinearLayoutManager(getContext()));
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
        return R.layout.friends_message;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < index; i++) {
            list.add("http://img02.store.sogou.com/app/a/10010016/5654ecf05c472d486d767d9ce5740fa7");
        }
        FMessageAdapter fMessageAdapter = new FMessageAdapter(list, getContext());
        mFriendsMessageXrv.setAdapter(fMessageAdapter);
        mFriendsMessageXrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        list.clear();
//                        mFriendsMessageXrv.notifyAll();
                        for (int i = 0; i < index; i++) {
                            list.add("http://img02.store.sogou.com/app/a/10010016/5654ecf05c472d486d767d9ce5740fa7");
                        }
                        mFriendsMessageXrv.refreshComplete();
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
                        mFriendsMessageXrv.loadMoreComplete();
                    }
                },2000);
            }
        });
    }
}
