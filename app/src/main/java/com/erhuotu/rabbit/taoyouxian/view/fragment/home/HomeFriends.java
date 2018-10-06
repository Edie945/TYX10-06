package com.erhuotu.rabbit.taoyouxian.view.fragment.home;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.erhuotu.rabbit.taoyouxian.R;
import com.erhuotu.rabbit.taoyouxian.view.fragment.Findfriends.Findfriends;
import com.erhuotu.rabbit.taoyouxian.view.fragment.message.Message;
import com.erhuotu.rabbit.taoyouxian.view.fragment.mine.Mine;
import com.erhuotu.two_2.mvp.BaseFragment;
import com.erhuotu.two_2.mvp.MVP.BaseModel;
import com.erhuotu.two_2.mvp.MVP.BasePresenter;

import java.util.ArrayList;

/**
 * Created by TWO-2
 * 2018/9/28
 */
public class HomeFriends extends BaseFragment  {
    private View view;
    private TabLayout mHomeFriendsTab;
    private ViewPager mHomeFriendsVp;
    private String[] titles = {"好友动态", "关注动态"};
    private ArrayList<Fragment> fragments;
    /**
     * 好友动态
     */
    private RadioButton mFrinendsRdFriends;
    /**
     * 关注动态
     */
    private RadioButton mFrinendsRdFollow;
    private RadioGroup mFriendRadiogroup;
    private FrameLayout mFriendsFrame;
    private ArrayList<Fragment> arrayList;
    private FragmentManager manager;
    private HomeFriendsTab homeFriendsTab = new HomeFriendsTab();
    private HomeFriendsTabFriends homeFriendsTabFriends = new HomeFriendsTabFriends();

    @Override
    protected void initView(View view) {
//        mHomeFriendsTab = (TabLayout) view.findViewById(R.id.home_friends_tab);
//        mHomeFriendsVp = (ViewPager) view.findViewById(R.id.home_friends_vp);
        mFrinendsRdFriends = (RadioButton) view.findViewById(R.id.frinends_rd_friends);
//        mFrinendsRdFriends.setOnClickListener(this);
        mFrinendsRdFollow = (RadioButton) view.findViewById(R.id.frinends_rd_follow);
//        mFrinendsRdFollow.setOnClickListener(this);
        mFriendRadiogroup = (RadioGroup) view.findViewById(R.id.friend_radiogroup);
        mFriendsFrame = (FrameLayout) view.findViewById(R.id.friends_frame);
        initFrameLayout();
    }
    private void initFrameLayout() {
        manager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        if(homeFriendsTab ==null){
            homeFriendsTab = new HomeFriendsTab();
            fragmentTransaction.add(R.id.home_frame, homeFriendsTab);
        }
        hideFragment(fragmentTransaction);
        fragmentTransaction.show(homeFriendsTab).commit();

    }
    private void hideFragment(FragmentTransaction fragmentTransaction){
        if(homeFriendsTab!=null){
            fragmentTransaction.hide(homeFriendsTab);
        }
        homeFriendsTabFriends = new HomeFriendsTabFriends();
        if(homeFriendsTabFriends!=null){
            fragmentTransaction.hide(homeFriendsTabFriends);
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
        return R.layout.home_friends;
    }

    @Override
    protected void initData() {

        /*mFriendRadiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.frinends_rd_friends:
                        mFrinendsRdFriends.setTextSize(20);
                        mFrinendsRdFriends.setTextColor(getResources().getColor(R.color.school_text));
                        mFrinendsRdFollow.setTextColor(getResources().getColor(R.color.search_text));
                        mFrinendsRdFollow.setTextSize(18);
//                        manager.beginTransaction().replace(R.id.friends_frame, arrayList.get(0)).commit();
                        FragmentTransaction fragmentTransaction = manager.beginTransaction();
                        if(homeFriendsTab == null){
                            homeFriendsTab = new HomeFriendsTab();
                            fragmentTransaction.add(R.id.friends_frame, homeFriendsTab);
                        }
                        hideFragment(fragmentTransaction);
                        fragmentTransaction.show(homeFriendsTab).commit();
                        break;
                    case R.id.frinends_rd_follow:
                        mFrinendsRdFollow.setTextSize(20);
                        mFrinendsRdFollow.setTextColor(getResources().getColor(R.color.school_text));
                        mFrinendsRdFriends.setTextColor(getResources().getColor(R.color.search_text));
                        mFrinendsRdFriends.setTextSize(18);
//                        manager.beginTransaction().replace(R.id.friends_frame, arrayList.get(1)).commit();
                        FragmentTransaction fragmentTransaction2 = manager.beginTransaction();
                        if(homeFriendsTabFriends ==null){
                            homeFriendsTabFriends = new HomeFriendsTabFriends();
                            fragmentTransaction2.add(R.id.friends_frame, homeFriendsTabFriends);
                        }
                        hideFragment(fragmentTransaction2);
                        fragmentTransaction2.show(homeFriendsTabFriends).commit();
                        break;
                }
            }
        });*/

        arrayList = new ArrayList<>();
        final HomeFriendsTab homeFriendsTab = new HomeFriendsTab();
        final HomeFriendsTabFriends homeFriendsTabFriends = new HomeFriendsTabFriends();
        arrayList.add(homeFriendsTab);
        arrayList.add(homeFriendsTabFriends);
        manager = getChildFragmentManager();
        manager.beginTransaction().add(R.id.friends_frame, arrayList.get(0)).commit();
        mFriendRadiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.frinends_rd_friends:
                        mFrinendsRdFriends.setTextColor(getResources().getColor(R.color.school_text));
                        mFrinendsRdFollow.setTextColor(getResources().getColor(R.color.search_text));
                        mFrinendsRdFriends.setTextSize(20);
                        mFrinendsRdFollow.setTextSize(18);
                        manager.beginTransaction().replace(R.id.friends_frame, homeFriendsTab).commit();
                        break;
                    case R.id.frinends_rd_follow:
                        mFrinendsRdFollow.setTextColor(getResources().getColor(R.color.school_text));
                        mFrinendsRdFriends.setTextColor(getResources().getColor(R.color.search_text));
                        mFrinendsRdFollow.setTextSize(20);
                        mFrinendsRdFriends.setTextSize(18);
                        manager.beginTransaction().replace(R.id.friends_frame, homeFriendsTabFriends).commit();
                        break;
                }
            }
        });
        /*mHomeFriendsTab.setupWithViewPager(mHomeFriendsVp);
        for (int i = 0; i < titles.length; i++) {
            mHomeFriendsTab.addTab(mHomeFriendsTab.newTab().setText(titles[i]));
        }
        fragments = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            HomeFriendsTab fragment = new HomeFriendsTab();
            //bundle传值
            Bundle bundle = new Bundle();
            bundle.putString("title", titles[i]);
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        mHomeFriendsVp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
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
        });*/
    }

    /*@Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.frinends_rd_friends:
                mFrinendsRdFriends.setTextSize(20);
                mFrinendsRdFollow.setTextSize(18);
                break;
            case R.id.frinends_rd_follow:
                mFrinendsRdFollow.setTextSize(20);
                mFrinendsRdFriends.setTextSize(18);
                break;
        }
    }*/
}
