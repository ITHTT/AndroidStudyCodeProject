package com.ithtt.androidstudy.androidview.customview.marqueeview;

import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ViewFlipper;

import com.ithtt.androidstudy.R;
import com.ithtt.androidstudy.app.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MarqueeViewActivity extends BaseActivity{
    @BindView(R.id.filpper)
    ViewFlipper viewFlipper;

    @Override
    protected int getContentLayout() {
        return R.layout.activity_marquee_view;
    }

    @Override
    protected void initView() {
        addView();
    }

    @Override
    protected void handleIntent(Intent intent) {

    }

    private void addView(){
        for(int i=0;i<5;i++){
            View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.layout_marquee_text, null);
            AutoScrollTextView autoScrollTextView=view.findViewById(R.id.scroll_text_view);
            autoScrollTextView.setText("使用android ViewFlipper及自定义TextView进行屏幕切换用于测试公告内容"+(i+1));
            autoScrollTextView.init(getApplicationContext());
            viewFlipper.addView(view);
        }
        View currentView=viewFlipper.getCurrentView();
        AutoScrollTextView autoScrollTextView=currentView.findViewById(R.id.scroll_text_view);
        autoScrollTextView.startScroll();
    }

    @OnClick({R.id.iv_arrow_left,R.id.iv_arrow_right})
    public void onClickArrow(View view){
        View currentView=viewFlipper.getCurrentView();
        AutoScrollTextView autoScrollTextView=currentView.findViewById(R.id.scroll_text_view);
        autoScrollTextView.stopScroll();
        if(view.getId()==R.id.iv_arrow_left){
            //viewFlipper.showPrevious();
            previous();
        }else if(view.getId()==R.id.iv_arrow_right){
            //viewFlipper.showNext();
            next();
        }
        currentView=viewFlipper.getCurrentView();
        autoScrollTextView=currentView.findViewById(R.id.scroll_text_view);
        autoScrollTextView.init(getApplicationContext());
        autoScrollTextView.startScroll();
    }

    private void next() {
//        viewFlipper.setInAnimation(this, R.anim.in_righttoleft);
//        viewFlipper.setOutAnimation(this, R.anim.out_righttoleft);

        viewFlipper.setInAnimation(this, R.anim.in_lefttoright);
        viewFlipper.setOutAnimation(this, R.anim.out_lefttoright);
        viewFlipper.showNext();
    }
    private void previous() {
//        viewFlipper.setInAnimation(this, R.anim.in_lefttoright);
//        viewFlipper.setOutAnimation(this, R.anim.out_lefttoright);

        viewFlipper.setInAnimation(this, R.anim.in_righttoleft);
        viewFlipper.setOutAnimation(this, R.anim.out_righttoleft);
        viewFlipper.showPrevious();
    }
}
