package com.erhuotu.rabbit.taoyouxian.view.fragment.home;

import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.erhuotu.rabbit.taoyouxian.R;
import com.erhuotu.rabbit.taoyouxian.view.adapter.Home_Tab_Adapter;
import com.erhuotu.rabbit.taoyouxian.view.adapter.SchoolAdapter;
import com.erhuotu.rabbit.taoyouxian.view.adapter.ShopAdapter;
import com.erhuotu.rabbit.taoyouxian.widget.SpaceItemDecoration;
import com.erhuotu.two_2.mvp.BaseFragment;
import com.erhuotu.two_2.mvp.MVP.BaseModel;
import com.erhuotu.two_2.mvp.MVP.BasePresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TWO-2
 * 2018/9/25
 */
public class HomeTab extends BaseFragment implements View.OnClickListener {
    private View view;
    private RecyclerView mHomeTabShopRv;
    private ImageView mHomeTabTrusteeshipArea;
//    private SimpleDraweeView mSchoolImg;
    private ImageView mSchoolImg;
    private TextView mSchoolName;
    private TextView mSchoolPeople;
    private TabLayout mHomeSchoolTablayout;
    private ViewPager mHomeSchoolTabVp;
    private String[] titles = {"推荐", "服饰美妆", "寝室用品", "图书文具", "数码设备", "精致模型", "装饰物品", "罕见之物",};
    private ArrayList<Fragment> fragments;
    private List<String> list = new ArrayList<>();
    private RecyclerView mSchoolRv;
    private XRecyclerView home_tab_recy;
    private int index = 10;

    @Override
    protected void initView(View view) {

        mHomeTabShopRv = (RecyclerView) view.findViewById(R.id.home_tab_shop_rv);
        mHomeTabTrusteeshipArea = (ImageView) view.findViewById(R.id.home_tab_trusteeship_area);
        mHomeTabTrusteeshipArea.setOnClickListener(this);
//        mSchoolImg = (SimpleDraweeView) view.findViewById(R.id.school_img);
        mSchoolImg = (ImageView) view.findViewById(R.id.school_img);
        mSchoolName = (TextView) view.findViewById(R.id.school_name);
        mSchoolPeople = (TextView) view.findViewById(R.id.school_people);
        mHomeSchoolTablayout = (TabLayout) view.findViewById(R.id.home_school_tablayout);
        mHomeSchoolTabVp = (ViewPager) view.findViewById(R.id.home_school_tab_vp);
        mSchoolRv = (RecyclerView) view.findViewById(R.id.school_rv);
        home_tab_recy = (XRecyclerView) view.findViewById(R.id.home_tab_recy);
//        mHomeScrollView = (RewriteScrollView) view.findViewById(R.id.home_scrollview);
        //设置底部tablayout

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
        return R.layout.home_tab;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < index; i++) {
            list.add("http://img02.store.sogou.com/app/a/10010016/5654ecf05c472d486d767d9ce5740fa7");
        }
        /**
         * 自营商铺
         */
        ShopAdapter shopAdapter = new ShopAdapter(list, getContext());
        mHomeTabShopRv.setAdapter(shopAdapter);
        mHomeTabShopRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mHomeTabShopRv.addItemDecoration(new SpaceItemDecoration(20,5));//item间距

        /**
         * 关注学校
         */
        SchoolAdapter schoolAdapter = new SchoolAdapter(list, getContext());
        mSchoolRv.setAdapter(schoolAdapter);
        mSchoolRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        /**
         * 以校园范围为主的二手物品
         */
        Home_Tab_Adapter home_tab_adapter = new Home_Tab_Adapter(getContext(), titles, fragments, getChildFragmentManager());
        if (home_tab_adapter != null){
            home_tab_recy.setAdapter(home_tab_adapter);
        }
//        home_tab_recy.setAdapter(home_tab_adapter);
//        home_tab_recy.setLayoutManager(new LinearLayoutManager(getContext()));
        home_tab_recy.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        home_tab_recy.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        /*con=1;//con不等于0就执行上啦加载
                        okhttp(i);//okhttp解析数据
                        RV_all.loadMoreComplete();    //加载数据完成（取消加载动画）*/
                        list.clear();
                        home_tab_recy.notify();
                        for (int i = 0; i < index; i++) {
                            list.add("http://img02.store.sogou.com/app/a/10010016/5654ecf05c472d486d767d9ce5740fa7");
                        }
                        home_tab_recy.refreshComplete();
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
                        home_tab_recy.loadMoreComplete();
                    }
                },2000);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.home_tab_trusteeship_area://托管专区点击事件
                Toast.makeText(getContext(), "前往托管专区", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
