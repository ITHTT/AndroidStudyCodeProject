package com.ithtt.androidstudy.androidview.customview.meizubanner;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ithtt.androidstudy.R;
import com.ithtt.androidstudy.androidview.customview.meizubanner.holder.MZHolderCreator;
import com.ithtt.androidstudy.androidview.customview.meizubanner.holder.MZViewHolder;
import com.ithtt.androidstudy.app.BaseActivity;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ithtt on 2017/6/19.
 */

public class MeiZuBannerActivity extends BaseActivity{
    @BindView(R.id.mz_view_pager)
    protected MZBannerView mzBannerView;
    @BindView(R.id.normal_viewPager)
    protected MZBannerView normalBannerView;

    protected String[] images={
    "http://pic.netbian.com/d/file/dbigfile/55aabf8fac8f960f09bee2534ea2aecc.jpg",
    "http://pic.netbian.com/d/file/dbigfile/d7cb1dd9aa418ed1e1706e6a6649ac6e.jpg",
    "http://pic.netbian.com/d/file/dbigfile/d064e71fb7fb86dc194b87cb52241d7a.jpg",
    "http://img.netbian.com/file/2017/0619/ed903fb354de33bb3fd527eaf45ed20f.jpg",
    "http://pic.netbian.com/d/file/dbigfile/b40caca865bdeaebeff384a3a9143bbe.jpg"};

    @Override
    protected int getContentLayout() {
        return R.layout.activity_androidview_meizu_banner;
    }

    @Override
    protected void initView() {
        List<String> imgList= Arrays.asList(images);
        mzBannerView.setPages(imgList, new MZHolderCreator() {
            @Override
            public MZViewHolder createViewHolder() {
                return new ImageBannerHolder();
            }
        });

        normalBannerView.setPages(imgList, new MZHolderCreator() {
            @Override
            public MZViewHolder createViewHolder() {
                return new ImageBannerHolder();
            }
        });

    }

    @Override
    protected void handleIntent(Intent intent) {

    }

    @Override
    public void onPause() {
        super.onPause();
        mzBannerView.pause();
        normalBannerView.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mzBannerView.start();
        normalBannerView.start();
    }

    protected static final class ImageBannerHolder implements MZViewHolder<String> {
        protected ImageView imageView;

        @Override
        public View createView(Context context) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_meizu_banner_item,null);
            imageView= (ImageView) view.findViewById(R.id.item_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, String data) {
            Glide.with(context)
                    .load(data)
                    .into(imageView);

        }
    }
}
