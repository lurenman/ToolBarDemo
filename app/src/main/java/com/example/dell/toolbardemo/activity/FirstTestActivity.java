package com.example.dell.toolbardemo.activity;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.dell.toolbardemo.R;

/**
 * 创建日期：2018/11/29
 * 作者:baiyang
 * 参考文章
 * https://blog.csdn.net/listeners_gao/article/details/52736008
 */
public class FirstTestActivity extends BaseActivity implements Toolbar.OnMenuItemClickListener {
    private Toolbar mToolbar;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_fist_test);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    @Override
    protected void initVariables() {
        mToolbar.setTitle("");
        //去掉原先左边的title
        // mToolbar.setTitle("Title");//设置Title
        //mToolbar.setTitleTextColor();
        // mToolbar.setSubtitle("subTitle"); //设置subTitle

        //logo 在title的左边
        //mToolbar.setLogo(R.drawable.back);
        //设置toolbar
        setSupportActionBar(mToolbar);
        //左边的小箭头（注意需要在setSupportActionBar(toolbar)之后才有效果）
        mToolbar.setNavigationIcon(R.drawable.back);
    }

    @Override
    protected void initListenter() {
        mToolbar.setOnMenuItemClickListener(this);
        //左边回退按钮监听
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirstTestActivity.this.finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //这个就是创建最右边的点进选择菜单项
        //对于弹出的菜单样式style中有设置
        getMenuInflater().inflate(R.menu.menu_fist_test, menu);
        return true;

    }


    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.action_edit:
                Toast.makeText(mContext, "menuItem被点击", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_share:
                Toast.makeText(mContext, "menuItem被点击", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
