package com.erhuotu.rabbit.taoyouxian.view.fragment.Findfriends;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.erhuotu.rabbit.taoyouxian.R;
import com.erhuotu.two_2.mvp.BaseFragment;
import com.erhuotu.two_2.mvp.MVP.BaseModel;
import com.erhuotu.two_2.mvp.MVP.BasePresenter;

/**
 * Created by TWO-2
 * 2018/9/29
 */
public class FindFriendsOne extends BaseFragment {
    private View view;
    private ExpandableListView mFindfriendsOneEv;

    @Override
    protected void initView(View view) {

        mFindfriendsOneEv = (ExpandableListView) view.findViewById(R.id.findfriends_one_ev);
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
        return R.layout.findfriendsone;
    }

    @Override
    protected void initData() {

    }
}
