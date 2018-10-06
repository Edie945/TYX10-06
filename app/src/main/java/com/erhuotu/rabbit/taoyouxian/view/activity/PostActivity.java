package com.erhuotu.rabbit.taoyouxian.view.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.erhuotu.rabbit.taoyouxian.R;
import com.erhuotu.rabbit.taoyouxian.view.fragment.post.OnePost;
import com.erhuotu.rabbit.taoyouxian.view.fragment.post.PlatformRecovery;
import com.erhuotu.rabbit.taoyouxian.view.fragment.post.PostBooks;
import com.erhuotu.two_2.mvp.BaseActivity;
import com.erhuotu.two_2.mvp.MVP.BaseModel;
import com.erhuotu.two_2.mvp.MVP.BasePresenter;

import java.util.ArrayList;

public class PostActivity extends BaseActivity implements View.OnClickListener {

    private TabLayout mPostTablayout;
    private ViewPager mPostVp;
    private String[] titles = {"一键发布", "发布书籍", "平台回收"};
    private ArrayList<Fragment> fragments;
    private ImageView mPostBack;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_post;
    }

    @Override
    protected void initData() {
        mPostTablayout.setupWithViewPager(mPostVp);
        for (int i = 0; i < titles.length; i++) {
            mPostTablayout.addTab(mPostTablayout.newTab().setText(titles[i]));
        }
        fragments = new ArrayList<>();
        /*for (int i = 0; i < titles.length; i++) {
            OnePost onefragment = new OnePost();
            //bundle传值
            *//*Bundle bundle = new Bundle();
            bundle.putString("title", titles[i]);
            onefragment.setArguments(bundle);*//*
            fragments.add(onefragment);
        }*/
        OnePost onefragment = new OnePost();
        PostBooks postBooks = new PostBooks();
        PlatformRecovery platformRecovery = new PlatformRecovery();
        fragments.add(onefragment);
        fragments.add(postBooks);
        fragments.add(platformRecovery);

        mPostVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
        super.initView();
        mPostTablayout = (TabLayout) findViewById(R.id.post_tablayout);
        mPostVp = (ViewPager) findViewById(R.id.post_vp);
        mPostBack = (ImageView) findViewById(R.id.post_back);
        mPostBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.post_back:
                finish();
                break;
        }
    }
}
