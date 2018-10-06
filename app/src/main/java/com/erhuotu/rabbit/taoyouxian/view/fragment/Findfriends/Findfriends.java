package com.erhuotu.rabbit.taoyouxian.view.fragment.Findfriends;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erhuotu.rabbit.taoyouxian.R;
import com.erhuotu.two_2.mvp.BaseFragment;
import com.erhuotu.two_2.mvp.MVP.BaseModel;
import com.erhuotu.two_2.mvp.MVP.BasePresenter;

import java.util.ArrayList;

/**
 * Created by TWO-2
 * 2018/9/25
 */
public class Findfriends extends BaseFragment {
    private String[] titles = {"已有", "关注", "粉丝"};
    private View view;
    private TabLayout mFindfriendTab;
    private ViewPager mFindfriendVp;
    private ArrayList<Fragment> fragments;

    @Override
    protected void initView(View view) {

        mFindfriendTab = (TabLayout) view.findViewById(R.id.findfriend_tab);
        mFindfriendVp = (ViewPager) view.findViewById(R.id.findfriend_vp);
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
        return R.layout.findfriends;
    }

    @Override
    protected void initData() {
        mFindfriendTab.setupWithViewPager(mFindfriendVp);
        for (int i = 0; i < titles.length; i++) {
            mFindfriendTab.addTab(mFindfriendTab.newTab().setText(titles[i]));
        }
        fragments = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            fragments.add(new FindFriendsThree());
        }

        mFindfriendVp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
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

        //TabLayout默认选中某选项卡
        mFindfriendTab.getTabAt(1).select();
    }
}
