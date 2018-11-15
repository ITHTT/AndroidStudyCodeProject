package com.ithtt.androidstudy.androidview.systemview.recyclerview;

import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ithtt.androidstudy.R;
import com.ithtt.androidstudy.app.BaseActivity;

import butterknife.BindView;

public class LinearLayoutActivity extends BaseActivity{
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected int getContentLayout() {
        return R.layout.activity_androidview_recyclerview_info;
    }

    @Override
    protected void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                RecyclerView.VERTICAL,
                true));
        //recyclerView.addItemDecoration(new DividerItemDecoration(this,RecyclerView.VERTICAL));
        ImageAdapter adapter=new ImageAdapter(this,0);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void handleIntent(Intent intent) {

    }
}
