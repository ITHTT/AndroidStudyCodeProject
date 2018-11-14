package com.ithtt.androidstudy.androidview.customview.chartview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

/**
 * Created by ithtt on 2017/8/2.
 */

abstract public class BaseChartView extends View {

    protected String[] xLabels;//横坐标
    protected String[] yLabels;//纵坐标
    protected float height;
    protected float width;

    protected float maxY=100f;//纵坐标最大值
    protected float xUnit;
    protected float yUnit;

    protected float xLabelWidth=70f;
    protected float yLabelHeight=60f;

    protected Paint paint;

    protected List<PointValue> pointList;

    public BaseChartView(Context context) {
        super(context);
        initView(context);
    }

    public BaseChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public BaseChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public BaseChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        height=h;
        width=w;

        if(xLabels!=null&&yLabels!=null) {
            xUnit = (width-2*xLabelWidth) / (xLabels.length-1);
            yUnit = (height-2*yLabelHeight) /( yLabels.length-1);
        }
    }

    protected void initView(Context context){
        paint=new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(30f);
        //paint.setStyle(Paint.Style.STROKE);
    }

    public void setxLabels(String[] xLabes) {
        this.xLabels = xLabes;
    }

    public void setyLabels(String[] yLabes){
        this.yLabels=yLabes;
    }

    public void setPointList(List<PointValue> points){
        this.pointList=points;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawXLabel(canvas);
        drawYLabel(canvas);

        drawChart(canvas);
    }

    protected void drawYLabel(Canvas canvas){
        if(yLabels!=null) {
            float fontHeight=paint.getFontMetrics().descent-paint.getFontMetrics().ascent;
            for(int i=0;i<yLabels.length;i++){
                canvas.drawText(yLabels[i],xLabelWidth-paint.measureText(yLabels[i]),height-yLabelHeight-((yLabels.length-i-1)*yUnit),paint);
                canvas.drawLine(xLabelWidth+10,
                        height-yLabelHeight-((yLabels.length-i-1)*yUnit)-fontHeight/3,
                        width-xLabelWidth/2,
                        height-yLabelHeight-((yLabels.length-i-1)*yUnit)-fontHeight/3,
                        paint);
            }
        }
    }

    protected void drawXLabel(Canvas canvas){
        if(xLabels!=null){
            for(int i=0;i<xLabels.length;i++){
                canvas.drawText(xLabels[i],xLabelWidth+i*xUnit-paint.measureText(xLabels[i])/2,height-yLabelHeight/2,paint);
            }
        }
    }

    protected abstract void drawChart(Canvas canvas);
}
