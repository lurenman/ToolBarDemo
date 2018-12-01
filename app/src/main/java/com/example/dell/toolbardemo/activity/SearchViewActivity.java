package com.example.dell.toolbardemo.activity;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.dell.toolbardemo.R;

/**
 * 创建日期：2018/11/29
 * 作者:baiyang
 */
public class SearchViewActivity extends BaseActivity implements MenuItemCompat.OnActionExpandListener {

    private Toolbar toolbar;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_searchview);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    @Override
    protected void initVariables() {
        toolbar.setTitle("SearchView");
        //设置字体样式 也可以 xml中设置
        toolbar.setTitleTextAppearance(this,R.style.ToolbarTitleSize);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
// Enable the Up button     显示返回箭头的按钮
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void initListenter() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchViewActivity.this.finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search_view, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        //得到SearchView对象
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        //设置SearchView视图打开关闭的监听事件
        MenuItemCompat.setOnActionExpandListener(searchItem, this);

        return super.onCreateOptionsMenu(menu);
    }

    /**
     * 这个true是控制是否打开的
     * @param menuItem
     * @return
     */
    @Override
    public boolean onMenuItemActionExpand(MenuItem menuItem) {
        Toast.makeText(mContext, "onMenuItemActionExpand方法执行了...", Toast.LENGTH_SHORT).show();
        return true;    // 返回true 打开搜索扩展视图


    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem menuItem) {
        Toast.makeText(mContext, "onMenuItemActionCollapse方法执行了...", Toast.LENGTH_SHORT).show();
        return true;    // 返回true 关闭搜索扩展视图

    }
}
