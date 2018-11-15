package com.ithtt.androidstudy.androidview.systemview.recyclerview;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ithtt.androidstudy.R;
import com.ithtt.androidstudy.app.BaseActivity;

import butterknife.BindView;

public class GridLayoutActivity extends BaseActivity{
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected int getContentLayout() {
        return R.layout.activity_androidview_recyclerview_info;
    }

    @Override
    protected void initView() {
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        //recyclerView.addItemDecoration(new DividerItemDecoration(this,RecyclerView.VERTICAL));
        ImageAdapter adapter=new ImageAdapter(this,1);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void handleIntent(Intent intent) {

    }
}
