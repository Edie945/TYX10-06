package com.erhuotu.rabbit.taoyouxian.view.fragment.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.erhuotu.rabbit.taoyouxian.R;
import com.erhuotu.rabbit.taoyouxian.view.adapter.SchoolTabAdapter;
import com.erhuotu.two_2.mvp.BaseFragment;
import com.erhuotu.two_2.mvp.MVP.BaseModel;
import com.erhuotu.two_2.mvp.MVP.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TWO-2
 * 2018/9/25
 */
public class SchoolTab extends BaseFragment {
    private View view;
    private RecyclerView mSchoolTabRv;
    private List<String> list = new ArrayList<>();

    @Override
    protected void initView(View view) {
        mSchoolTabRv = (RecyclerView) view.findViewById(R.id.school_tab_rv);
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
        return R.layout.school_tab;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 10; i++) {
            list.add("100(๑′ᴗ‵๑)Ｉ Lᵒᵛᵉᵧₒᵤ❤");
        }
        SchoolTabAdapter schoolTabAdapter = new SchoolTabAdapter(list,getContext());
        mSchoolTabRv.setAdapter(schoolTabAdapter);
        mSchoolTabRv.setNestedScrollingEnabled(false);
        mSchoolTabRv.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
