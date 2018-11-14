package com.ithtt.androidstudy.androidview.customview.pyramidview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.ithtt.androidstudy.util.DensityUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ithtt on 2017/5/25.
 * 金子塔统计图
 */

public class PyramidView extends View {
    //金字塔统计图底角
    private double angle=2*Math.PI/5;
    //控件宽度
    private int width;
    //高度
    private int height;
    //绘制画笔
    private Paint paint;
    //绘制路径
    private List<Path> paths;
    //统计间距
    private int step;

    public PyramidView(Context context) {
        super(context);
        initView(context);
    }

    public PyramidView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public PyramidView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public PyramidView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width=MeasureSpec.getSize(widthMeasureSpec);
        height= (int) (Math.tan(angle)*width/2);
        setMeasuredDimension(width,height);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width=w;
        height=h;

        initPyramidPath(width,height);
    }

    private void initView(Context context){
        step=DensityUtil.dip2px(context,5);

        paint=new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#303F9F"));

    }

    private void initPyramidPath(int width,int height){
        if(paths==null){
            paths=new ArrayList<>(5);
            float baseStepY=(height-4*step)/5;
            double tan=Math.tan(angle);

            Path path=new Path();
            float stepX= (float) (baseStepY/tan);
            path.moveTo(width/2,0);
            path.lineTo(width/2-stepX,baseStepY);
            path.lineTo(width/2+stepX,baseStepY);
            paths.add(path);

            path=new Path();
            stepX= (float) ((baseStepY+step)/tan);
            path.moveTo(width/2-stepX,baseStepY+step);
            path.lineTo(width/2+stepX,baseStepY+step);
            stepX= (float) ((2*baseStepY+step)/tan);
            path.lineTo(width/2+stepX,2*baseStepY+step);
            path.lineTo(width/2-stepX,2*baseStepY+step);
            paths.add(path);

            path=new Path();
            stepX= (float) (2*(baseStepY+step)/tan);
            path.moveTo(width/2-stepX,2*(baseStepY+step));
            path.lineTo(width/2+stepX,2*(baseStepY+step));
            stepX= (float) ((3*baseStepY+2*step)/tan);
            path.lineTo(width/2+stepX,3*baseStepY+2*step);
            path.lineTo(width/2-stepX,3*baseStepY+2*step);
            paths.add(path);

            path=new Path();
            stepX= (float) (3*(baseStepY+step)/tan);
            path.moveTo(width/2-stepX,3*(baseStepY+step));
            path.lineTo(width/2+stepX,3*(baseStepY+step));
            stepX= (float) ((4*baseStepY+3*step)/tan);
            path.lineTo(width/2+stepX,4*baseStepY+3*step);
            path.lineTo(width/2-stepX,4*baseStepY+3*step);
            paths.add(path);

            path=new Path();
            stepX= (float) (4*(baseStepY+step)/tan);
            path.moveTo(width/2-stepX,4*(baseStepY+step));
            path.lineTo(width/2+stepX,4*(baseStepY+step));
            stepX= (float) ((5*baseStepY+4*step)/tan);
            path.lineTo(width/2+stepX,5*baseStepY+4*step);
            path.lineTo(width/2-stepX,5*baseStepY+4*step);
            paths.add(path);

        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawPaths(canvas);
    }

    protected void drawPaths(Canvas canvas){
        for(Path path:paths){
            canvas.drawPath(path,paint);
        }
    }
}
