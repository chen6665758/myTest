package com.example.cg.listadaptertest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;

import com.example.cg.listadaptertest.Adapter.listAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_add;
    private Button btn_push;
    private ListView lv;
    private List<String> list_data;
    private listAdapter lAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("测试Adapter刷新时的应用");
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initControls();

        initData(0);
    }

    /**
     * 初始化控件
     */
    private void initControls() {
        btn_add = (Button)findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);

        btn_push = (Button)findViewById(R.id.btn_push);
        btn_push.setOnClickListener(this);

        lv = (ListView)findViewById(R.id.lv);

        list_data = new ArrayList<>();
        lAdapter = new listAdapter(list_data,this);
        lv.setAdapter(lAdapter);
    }

    /**
     * 加载数据
     * @param flag   0:刷新加载５个数据　　1:加载更多
     */
    private void initData(int flag)
    {
        if(flag==0)
        {
            list_data.removeAll(list_data);
            for(int i=0;i<5;i++)
            {
                list_data.add("数据记录" + (i+1));
            }
        }else
        {
            int num = list_data.size();
            for(int i=0;i<5;i++)
            {
                list_data.add("数据记录" + (num + i + 1));
            }
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_add:
                initData(1);
                Log.e("MainActivity", "添加进来了吗" + list_data.size());
                //lAdapter = new listAdapter(list_data,this);
                lAdapter.notifyDataSetChanged();
                break;
            case R.id.btn_push:
                initData(0);
                Log.e("MainActivity","刷新进来了吗" + list_data.size());
                //lAdapter = new listAdapter(list_data,this);
                lAdapter.notifyDataSetChanged();
                break;
        }
    }
}
