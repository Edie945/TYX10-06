package com.erhuotu.two_2.mvp;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.erhuotu.two_2.mvp.MVP.BaseModel;
import com.erhuotu.two_2.mvp.MVP.BasePresenter;
import com.erhuotu.two_2.mvp.MVP.IBaseView;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.yatoooon.screenadaptation.ScreenAdapterTools;


import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by TWO-2
 * 2018/9/17
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {
    public P presenter;
    private final String TAG = BaseActivity.class.getSimpleName();
    public Unbinder unbinder;
    private static boolean enableNightMode = false;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        //屏幕适配
        /*ScreenAdapterTools.init(this);
        ScreenAdapterTools.getInstance().reset(this);
        ScreenAdapterTools.getInstance().loadView((ViewGroup) getWindow().getDecorView());*/

        getSupportActionBar().hide();//继承AppCompatActivity 中这一句可以隐藏标题栏
        if (!enableNightMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        Logger.addLogAdapter(new AndroidLogAdapter());
        //绑定butterknife
        unbinder = ButterKnife.bind(this);
        initView();
        presenter = initPresenter();
        if (presenter != null) {
            presenter.attch(initModel(), this);
        }
//        NetWorkUtils.getCurrentNetworkState(this);
        initData();
    }

    /**
     * 获取布局
     *
     * @return
     */
    protected abstract int getLayoutID();

    /**
     * 初始化控件
     */
    public void initView() {

    }

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化Presenter
     *
     * @return
     */
    protected abstract P initPresenter();

    /**
     * 初始化Model
     *
     * @return
     */
    protected abstract BaseModel initModel();

    /**
     * 错误信息
     *
     * @param msg
     */
    @Override
    public void serverFail(String msg) {

    }

    /**
     * 设置隐藏标题栏
     *
     * @param activity
     */
    public static void setNoTitleBar(Activity activity) {
        activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    /**
     * 是否设置沉浸式状态栏
     *
     * @param flag
     */
    public void steepStatusBar(boolean flag) {
        if (flag) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                // 透明状态栏
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                // 透明导航栏
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            }
        }
    }

    /**
     * 显示toast
     *
     * @param msg
     */
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 无值传递跳转
     *
     * @param cls
     */
    public void startActivity(Class<? extends Activity> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    /**
     * 有值传递跳转
     *
     * @param cls
     */
    public void startActivity(Bundle bundle, Class<? extends Activity> cls) {
        Intent intent = new Intent(this, cls);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Logger.i("调用了--->onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.v("调用了--->onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logger.d("调用了--->onResume()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.v("调用了--->onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Logger.i("调用了--->onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.w("调用了--->onDestroy()");
        if (presenter != null) {
            presenter.detach();//解绑
            unbinder.unbind();//解绑
        }
    }
}
