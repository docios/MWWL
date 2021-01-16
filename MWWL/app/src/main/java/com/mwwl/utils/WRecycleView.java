package com.mwwl.utils;

import android.content.Context;
import android.util.AttributeSet;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by 冯志强 on 2017/6/14 0014.
 * 解决ScrollView中嵌套WListView，WListView只显示一行问题
 */

public class WRecycleView extends RecyclerView {
    public WRecycleView(Context context) {
        this(context, null);
    }

    public WRecycleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WRecycleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        //根据模式据算每个child的高度和宽度
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        setMeasuredDimension(widthMeasureSpec,heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
