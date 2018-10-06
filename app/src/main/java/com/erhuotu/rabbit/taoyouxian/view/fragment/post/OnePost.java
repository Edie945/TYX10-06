package com.erhuotu.rabbit.taoyouxian.view.fragment.post;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.erhuotu.rabbit.taoyouxian.R;
import com.erhuotu.rabbit.taoyouxian.view.adapter.Post.Post_Images_Adapter;
import com.erhuotu.two_2.mvp.BaseFragment;
import com.erhuotu.two_2.mvp.MVP.BaseModel;
import com.erhuotu.two_2.mvp.MVP.BasePresenter;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

/**
 * Created by TWO-2
 * 2018/9/26
 */
public class OnePost extends BaseFragment implements View.OnClickListener {
    private static final String TAG = "OnePost";
    private View view;
    /**
     * 宝贝描述：价格、新旧度、转手原因、入手渠道……
     */
    private EditText mOnepostContentText;
    private RecyclerView mPostContentImgsRv;
    private ImageView mAddImgs;
    /**
     * 服饰美妆
     */
    private RadioButton mRdFsmz;
    /**
     * 寝室用品
     */
    private RadioButton mRdQsyp;
    /**
     * 图书文具
     */
    private RadioButton mRdTswj;
    /**
     * 数码电子
     */
    private RadioButton mRdSmdz;
    private LinearLayout mQita;
    private LinearLayout mLocation;
    private LinearLayout mWhocansee;
    private LinearLayout mRemindingwhotosee;
    private Post_Images_Adapter post_images_adapter;
    private static final int REQUEST_CODE_CHOOSE = 23;
    private ImageView imageView;
    private List<Uri> result;

    @Override
    protected void initView(View view) {

        mOnepostContentText = (EditText) view.findViewById(R.id.onepost_content_text);
//        mPostContentImgsRv = (RecyclerView) view.findViewById(R.id.post_content_imgs_rv);
        mAddImgs = (ImageView) view.findViewById(R.id.add_imgs);
        mRdFsmz = (RadioButton) view.findViewById(R.id.rd_fsmz);
        mRdQsyp = (RadioButton) view.findViewById(R.id.rd_qsyp);
        mRdTswj = (RadioButton) view.findViewById(R.id.rd_tswj);
        mRdSmdz = (RadioButton) view.findViewById(R.id.rd_smdz);
        mQita = (LinearLayout) view.findViewById(R.id.qita);
        mLocation = (LinearLayout) view.findViewById(R.id.location);
        mWhocansee = (LinearLayout) view.findViewById(R.id.whocansee);
        mRemindingwhotosee = (LinearLayout) view.findViewById(R.id.remindingwhotosee);
//        mPostContentImgsRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mAddImgs.setOnClickListener(this);

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
        return R.layout.onepost;
    }

