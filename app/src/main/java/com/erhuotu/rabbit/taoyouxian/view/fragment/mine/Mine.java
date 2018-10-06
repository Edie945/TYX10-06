package com.erhuotu.rabbit.taoyouxian.view.fragment.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.erhuotu.rabbit.taoyouxian.R;
import com.erhuotu.rabbit.taoyouxian.view.adapter.Mine.MineListAdapter;
import com.erhuotu.two_2.mvp.BaseFragment;
import com.erhuotu.two_2.mvp.MVP.BaseModel;
import com.erhuotu.two_2.mvp.MVP.BasePresenter;

import java.util.ArrayList;

/**
 * Created by TWO-2
 * 2018/9/25
 */
public class Mine extends BaseFragment implements View.OnClickListener {
    private View view;
    private ImageView mMineUserImg;
    /**
     * 筱帝
     */
    private TextView mMineUserName;
    private LinearLayout mMineUserLl;
    /**
     * 国庆啊国庆啊加班啊加班啊
     */
    private TextView mSignatureTv;
    private ListView mMineLv;
    private ArrayList<String> list = new ArrayList<>();

    @Override
    protected void initView(View view) {

        mMineUserImg = (ImageView) view.findViewById(R.id.mine_user_img);
        mMineUserName = (TextView) view.findViewById(R.id.mine_user_name);
        mMineUserLl = (LinearLayout) view.findViewById(R.id.mine_user_ll);
        mMineUserLl.setOnClickListener(this);
        mSignatureTv = (TextView) view.findViewById(R.id.signature_tv);
        mMineLv = (ListView) view.findViewById(R.id.mine_lv);
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
        return R.layout.mine;
    }

    @Override
    protected void initData() {
        list.add("我发布的");
        list.add("我的订单");
        list.add("我的托管");
        list.add("我的钱包");
        list.add("我的客服");
        list.add("设置");
        MineListAdapter mineListAdapter = new MineListAdapter(list, getContext());
        mMineLv.setAdapter(mineListAdapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.mine_user_ll:
                break;
        }
    }
}
