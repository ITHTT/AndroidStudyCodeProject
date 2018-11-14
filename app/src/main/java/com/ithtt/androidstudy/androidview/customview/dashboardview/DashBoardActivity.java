package com.ithtt.androidstudy.androidview.customview.dashboardview;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.ithtt.androidstudy.R;
import com.ithtt.androidstudy.app.BaseActivity;

import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ithtt on 16/9/21.
 */
public class DashBoardActivity extends BaseActivity{
    @BindView(R.id.layout_content)
    protected LinearLayout layoutContent;
    @BindView(R.id.dashboardview)
    protected DashBoardView dashBoardView;

    private final int[] mColors = new int[]{
            0xFFFF80AB,
            0xFFFF4081,
            0xFFFF5177,
            0xFFFF7997
    };

    @Override
    protected int getContentLayout() {
        return R.layout.activity_androidview_dashboardview;
    }

    @Override
    protected void initView() {
        startColorChangeAnim();

    }

    @Override
    protected void handleIntent(Intent intent) {

    }

    @OnClick(R.id.bt_start)
    protected void onClickStartButton(View view){
        Random random=new Random();
        dashBoardView.setSesameValues(random.nextInt(950));
        startColorChangeAnim();
    }

    public void startColorChangeAnim()
    {

        ObjectAnimator animator = ObjectAnimator.ofInt(layoutContent, "backgroundColor", mColors);
        animator.setDuration(3000);
        animator.setEvaluator(new ArgbEvaluator());
        animator.start();
    }
}
