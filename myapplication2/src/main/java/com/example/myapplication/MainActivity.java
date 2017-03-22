package com.example.myapplication;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int type;
    RadioGroup rg;
    int liangdu, duibidu, ruilidu, sedu, huidu, sedu_v;
    TextView tv_ld, tv_dbd, tv_rld, tv_sdu, tv_sdv, tv_hd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = (RadioGroup) findViewById(R.id.rg);
        tv_ld = (TextView) findViewById(R.id.tv_ld);
        tv_dbd = (TextView) findViewById(R.id.tv_dbd);
        tv_rld = (TextView) findViewById(R.id.tv_rld);
        tv_sdu = (TextView) findViewById(R.id.tv_sdu);
        tv_sdv = (TextView) findViewById(R.id.tv_sdv);
        tv_hd = (TextView) findViewById(R.id.tv_hd);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rb1:
                        type = 1;
                        break;
                    case R.id.rb2:
                        type = 2;
                        break;
                    case R.id.rb3:
                        type = 3;
                        break;
                    case R.id.rb4:
                        type = 4;
                        break;
                    case R.id.rb5:
                        type = 5;
                        break;

                }
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_0) {
            switch (type) {
                case 1:
                    if (-128 < liangdu && liangdu < 127) {
                        liangdu++;
                        Log.d("MainActivity", "亮度" + liangdu);
                        tv_ld.setText("亮度" + liangdu);
                    }
                    break;
                case 2:
                    if (0 < duibidu && duibidu < 255) {
                        duibidu++;
                        Log.d("MainActivity", "对比度" + duibidu);
                        tv_dbd.setText("对比度" + duibidu);
                    }
                    break;
                case 3:
                    if (1 < ruilidu && ruilidu < 15) {
                        ruilidu++;
                        Log.d("MainActivity", "锐利度" + ruilidu);
                        tv_rld.setText("锐利度" + ruilidu);
                    }
                    break;
                case 4:
                    if (0 < sedu_v && sedu_v < 200) {
                        sedu_v++;
                        Log.d("MainActivity", "色度v" + sedu_v);
                        tv_sdv.setText("色度v" + sedu);
                    }
                    break;
                case 5:
                    if (0 < huidu && huidu < 255) {
                        huidu++;
                        Log.d("MainActivity", "灰度" + huidu);
                        tv_sdu.setText("灰度" + huidu);
                    }
                case 6:
                    if (0 < sedu && sedu < 255) {
                        sedu++;
                        Log.d("MainActivity", "色度u" + sedu);
                        tv_ld.setText("色度u" + liangdu);
                    }
                    break;

            }

        } else if (keyCode == KeyEvent.KEYCODE_1) {
            switch (type) {
                case 1:
                    if (-128 < liangdu && liangdu < 127) {
                        liangdu--;
                        Log.d("MainActivity", "亮度" + liangdu);
                        tv_ld.setText("亮度" + liangdu);
                    }
                    break;
                case 2:
                    if (0 < duibidu && duibidu < 255) {
                        duibidu--;
                        Log.d("MainActivity", "对比度" + duibidu);
                        tv_dbd.setText("对比度" + duibidu);
                    }
                    break;
                case 3:
                    if (1 < ruilidu && ruilidu < 15) {
                        ruilidu--;
                        Log.d("MainActivity", "锐利度" + ruilidu);
                        tv_rld.setText("锐利度" + ruilidu);
                    }
                    break;
                case 4:
                    if (0 < sedu_v && sedu_v < 200) {
                        sedu_v--;
                        Log.d("MainActivity", "色度v" + sedu_v);
                        tv_sdv.setText("色度v" + sedu);
                    }
                    break;
                case 5:
                    if (0 < huidu && huidu < 255) {
                        huidu--;
                        Log.d("MainActivity", "灰度" + huidu);
                        tv_sdu.setText("灰度" + huidu);
                    }
                case 6:
                    if (0 < sedu && sedu < 255) {
                        sedu--;
                        Log.d("MainActivity", "色度u" + sedu);
                        tv_ld.setText("色度u" + liangdu);
                    }
                    break;

            }
        }
        return super.onKeyDown(keyCode, event);
    }

}
