package com.example.administrator.myapplication.activity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.administrator.myapplication.R;

public class MyTopDiaActivity extends AppCompatActivity implements View.OnClickListener {
    private View topView, bottomView;
    private Button start, gone;
    //    Animation topIn, topOut, bottomIn, bottomOut;
//    Animator topIn, topOut, bottomIn, bottomOut;
    ObjectAnimator topIn, topOut, bottomIn, bottomOut;
    private RelativeLayout RL_top;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_top_dia);
        initData();
    }

    private void initData() {
        start = (Button) findViewById(R.id.start);
        gone = (Button) findViewById(R.id.bt_gone);
        RL_top = (RelativeLayout) findViewById(R.id.RL_top);
        topView = findViewById(R.id.v_top);
        bottomView = findViewById(R.id.v_bottom);
        start.setOnClickListener(this);
        gone.setOnClickListener(this);
//需要根据实际屏幕来定位
        topIn = ObjectAnimator.ofFloat(RL_top, "translationY", -600, 0);
        bottomIn = ObjectAnimator.ofFloat(bottomView, "translationY", 1800, 0);
        topOut = ObjectAnimator.ofFloat(RL_top, "translationY", 0, -600);
        bottomOut = ObjectAnimator.ofFloat(bottomView, "translationY", 0, 1800);
    }

    private void aniStart(ObjectAnimator animator) {
        animator.setDuration(2000);
        animator.start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start:
                aniStart(topIn);
                aniStart(bottomIn);
                RL_top.setVisibility(View.VISIBLE);
                bottomView.setVisibility(View.VISIBLE);
                break;
            case R.id.bt_gone:
                aniStart(topOut);
                aniStart(bottomOut);
//                RL_top.setVisibility(View.GONE);
//                bottomView.setVisibility(View.GONE);
                break;
        }
    }
}
