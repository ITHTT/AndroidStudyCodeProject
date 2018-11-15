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

import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.ithtt.androidstudy.R;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder>{

    private String[] imgData=null;

    private int layoutType=0;

    public ImageAdapter(Context context,int type){
        imgData=context.getResources().getStringArray(R.array.recycler_test_datas);
        this.layoutType=type;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recyclerview_image_item,parent,false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ImageViewHolder holder, int position) {
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

    public static final class ImageViewHolder extends RecyclerView.ViewHolder{
        ImageView ivImg;

        public ImageViewHolder(View itemView) {
            super(itemView);
            ivImg=itemView.findViewById(R.id.iv_img);
        }
    }
}
