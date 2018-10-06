package com.erhuotu.two_2.utilslibrary.Utils;

import android.content.Context;
import android.text.TextUtils;

import com.erhuotu.two_2.utilslibrary.Utils.api.BaseURL;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by TWO-2
 * 2018/9/18
 */
public class RetrofitUtils {
    private static RetrofitUtils retrofitUtil;
    private Context context;
    private final Retrofit mRetrofit;

    public RetrofitUtils(Context context) {
        this.context = context;
        OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5000, TimeUnit.SECONDS)
                .readTimeout(5000, TimeUnit.SECONDS)
                .writeTimeout(5000, TimeUnit.SECONDS)
                //添加日志拦截器
//                .addInterceptor(new MyInterceptor(context))
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BaseURL.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())//添加gson转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加rxjava转换器
                .client(mOkHttpClient)
                .build();
    }

    public static RetrofitUtils getInstence(Context context) {
        if (retrofitUtil == null) {
            synchronized (RetrofitUtils.class) {
                if (retrofitUtil == null)
                    retrofitUtil = new RetrofitUtils(context);
            }

        }
        return retrofitUtil;
    }

    /**
     * 创建API
     */
    public <T> T create(Class<T> clazz) {
        return mRetrofit.create(clazz);
    }

    /**
     * 2. 执行的方法
     */
    public static <T> void execute(Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * 自定义拦截器.使用的是okhttp来定义的拦截器
     */
   /* public static class MyInterceptor implements Interceptor {
        private Context context;

        public MyInterceptor(Context context) {
            this.context = context;
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            String uid = SharedPreferencesUtils.getPreference(context, "user").getString("userId");
            String sessionId = SharedPreferencesUtils.getPreference(context, "user").getString("sessionId");
            Request.Builder requestNew = request
                    .newBuilder();
            if (!TextUtils.isEmpty(uid)) {
                requestNew.addHeader("userId", uid);
            } else {
                requestNew.addHeader("userId", "");
            }
            if (!TextUtils.isEmpty(sessionId)) {
                requestNew.addHeader("sessionId", sessionId);
            } else {
                requestNew.addHeader("sessionId", "");
            }
            requestNew.addHeader("ak", "0110010010000");
            return chain.proceed(requestNew.build());
        }
    }*/
}

