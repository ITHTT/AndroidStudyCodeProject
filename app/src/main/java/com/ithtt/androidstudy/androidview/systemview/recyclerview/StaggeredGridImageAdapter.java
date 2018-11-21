package com.ithtt.androidstudy.androidview.systemview.recyclerview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.ithtt.androidstudy.R;

public class StaggeredGridImageAdapter extends DelegateAdapter.Adapter<StaggeredGridImageAdapter.StaggeredGridImageViewHolder>{

    private String[] imgData=null;

    public StaggeredGridImageAdapter(Context context){
        imgData=context.getResources().getStringArray(R.array.recycler_test_datas);
    }


    @Override
    public LayoutHelper onCreateLayoutHelper() {
        StaggeredGridLayoutHelper layoutHelper=new StaggeredGridLayoutHelper(2);
        layoutHelper.setHGap(SizeUtils.dp2px(80));
        layoutHelper.setVGap(0);
        layoutHelper.setLane(2);
        return layoutHelper;
    }

    @NonNull
    @Override
    public StaggeredGridImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recyclerview_image_item,parent,false);
        return new StaggeredGridImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final StaggeredGridImageViewHolder holder, int position) {
        Glide.with(holder.itemView).load(imgData[position])
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        int imageWidth= ScreenUtils.getScreenWidth()/2;
                        int imageHeight=imageWidth*resource.getIntrinsicHeight()/resource.getIntrinsicWidth();
                        ViewGroup.LayoutParams layoutParams=holder.ivImg.getLayoutParams();
                        layoutParams.width=ViewGroup.LayoutParams.MATCH_PARENT;
                        layoutParams.height=imageHeight;
                        holder.ivImg.setLayoutParams(layoutParams);
                        //holder.ivImg.setImageDrawable(resource);
                        return false;
                    }
                }).into(holder.ivImg);
    }

    @Override
    public int getItemCount() {
        return imgData.length;
    }

    public static final class StaggeredGridImageViewHolder extends RecyclerView.ViewHolder{
        ImageView ivImg;

        public StaggeredGridImageViewHolder(View itemView) {
            super(itemView);
            ivImg=itemView.findViewById(R.id.iv_img);
        }
    }
}
