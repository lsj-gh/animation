package com.example.administrator.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.myapplication.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);

        initData();
    }

    private void initData() {
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        bt5 = (Button) findViewById(R.id.bt5);
        bt6 = (Button) findViewById(R.id.bt6);
        bt7 = (Button) findViewById(R.id.bt7);
        bt8 = (Button) findViewById(R.id.bt8);
        bt8.setVisibility(View.GONE);
        bt1.setOnClickListener(MainActivity.this);
        bt2.setOnClickListener(MainActivity.this);
        bt3.setOnClickListener(MainActivity.this);
        bt4.setOnClickListener(MainActivity.this);
        bt5.setOnClickListener(MainActivity.this);
        bt6.setOnClickListener(MainActivity.this);
        bt7.setOnClickListener(MainActivity.this);
        bt8.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt1:
                startActivity(MyClickActivity.class);
                break;
            case R.id.bt2:
                startActivity(MySwitchActivity.class);
                break;
            case R.id.bt3:
                startActivity(MySearchNotRoundActivity.class);
                break;
            case R.id.bt4:
                startActivity(MyPopActivity.class);
                break;
            case R.id.bt5:
                startActivity(MyDiaActivity.class);
                break;
            case R.id.bt6:
                startActivity(MyNewCallActivity.class);
                break;
            case R.id.bt7:
                startActivity(MyTopDiaActivity.class);
                break;
            case R.id.bt8:

                break;
        }
    }

    private void startActivity(Class activity) {
        startActivity(new Intent(MainActivity.this, activity));
    }

}
