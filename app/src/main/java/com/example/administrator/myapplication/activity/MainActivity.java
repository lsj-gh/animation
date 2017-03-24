package com.example.administrator.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.RippleListAdapter;
import com.example.administrator.myapplication.view.RippleView;
import com.example.administrator.myapplication.view.SwitchView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bt1, bt2, bt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);

        initdata();
    }

    private void initdata() {
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt1.setOnClickListener(MainActivity.this);
        bt2.setOnClickListener(MainActivity.this);
        bt3.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt1:
                startActivity(ClickActivity.class);
                break;
            case R.id.bt2:
                startActivity(MySwitchActivity.class);
                break;
            case R.id.bt3:
                startActivity(RotateAndScaleActivity.class);
                break;
        }
    }

    private void startActivity(Class activity) {
        startActivity(new Intent(MainActivity.this, activity));
    }

}
