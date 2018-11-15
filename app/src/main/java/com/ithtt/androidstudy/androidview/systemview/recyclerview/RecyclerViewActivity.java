package com.ithtt.androidstudy.androidview.systemview.recyclerview;

import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.view.View;

import com.blankj.utilcode.util.ActivityUtils;
import com.ithtt.androidstudy.R;
import com.ithtt.androidstudy.app.BaseActivity;

import butterknife.OnClick;

public class RecyclerViewActivity extends BaseActivity{

    @Override
    protected int getContentLayout() {
        return R.layout.activity_androidview_recyclerview;
    }

    @Override
    protected void initView() {


    }

    @Override
    protected void handleIntent(Intent intent) {

    }

    @OnClick({R.id.item_layout_linear,
            R.id.item_layout_grid,
            R.id.item_layout_staggered})
    public void onClickItem(View view){
        switch (view.getId()){
            case R.id.item_layout_linear:
                ActivityUtils.startActivity(LinearLayoutActivity.class);
                break;
            case R.id.item_layout_grid:
                ActivityUtils.startActivity(GridLayoutActivity.class);
                break;
            case R.id.item_layout_staggered:
                ActivityUtils.startActivity(StaggeredGridLayoutActivity.class);
                break;
        }
    }
}
