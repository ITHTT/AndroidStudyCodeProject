package com.ithtt.androidstudy.androidview.systemview.recyclerview;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.ithtt.androidstudy.R;
import com.ithtt.androidstudy.app.BaseActivity;

import butterknife.BindView;

import static android.support.v7.widget.StaggeredGridLayoutManager.GAP_HANDLING_NONE;

public class StaggeredGridLayoutActivity extends BaseActivity{
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected int getContentLayout() {
        return R.layout.activity_androidview_recyclerview_info;
    }

    @RequiresApi(api = Build.VERSION_CODES.N_MR1)
    @Override
    protected void initView() {
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        //staggeredGridLayoutManager.setGapStrategy(GAP_HANDLING_NONE);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        //recyclerView.addItemDecoration(new DividerItemDecoration(this,RecyclerView.VERTICAL));
        ImageAdapter adapter=new ImageAdapter(this,1);
        recyclerView.setAdapter(adapter);
        //recyclerView.smoothScrollToPosition(0);
    }

    @Override
    protected void handleIntent(Intent intent) {

    }
}
