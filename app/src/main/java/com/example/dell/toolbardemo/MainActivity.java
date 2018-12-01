package com.example.dell.toolbardemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dell.toolbardemo.activity.FirstTestActivity;
import com.example.dell.toolbardemo.activity.SearchViewActivity;
import com.example.dell.toolbardemo.activity.SecondTestActivity;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private Button btn_first_test;
    private Button btn_SearchView;
    private Button btn_SecondTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        initView();
        initListener();
    }

    private void initView() {
        btn_first_test = (Button) findViewById(R.id.btn_first_test);
        btn_SearchView = (Button) findViewById(R.id.btn_SearchView);
        btn_SecondTest = (Button) findViewById(R.id.btn_SecondTest);
    }

    private void initListener() {
        btn_first_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FirstTestActivity.class);
                startActivity(intent);

            }
        });
        btn_SearchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SearchViewActivity.class);
                startActivity(intent);
            }
        });
        btn_SecondTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SecondTestActivity.class);
                startActivity(intent);
            }
        });
    }
}
