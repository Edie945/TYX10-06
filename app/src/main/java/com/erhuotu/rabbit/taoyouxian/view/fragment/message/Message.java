package com.erhuotu.rabbit.taoyouxian.view.fragment.message;

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
import com.erhuotu.rabbit.taoyouxian.view.fragment.Findfriends.FindFriendsThree;
import com.erhuotu.two_2.mvp.BaseFragment;
import com.erhuotu.two_2.mvp.MVP.BaseModel;
import com.erhuotu.two_2.mvp.MVP.BasePresenter;

import java.util.ArrayList;

/**
 * Created by TWO-2
 * 2018/9/25
 */
public class Message extends BaseFragment {
    private View view;
    private TabLayout mMessageTab;
    private ViewPager mMessageVp;
    private String[] titles = {"回复点赞","好友消息","系统消息"};
    private ArrayList<Fragment> fragments;

    @Override
    protected void initView(View view) {
        mMessageTab = (TabLayout) view.findViewById(R.id.message_tab);
        mMessageVp = (ViewPager) view.findViewById(R.id.message_vp);
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
        return R.layout.message;
    }

    @Override
    protected void initData() {
        mMessageTab.setupWithViewPager(mMessageVp);
        for (int i = 0; i < titles.length; i++) {
            mMessageTab.addTab(mMessageTab.newTab().setText(titles[i]));
        }
        fragments = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            fragments.add(new Friends_message());
        }

        mMessageVp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
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
        mMessageTab.getTabAt(1).select();
    }
}
