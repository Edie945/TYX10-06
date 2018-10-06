package com.erhuotu.rabbit.taoyouxian.view.fragment.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.erhuotu.rabbit.taoyouxian.R;
import com.erhuotu.two_2.mvp.BaseFragment;
import com.erhuotu.two_2.mvp.MVP.BaseModel;
import com.erhuotu.two_2.mvp.MVP.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TWO-2
 * 2018/9/25
 */
public class Home extends BaseFragment implements View.OnClickListener {
    private View view;
    private TabLayout mHomeTablayout;
    private ViewPager mHomeTabVp;
    private String[] titles = {"好友", "发现", "热门"};
    private List<String> titles_list = new ArrayList<>();
    private ArrayList<Fragment> fragments;
    private Context context;
    private EditText mSearchEdit;
    private LinearLayout mTabLl;
    private RelativeLayout mSearchRelativeLayout;
    private FragmentManager manager;
    private ArrayList<Fragment> arrayList;
    private HomeFriends homeFriends;
    private HomeHot homeHot;
    private HomeTab homeTab;
    private RelativeLayout home_haoyou;
    private RelativeLayout home_faxian;
    private RelativeLayout home_remen;
    private View remen_view;
    private View haoyou_view;
    private View faxian_view;
    private TextView mHaoyou;
    private View mHaoyouView;
    private RelativeLayout mHomeHaoyou;
    private TextView mFaxian;
    private View mFaxianView;
    private RelativeLayout mHomeFaxian;
    private TextView mRemen;
    private View mRemenView;
    private RelativeLayout mHomeRemen;
    private LinearLayout mTabLinear;
    private RelativeLayout mSearchRelativelayout;
    private FrameLayout mHomeFrame;
    private FrameLayout home_frame;


    @Override
    protected void initView(View view) {
        mSearchRelativeLayout = (RelativeLayout) view.findViewById(R.id.search_relativelayout);
        mTabLl = (LinearLayout) view.findViewById(R.id.tab_ll);
        mHaoyou = (TextView) view.findViewById(R.id.haoyou);
        mHaoyouView = (View) view.findViewById(R.id.haoyou_view);
        mHomeHaoyou = (RelativeLayout) view.findViewById(R.id.home_haoyou);
        mFaxian = (TextView) view.findViewById(R.id.faxian);
        mFaxianView = (View) view.findViewById(R.id.faxian_view);
        mHomeFaxian = (RelativeLayout) view.findViewById(R.id.home_faxian);
        mRemen = (TextView) view.findViewById(R.id.remen);
        mRemenView = (View) view.findViewById(R.id.remen_view);
        mHomeRemen = (RelativeLayout) view.findViewById(R.id.home_remen);
        mTabLinear = (LinearLayout) view.findViewById(R.id.tab_linear);
        mSearchEdit = (EditText) view.findViewById(R.id.search_edit);
        mSearchRelativelayout = (RelativeLayout) view.findViewById(R.id.search_relativelayout);
        mHomeFrame = (FrameLayout) view.findViewById(R.id.home_frame);
        mHomeHaoyou.setOnClickListener(this);
        mHomeFaxian.setOnClickListener(this);
        mHomeRemen.setOnClickListener(this);
        mTabLl.setOnClickListener(this);
        mFaxian.setTextSize(30);
        mHaoyou.setTextSize(25);
        mRemen.setTextSize(25);
        home_frame = view.findViewById(R.id.home_frame);
        //初始化页面
        initFrameLayout();
    }

    /**
     * 初始显示fragment
     */
    private void initFrameLayout() {
        manager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        if (homeTab == null) {
            homeTab = new HomeTab();
            fragmentTransaction.add(R.id.home_frame, homeTab);
        }
        hideFragment(fragmentTransaction);
        fragmentTransaction.show(homeTab).commit();

    }

    /**
     * 隐藏fragment
     * @param fragmentTransaction
     */
    private void hideFragment(FragmentTransaction fragmentTransaction) {
        if (homeFriends != null) {
            fragmentTransaction.hide(homeFriends);
        }
        if (homeHot != null) {
            fragmentTransaction.hide(homeHot);
        }
        if (homeTab != null) {
            fragmentTransaction.hide(homeTab);
        }
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
        return R.layout.home;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab_ll:
                break;
            case R.id.home_haoyou:
                mHaoyou.setTextSize(30);
                mFaxian.setTextSize(25);
                mRemen.setTextSize(25);
                mHaoyouView.setVisibility(View.VISIBLE);
                mFaxianView.setVisibility(View.INVISIBLE);
                mRemenView.setVisibility(View.INVISIBLE);
                FragmentTransaction fragmentTransaction = manager.beginTransaction();
                if (homeFriends == null) {
                    homeFriends = new HomeFriends();
                    fragmentTransaction.add(R.id.home_frame, homeFriends);
                }
                hideFragment(fragmentTransaction);
                fragmentTransaction.show(homeFriends).commit();
                break;
            case R.id.home_remen:
                mRemen.setTextSize(30);
                mFaxian.setTextSize(25);
                mHaoyou.setTextSize(25);
                mRemenView.setVisibility(View.VISIBLE);
                mFaxianView.setVisibility(View.INVISIBLE);
                mHaoyouView.setVisibility(View.INVISIBLE);
                FragmentTransaction fragmentTransaction2 = manager.beginTransaction();
                if (homeHot == null) {
                    homeHot = new HomeHot();
                    fragmentTransaction2.add(R.id.home_frame, homeHot);
                }
                hideFragment(fragmentTransaction2);
                fragmentTransaction2.show(homeHot).commit();
                break;
            case R.id.home_faxian:
                mFaxian.setTextSize(30);
                mHaoyou.setTextSize(25);
                mRemen.setTextSize(25);
                mFaxianView.setVisibility(View.VISIBLE);
                mHaoyouView.setVisibility(View.INVISIBLE);
                mRemenView.setVisibility(View.INVISIBLE);
                FragmentTransaction fragmentTransaction3 = manager.beginTransaction();
                if (homeTab == null) {
                    homeTab = new HomeTab();
                    fragmentTransaction3.add(R.id.home_frame, homeTab);
                }
                hideFragment(fragmentTransaction3);
                fragmentTransaction3.show(homeTab).commit();
                break;
            default:
                break;
        }
    }
}
