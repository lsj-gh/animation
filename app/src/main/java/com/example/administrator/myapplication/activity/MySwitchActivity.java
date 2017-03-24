package com.example.administrator.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.view.SwitchView;

public class MySwitchActivity extends AppCompatActivity {
    private SwitchView sv_button,sv_button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_switch);
        sv_button = (SwitchView) findViewById(R.id.sv_button);

        sv_button.setOnStateChangedListener(new SwitchView.OnStateChangedListener() {
            @Override
            public void toggleToOn(SwitchView view) {
                sv_button.toggleSwitch(true);//更新按钮状态
                Toast.makeText(MySwitchActivity.this, "开启", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void toggleToOff(SwitchView view) {
                sv_button.toggleSwitch(false);//更新按钮状态
                Toast.makeText(MySwitchActivity.this, "关闭", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
