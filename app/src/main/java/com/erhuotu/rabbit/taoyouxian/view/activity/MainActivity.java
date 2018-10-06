package com.erhuotu.rabbit.taoyouxian.view.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.erhuotu.rabbit.taoyouxian.R;
import com.erhuotu.rabbit.taoyouxian.view.fragment.Findfriends.Findfriends;
import com.erhuotu.rabbit.taoyouxian.view.fragment.home.Home;
import com.erhuotu.rabbit.taoyouxian.view.fragment.message.Message;
import com.erhuotu.rabbit.taoyouxian.view.fragment.mine.Mine;
import com.erhuotu.two_2.mvp.BaseActivity;
import com.erhuotu.two_2.mvp.MVP.BaseModel;
import com.erhuotu.two_2.mvp.MVP.BasePresenter;
import com.hjm.bottomtabbar.BottomTabBar;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private BottomTabBar mBottomtabbar;
    private FragmentManager manager;
    private FrameLayout mFrame;
    private RadioButton mRdHome;
    private RadioButton mRdFindfriend;
    private RadioButton mRdPost;
    private RadioButton mRdMessage;
    private RadioButton mRdMine;
    private RadioGroup mRadiogroup;
    private ArrayList<Fragment> arrayList = new ArrayList<>();
    private RelativeLayout mRlVoteContainer;
    private ImageView mIvVoteWhole;
    private TextView mTvVoteWhole;
    private LinearLayout mIndexLl;
    private ImageView mIvVoteSponsor;
    private TextView mTvVoteSponsor;
    private LinearLayout mFriendLl;
    private ImageView mIvVoteAdd;
    private TextView mTvVoteAdd;
    private LinearLayout mPostLl;
    private ImageView mIvVoteParticipant;
    private TextView mTvVoteParticipant;
    private LinearLayout mMessageLl;
    private ImageView mIvVoteDraft;
    private TextView mTvVoteDraft;
    private LinearLayout mMineLl;
    private Home home;
    private Findfriends findfriends;
    private Message message;
    private Mine mine;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        if(home==null){
            manager = getSupportFragmentManager();
            home=new Home();
            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            fragmentTransaction.add(R.id.frame, home);
            hideFragment(fragmentTransaction);
            fragmentTransaction.show(home).commit();
        }
        mRadiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rd_home:
                        FragmentTransaction fragmentTransaction = manager.beginTransaction();
                        if(home==null){
                            home = new Home();
                            fragmentTransaction.add(R.id.frame,home);
                        }
                        hideFragment(fragmentTransaction);
                        fragmentTransaction.show(home).commit();
                        break;
                    case R.id.rd_findfriend:
                        FragmentTransaction fragmentTransaction2 = manager.beginTransaction();
                        if(findfriends==null){
                            findfriends = new Findfriends();
                            fragmentTransaction2.add(R.id.frame, findfriends);
                        }
                        hideFragment(fragmentTransaction2);
                        fragmentTransaction2.show(findfriends).commit();
                        break;
                    case R.id.rd_post:

                        break;
                    case R.id.rd_message:
                        FragmentTransaction fragmentTransaction3 = manager.beginTransaction();
                        if(message==null){
                            message = new Message();
                            fragmentTransaction3.add(R.id.frame, message);
                        }
                        hideFragment(fragmentTransaction3);
                        fragmentTransaction3.show(message).commit();
                        break;
                    case R.id.rd_mine:
                        FragmentTransaction fragmentTransaction4 = manager.beginTransaction();
                        if(mine==null){
                            mine = new Mine();
                            fragmentTransaction4.add(R.id.frame, mine);
                        }
                        hideFragment(fragmentTransaction4);
                        fragmentTransaction4.show(mine).commit();
                        break;
                }
            }
        });
    }
    private void hideFragment(FragmentTransaction fragmentTransaction){
        if(home!=null){
            fragmentTransaction.hide(home);
        }
        if(findfriends!=null){
            fragmentTransaction.hide(findfriends);
        }
        if(message!=null){
            fragmentTransaction.hide(message);
        }
        if(mine!=null){
            fragmentTransaction.hide(mine);
        }
    }
    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected BaseModel initModel() {
        return null;
    }

    @Override
    public void initView() {
        mFrame = (FrameLayout) findViewById(R.id.frame);
        mRdHome = (RadioButton) findViewById(R.id.rd_home);
        mRdFindfriend = (RadioButton) findViewById(R.id.rd_findfriend);
        mRdPost = (RadioButton) findViewById(R.id.rd_post);
        mRdMessage = (RadioButton) findViewById(R.id.rd_message);
        mRdMine = (RadioButton) findViewById(R.id.rd_mine);
        mRadiogroup = (RadioGroup) findViewById(R.id.radiogroup);

    }
 }
