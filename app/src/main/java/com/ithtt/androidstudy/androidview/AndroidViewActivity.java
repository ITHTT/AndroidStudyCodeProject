package com.ithtt.androidstudy.androidview;

import android.content.Intent;
import android.view.View;

import com.ithtt.androidstudy.AndroidCodeRecyclerViewActivity;
import com.ithtt.androidstudy.R;
import com.ithtt.androidstudy.app.BaseActivity;

import butterknife.OnClick;

public class AndroidViewActivity extends BaseActivity{

    @Override
    protected int getContentLayout() {
        return R.layout.activity_androidview;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void handleIntent(Intent intent) {

    }

    @OnClick({R.id.item_androidview,R.id.item_androidview_custom})
    public void onClickItem(View view){
        switch (view.getId()){
            case R.id.item_androidview:
                AndroidCodeRecyclerViewActivity.startAndroidCodeActivity(this,getResources().getStringArray(R.array.android_view));
                break;
            case R.id.item_androidview_custom:
                AndroidCodeRecyclerViewActivity.startAndroidCodeActivity(this,getResources().getStringArray(R.array.android_custom_view));
                break;
        }
    }
}
