package com.erhuotu.two_2.mvp.MVP;

/**
 * Created by TWO-2
 * 2018/9/17
 */
public class BasePresenter<M extends BaseModel, V extends IBaseView> implements IBasePresenter {
    public M model;
    public V view;

    /**
     * 绑定M和V
     *
     * @param m
     * @param v
     */
    public void attch(M m, V v) {
        this.model = m;
        this.view = v;
    }

    /**
     * 回收资源，解绑，避免内存泄漏
     */
    public void detach() {
        this.model = null;
        this.view = null;
    }
}

