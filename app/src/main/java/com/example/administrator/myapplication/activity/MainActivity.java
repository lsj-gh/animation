package com.example.administrator.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.RippleListAdapter;
import com.example.administrator.myapplication.view.RippleView;
import com.example.administrator.myapplication.view.SwitchView;

public class MainActivity extends AppCompatActivity {
    private RippleView rippleView, rippleViews;
    private ListView listView;
    private RippleListAdapter listAdapter;
    SwitchView sv_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        listAdapter = new RippleListAdapter(this);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "这是第" + i + "个item", Toast.LENGTH_SHORT).show();
            }
        });
        rippleView = (RippleView) findViewById(R.id.rv1);
        rippleViews = (RippleView) findViewById(R.id.rv2);

        rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                Log.i("TAG", "点击了");

            }
        });
        rippleViews.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                startActivity(new Intent(MainActivity.this, TwoActivity.class));
                Log.w("hahaha", 222222 + "");
            }
        });

        sv_button = (SwitchView) findViewById(R.id.sv_button);
        sv_button.setOnStateChangedListener(new SwitchView.OnStateChangedListener() {
            @Override
            public void toggleToOn(SwitchView view) {
                sv_button.toggleSwitch(true);//更新按钮状态
                Log.e("setOnStateChan","按钮打开了");
            }
            @Override
            public void toggleToOff(SwitchView view) {
                sv_button.toggleSwitch(false);//更新按钮状态
                Log.e("setOnStateChan","按钮关闭了");
            }
        });
    }

}
