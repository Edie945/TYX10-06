package com.erhuotu.rabbit.taoyouxian.view.fragment.post;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.erhuotu.rabbit.taoyouxian.R;
import com.erhuotu.two_2.mvp.BaseFragment;
import com.erhuotu.two_2.mvp.MVP.BaseModel;
import com.erhuotu.two_2.mvp.MVP.BasePresenter;

/**
 * Created by TWO-2
 * 2018/9/28
 */
public class PostBooks extends BaseFragment implements View.OnClickListener {
    private View view;
    private ImageView mPostBookImg;
    private LinearLayout mPostBooksBtn;

    @Override
    protected void initView(View view) {

        mPostBookImg = (ImageView) view.findViewById(R.id.post_book_img);
        mPostBooksBtn = (LinearLayout) view.findViewById(R.id.post_books_btn);
        mPostBooksBtn.setOnClickListener(this);
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
        return R.layout.post_books;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.post_books_btn:
                break;
        }
    }
}
