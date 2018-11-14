package com.ithtt.androidstudy.androidview.customview.meizubanner.holder;

import android.content.Context;
import android.view.View;

/**
 * Created by ithtt on 2017/6/19.
 */

public interface MZViewHolder<T> {
    /**
     *  创建View
     * @param context
     * @return
     */
    View createView(Context context);

    /**
     * 绑定数据
     * @param context
     * @param position
     * @param data
     */
    void onBind(Context context, int position, T data);
}
