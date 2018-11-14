package com.ithtt.androidstudy.androidview.customview.pageviewtransition;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ithtt.androidstudy.BaseFragment;
import com.ithtt.androidstudy.R;

import butterknife.BindView;

/**
 * Created by ithtt on 16/9/26.
 */
public class PagerViewFragment extends BaseFragment{
    @BindView(R.id.image)
    protected ImageView imageView;
    @BindView(R.id.address1)
    protected View tvAddress1;
    @BindView(R.id.address2)
    protected View tvAddress2;
    @BindView(R.id.address3)
    protected View tvAddress3;
    @BindView(R.id.address4)
    protected View tvAddress4;
    @BindView(R.id.rating)
    protected RatingBar ratingBar;
    @BindView(R.id.head1)
    protected View head1;
    @BindView(R.id.head2)
    protected View head2;
    @BindView(R.id.head3)
    protected View head3;
    @BindView(R.id.head4)
    protected View head4;

    protected int imgUrl;

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_androidview_pageviewtransition_page;
    }

    @Override
    protected void initView(View view) {
        Glide.with(this).load(imgUrl).into(imageView);
    }

    public void setImgUrl(int url){
        this.imgUrl=url;
    }
}
