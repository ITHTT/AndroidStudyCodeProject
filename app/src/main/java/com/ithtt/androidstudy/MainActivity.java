package com.ithtt.androidstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.Utils;
import com.ithtt.androidstudy.androidview.AndroidViewActivity;
import com.ithtt.androidstudy.app.BaseActivity;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        Utils.init(this.getApplicationContext());
    }

    @Override
    protected void handleIntent(Intent intent) {

    }

    @OnClick(R.id.item_androidview)
    protected void onClickAndroidView(View view){
        Intent intent=new Intent(this,AndroidViewActivity.class);
        startActivity(intent);
    }
}
