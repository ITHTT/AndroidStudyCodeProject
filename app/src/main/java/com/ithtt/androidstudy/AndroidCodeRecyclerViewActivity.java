package com.ithtt.androidstudy;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ithtt.androidstudy.app.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ithtt on 16/9/21.
 */
public class AndroidCodeRecyclerViewActivity extends BaseActivity{
    public static final String ANDROID_CODE_ARRAY="android_code_array";
    @BindView(R.id.recyclerview)
    protected RecyclerView recyclerView;

    protected List<AndroidCodeEntity> androidCodeList;
    protected AndroidCodeAdapter adapter=null;

    @Override
    protected int getContentLayout() {
        return R.layout.activity_android_code_recyclerview;
    }

    @Override
    protected void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void handleIntent(Intent intent) {
        String[]androidCodeArray=intent.getStringArrayExtra(ANDROID_CODE_ARRAY);
        if(androidCodeArray!=null){
            androidCodeList=new ArrayList<>(androidCodeArray.length);
            for(int i=0;i<androidCodeArray.length;i++){
                String[]items=androidCodeArray[i].split("@");
                if(items!=null&&items.length>=3){
                    AndroidCodeEntity entity=new AndroidCodeEntity();
                    entity.setClassName(items[0]);
                    entity.setTitle(items[1]);
                    entity.setBrief(items[2]);
                    androidCodeList.add(entity);
                }
            }
            adapter=new AndroidCodeAdapter(androidCodeList);
            recyclerView.setAdapter(adapter);
        }



    }
}
