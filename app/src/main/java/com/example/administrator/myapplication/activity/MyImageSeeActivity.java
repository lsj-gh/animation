package com.example.administrator.myapplication.activity;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.example.administrator.myapplication.R;

public class MyImageSeeActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView, bigImageView;
    ScaleAnimation scaleAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_image_see);
        imageView = (ImageView) findViewById(R.id.iv_show);
        bigImageView = (ImageView) findViewById(R.id.iv_big_show);


//        scaleAnimation = new ScaleAnimation(0.1f, 1f, 0.1f, 1f, Animation.RELATIVE_TO_SELF, Animation
//                .RELATIVE_TO_SELF);
        imageView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        imageView.setOnClickListener(this);
        bigImageView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {


        switch (view.getId()){
            case R.id.iv_show:
                showBigImage();
                break;
            case R.id.iv_big_show:
                dismissBigImage();
                break;

        }

    }
    private void showBigImage(){
        int[] location = new int[2];
        imageView.getLocationOnScreen(location);
        float x = location[0];
        float y = location[1];
        float i = getWindowManager().getDefaultDisplay().getWidth();
        float j = getWindowManager().getDefaultDisplay().getHeight();
        float f = (imageView.getWidth() / i);
        float l = (imageView.getHeight() / j);
        scaleAnimation = new ScaleAnimation(f, 1f, l, 1f, imageView.getLeft() + imageView.getWidth() / 2, imageView
                .getTop()+ imageView.getHeight() / 2);
        scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        scaleAnimation.setDuration(2000);
        bigImageView.setAnimation(scaleAnimation);
        bigImageView.setVisibility(View.VISIBLE);
        imageView.setVisibility(View.GONE);
    }
    private void dismissBigImage(){
        int[] location = new int[2];
        imageView.getLocationOnScreen(location);
        float x = location[0];
        float y = location[1];
        float i = getWindowManager().getDefaultDisplay().getWidth();
        float j = getWindowManager().getDefaultDisplay().getHeight();
        float f = (imageView.getWidth() / i);
        float l = (imageView.getHeight() / j);
        scaleAnimation = new ScaleAnimation(1f, f, 1f, l, imageView.getLeft() + imageView.getWidth() / 2, imageView
                .getTop()+ imageView.getHeight() / 2);
        scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        scaleAnimation.setDuration(2000);
        bigImageView.setAnimation(scaleAnimation);
        imageView.setVisibility(View.VISIBLE);
        bigImageView.setVisibility(View.GONE);
    }
}
