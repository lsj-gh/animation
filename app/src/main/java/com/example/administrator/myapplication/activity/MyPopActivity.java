package com.example.administrator.myapplication.activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import android.widget.ImageView;
import android.widget.LinearLayout;


import com.example.administrator.myapplication.R;

public class MyPopActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView ivBt1, ivBt2;

    LinearLayout include;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pop_fram);
        initData();
    }

    private void initData() {
        ivBt1 = (ImageView) findViewById(R.id.iv_back);
        ivBt2 = (ImageView) findViewById(R.id.iv_option);

        ivBt1.setOnClickListener(this);
        ivBt2.setOnClickListener(this);

        include = (LinearLayout) findViewById(R.id.include);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                popDismiss();
                break;
            case R.id.iv_option:
                popShow();
                break;
        }
    }

    private void popShow() {
        if(include.getVisibility() == View.GONE){
            Animation in = AnimationUtils.loadAnimation(this, R.anim.pop_left_in);
            include.startAnimation(in);
            include.setVisibility(View.VISIBLE);
        }
    }

    private void popDismiss() {
        if (include.getVisibility() == View.VISIBLE){
            Animation out = AnimationUtils.loadAnimation(this, R.anim.pop_left_out);
            include.startAnimation(out);
            include.setVisibility(View.GONE);
        }
    }
}
