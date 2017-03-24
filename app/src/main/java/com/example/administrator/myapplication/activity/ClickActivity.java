package com.example.administrator.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.RippleListAdapter;
import com.example.administrator.myapplication.view.RippleView;

public class ClickActivity extends AppCompatActivity {
    private RippleView rv1, rv2;
    private ListView listView;
    private RippleListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);
        listView = (ListView) findViewById(R.id.listview);
        listAdapter = new RippleListAdapter(this);
        listView.setAdapter(listAdapter);
        rv1 = (RippleView) findViewById(R.id.rv1);
        rv2 = (RippleView) findViewById(R.id.rv2);
        rv1.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                Toast.makeText(ClickActivity.this, "这是圆形外部展开", Toast.LENGTH_SHORT).show();
            }
        });
        rv2.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                Toast.makeText(ClickActivity.this, "这是内部展开", Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ClickActivity.this, "这是Listview第" + i + "个item", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
