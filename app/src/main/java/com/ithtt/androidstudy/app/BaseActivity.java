package com.ithtt.androidstudy.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by ithtt on 16/9/21.
 */
public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentLayout());
        ButterKnife.bind(this);
        initView();
        handleIntent(getIntent());
    }

    protected abstract int getContentLayout();

    protected abstract void initView();

    protected abstract void handleIntent(Intent intent);
}