    @Override
    protected void initData() {
//        if (result!=null){
//            mPostContentImgsRv.setVisibility(View.VISIBLE);
            post_images_adapter = new Post_Images_Adapter(result,getContext());
//            mPostContentImgsRv.setAdapter(post_images_adapter);
//        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.add_imgs:
                Matisse.from(getActivity())
                        .choose(MimeType.allOf())//图片类型
                        .countable(true)//true:选中后显示数字;false:选中后显示对号
                        .maxSelectable(9)//可选的最大数
                        .capture(true)//选择照片时，是否显示拍照
                        .captureStrategy(new CaptureStrategy(true, "com.erhuotu.rabbit.taoyouxian"))//参数1 true表示拍照存储在共有目录，false表示存储在私有目录；参数2与 AndroidManifest中authorities值相同，用于适配7.0系统 必须设置
                        .imageEngine(new GlideEngine())//图片加载引擎
                        .forResult(REQUEST_CODE_CHOOSE);
               /* Matisse.from(this)
                        .choose(MimeType.allOf())
                        .countable(true)
                        .maxSelectable(9)
//                        .addFilter(new GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
//                        .gridExpectedSize(getResources().getDimensionPixelSize(R.dimen.grid_expected_size))
                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                        .thumbnailScale(0.85f)
                        .imageEngine(new GlideEngine())
                        .forResult(REQUEST_CODE_CHOOSE);*/

                initPermission();
                break;
        }
    }

    private void initPermission() {
        if (ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(android.Manifest.permission.WRITE_EXTERNAL_STORAGE,android.Manifest.permission.READ_EXTERNAL_STORAGE);
        }
    }

    public void requestPermissions(String... permissions) {
        if (Build.VERSION.SDK_INT >= 23) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < permissions.length; i++) {
                if (ContextCompat.checkSelfPermission(getContext(), permissions[i]) != PackageManager.PERMISSION_GRANTED) {
                    list.add(permissions[i]);
                    if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), permissions[i])) {
                        Toast.makeText(getContext(), "没有开启权限将会导致部分功能不可使用", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            ActivityCompat.requestPermissions(getActivity(), list.toArray(new String[permissions.length]), 0);
        }
    }
   /* @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {//回调方法
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {
            //回调数据集合
            result = Matisse.obtainResult(data);
            Log.e(TAG, "onActivityResult: "+ result.toString() );

                       post_images_adapter.setData(result);
            for (int i = 0; i < result.size(); i++) {

                ImageView imageView = new ImageView(getContext());
                imageView.setPadding(5, 10, 5, 0);
                Glide.with(getContext()).load(result.get(i)).into(imageView);
                mPostImgsFlowLayout.addView(imageView);
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                layoutParams.width = DisplayMetricsUtil.getScreenWidth(getContext());//设置宽度
                layoutParams.height = DisplayMetricsUtil.getScreenWidth(getContext());//设置高度
                imageView.setLayoutParams(layoutParams);
            }
            //            for (int i = 0; i < result.size(); i++) {
//                ViewGroup viewGroup = new ViewGroup(getContext());
//                viewGroup.addView(imageView);
//                Log.e(TAG, "onActivityResult: "+result.get(i) );
//                imageView = new ImageView(getContext());
//                Log.d("-------------------",""+result.get(i));
//                imageView.setImageBitmap(result.get(i).toString());
//                Glide.with(this).load(result.get(i).toString()).into(imageView);
//            }
        }
    }*/
   @Override
   public void onActivityResult(int requestCode, int resultCode, Intent data) {
       super.onActivityResult(requestCode, resultCode, data);
       if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {
           result = Matisse.obtainResult(data);
           int i=result!=null?0:result.size();
           result = Matisse.obtainResult(data);
           Log.e(TAG, "onActivityResult: "+ result.toString() );
           if(result.size()>i){
               post_images_adapter.setData(result);
           }
           /*for (int i = 0; i < result.size(); i++) {

               ImageView imageView = new ImageView(getContext());
               imageView.setPadding(5, 10, 5, 0);
               Glide.with(getContext()).load(result.get(i)).into(imageView);
               mPostImgsFlowLayout.addView(imageView);
               ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
               layoutParams.width = DisplayMetricsUtil.getScreenWidth(getContext());//设置宽度
               layoutParams.height = DisplayMetricsUtil.getScreenWidth(getContext());//设置高度
               imageView.setLayoutParams(layoutParams);
           }*/
//           Glide.with(this).load(result.get(0).toString()).into(imageView);
           Log.e(TAG, "onActivityResult: "+result.toString() );
           //回调数据集合
            /*int i=result!=null?0:result.size();
            result = Matisse.obtainResult(data);
            Log.e(TAG, "onActivityResult: "+ result.toString() );
            if(result.size()>i){
                post_images_adapter.setData(result);
            }*/
//            for (int i = 0; i < result.size(); i++) {
//                ViewGroup viewGroup = new ViewGroup(getContext());
//                viewGroup.addView(imageView);
//                Log.e(TAG, "onActivityResult: "+result.get(i) );
//                imageView = new ImageView(getContext());
//                Log.d("-------------------",""+result.get(i));
//                imageView.setImageBitmap(result.get(i).toString());
//                Glide.with(this).load(result.get(i).toString()).into(imageView);
//            }
       }
   }
}
