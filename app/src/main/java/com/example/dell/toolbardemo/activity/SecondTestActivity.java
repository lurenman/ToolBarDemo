package com.example.dell.toolbardemo.activity;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.toolbardemo.R;

import java.lang.reflect.Field;

/**
 * 创建日期：2018/11/30
 * 作者:baiyang
 * https://www.tuicool.com/articles/7BJBZb
 * https://blog.csdn.net/a553181867/article/details/51336899
 */
public class SecondTestActivity extends BaseActivity {
    private Toolbar mToolbar;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_second);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    @Override
    protected void initVariables() {
        mToolbar.setTitle("SecondTest");
        //设置字体样式 也可以 xml中设置
        setSupportActionBar(mToolbar);
        //以下三行是修改回退按钮为白色的逻辑
        Drawable upArrow = ContextCompat.getDrawable(this, R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.color_white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void initListenter() {
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondTestActivity.this.finish();
            }
        });
        TextView titleTextView = getTitleTextView();
        titleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Title被点击了", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_second_test, menu);
        //我们可以得到menu做想要的操作
        MenuItem item = menu.findItem(R.id.action_share);
        item.setTitle("haha");
//        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                return false;
//            }
//        });
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * 获取TitleTextView
     *
     * @return
     */
    protected TextView getTitleTextView() {
        try {
            Field field = Toolbar.class.getDeclaredField("mTitleTextView");
            field.setAccessible(true);
            return (TextView) field.get(mToolbar);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}

/*
        colorPrimaryDark
        状态栏背景色。

        在 style 的属性中设置。

        textColorPrimary

        App bar 上的标题与更多菜单中的文字颜色。

        在 style 的属性中设置。

        App bar 的背景色

        Actionbar 的背景色设定在 style 中的 colorPrimary。

        Toolbar 的背景色在layout文件中设置background属性。

        colorAccent

        各控制元件(如：check box、switch 或是 radoi) 被勾选 (checked) 或是选定 (selected) 的颜色。

        在 style 的属性中设置。

        colorControlNormal

        各控制元件的预设颜色。

        在 style 的属性中设置

        windowBackground

        App 的背景色。

        在 style 的属性中设置

        navigationBarColor

        导航栏的背景色，但只能用在 API Level 21 (Android 5) 以上的版本

        在 style 的属性中设置*/
