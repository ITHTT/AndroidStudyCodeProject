package com.ithtt.androidstudy.androidview.customview.pageviewtransition;

import android.content.Intent;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.ithtt.androidstudy.R;
import com.ithtt.androidstudy.app.BaseActivity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ithtt on 16/9/26.
 */
public class PagerViewTransitionActivity extends BaseActivity{
    @BindView(R.id.viewpager)
    protected ViewPager viewPager;
    @BindView(R.id.indicator_tv)
    protected TextView tvIndicator;
    @BindView(R.id.position_view)
    protected View positionView;

    private List<Fragment> fragmentList=new ArrayList<>();
    private int[] imageRes={R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5};

    @Override
    protected int getContentLayout() {
        return R.layout.activity_androidview_pageviewtransition_main;
    }

    @Override
    protected void initView() {
        ActionBar actionBar= getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
        // 1. 沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            int statusBarHeight = getStatusBarHeight();
            ViewGroup.LayoutParams lp = positionView.getLayoutParams();
            lp.height = statusBarHeight;
            positionView.setLayoutParams(lp);
        }
        initViewPager();
    }

    @Override
    protected void handleIntent(Intent intent) {

    }

    private void initViewPager(){
        viewPager.setPageTransformer(false, new CustPagerTransformer(this));

        // 2. viewPager添加adapter
        for (int i = 0; i < 10; i++) {
            // 预先准备10个fragment
            fragmentList.add(new PagerViewFragment());
        }

        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                PagerViewFragment fragment = (PagerViewFragment) fragmentList.get(position % 10);
                fragment.setImgUrl(imageRes[position % imageRes.length]);
                return fragment;
            }

            @Override
            public int getCount() {
                return 666;
            }
        });

        // 3. viewPager滑动时，调整指示器
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                updateIndicatorTv();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 更新指示器
     */
    private void updateIndicatorTv() {
        int totalNum = viewPager.getAdapter().getCount();
        int currentItem = viewPager.getCurrentItem() + 1;
        tvIndicator.setText(Html.fromHtml("<font color='#12edf0'>" + currentItem + "</font>  /  " + totalNum));
    }

    private int getStatusBarHeight() {
        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0, statusBarHeight = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return statusBarHeight;
    }
}
