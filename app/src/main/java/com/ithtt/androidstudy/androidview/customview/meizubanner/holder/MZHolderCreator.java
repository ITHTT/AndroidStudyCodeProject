package com.ithtt.androidstudy.androidview.customview.meizubanner.holder;

/**
 * Created by ithtt on 2017/6/19.
 */

public interface MZHolderCreator<VH extends MZViewHolder> {
    /**
     * 创建ViewHolder
     * @return
     */
    public VH createViewHolder();
}
