package com.example.administrator.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.myapplication.R;


public class MyDiaActivity extends AppCompatActivity implements View.OnClickListener {
    private Button huifu;
    private TextView cancel, done;
    private RelativeLayout rv_dia, rv_progress;
    private Animation in, out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dia);
        initData();
    }

    private void initData() {
        huifu = (Button) findViewById(R.id.bt_huifu);
        cancel = (TextView) findViewById(R.id.cancel);
        done = (TextView) findViewById(R.id.done);
        rv_dia = (RelativeLayout) findViewById(R.id.rv_dia);
        rv_progress = (RelativeLayout) findViewById(R.id.rv_progress);

        huifu.setOnClickListener(MyDiaActivity.this);
        cancel.setOnClickListener(MyDiaActivity.this);
        done.setOnClickListener(MyDiaActivity.this);
        in = AnimationUtils.loadAnimation(this, R.anim.dialog_center_in);
        out = AnimationUtils.loadAnimation(this, R.anim.dialog_center_out);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_huifu:
                rv_dia.startAnimation(in);
                rv_dia.setVisibility(View.VISIBLE);
                break;
            case R.id.cancel:
                rv_dia.startAnimation(out);
                rv_dia.setVisibility(View.GONE);
                break;
            case R.id.done:
                rv_dia.startAnimation(out);
                rv_dia.setVisibility(View.GONE);
                rv_progress.setVisibility(View.VISIBLE);
                break;
        }
    }
}
