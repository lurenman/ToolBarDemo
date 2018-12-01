package com.example.dell.toolbardemo.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * 创建日期：2018/11/29
 * 作者:baiyang
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        initViews();
        initVariables();
        initListenter();
        loadData();
    }

    protected abstract void initViews();

    protected abstract void initVariables();

    protected abstract void initListenter();

    protected void loadData() {
    }

}
