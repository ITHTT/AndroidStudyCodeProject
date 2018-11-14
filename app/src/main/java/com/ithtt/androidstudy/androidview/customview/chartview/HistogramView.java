package com.ithtt.androidstudy.androidview.customview.chartview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.ithtt.androidstudy.util.DensityUtil;

import java.util.List;

/**
 * Created by ithtt on 2017/8/3.
 * 电灯直方图
 */

public class HistogramView extends View {
    //Y轴最大值
    private float maxY=4000;
    //Y轴刻度长度
    private float yUnit;
    //Y轴刻度数量
    private float yUnitCount=4;
    //Y轴刻度大小
    private float yUnitValue;
    //X轴刻度大小
    private float xUnit;

    private float width;
    private float height;

    private Paint paint=null;
    //X轴标签高度
    private float xLabelHeight=150;
    //Y轴标签宽度
    private float yLabelWidth=120;

    //X轴标签左右间距
    private float xPadding=30;
    //直方图间隔
    private float xSpaceing=10;

    private List<PointAttributeValue> valuePointList;

    private List<PointAttributeValue> typePointList;




    public HistogramView(Context context) {
        super(context);
        initView(context);
    }

    public HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width=w;
        height=h;

        yUnit=(height-xLabelHeight)/yUnitCount;
        yUnitValue=maxY/yUnitCount;

    }

    private void initView(Context context){
        paint=new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setTextSize(DensityUtil.sp2px(context,13));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawYLabel(canvas);
        drawXLabel(canvas);
        drawChart(canvas);
    }


    protected void drawYLabel(Canvas canvas){
        for(int i=0;i<yUnitCount+1;i++){
            String label=String.valueOf((int)(i*yUnitValue));
            float fontHeight=paint.getFontMetrics().descent-paint.getFontMetrics().ascent;
            canvas.drawText(label,yLabelWidth-paint.measureText(label),height-xLabelHeight/2-i*yUnit,paint);
            canvas.drawLine(yLabelWidth+10,
                    height-xLabelHeight/2-i*yUnit-fontHeight/4,
                    width,
                    height-xLabelHeight/2-i*yUnit-fontHeight/4,
                    paint);
        }
    }

    protected void drawXLabel(Canvas canvas){
        float xCenter=(width-yLabelWidth)/2;
        String[] xLabels={"功率","类型"};

        float xLabel1=yLabelWidth+xCenter/2-paint.measureText(xLabels[0])/2;
        float y=height-xLabelHeight/5;

        canvas.drawText(xLabels[0],xLabel1,y,paint);

        float xLabel2=yLabelWidth+3*xCenter/2-paint.measureText(xLabels[0])/2;
        canvas.drawText(xLabels[1],xLabel2,y,paint);
    }

    protected void drawChart(Canvas canvas){
        float fontHeight=paint.getFontMetrics().descent-paint.getFontMetrics().ascent;

        float xCenter=(width-yLabelWidth)/2;
        float bottomY=height-xLabelHeight/2-fontHeight/4;

        if(valuePointList!=null){
            int size=valuePointList.size();
            float xUnit=(xCenter-(2*xPadding)-(size-1)*xSpaceing)/size;
            Path path=new Path();
            for(int i=0;i<size;i++){
                float x=yLabelWidth+xPadding+i*xSpaceing+i*xUnit;
                float y=valuePointList.get(i).getyValue()*(yUnit/yUnitValue);
                path.moveTo(x,bottomY);
                path.lineTo(x,bottomY-y);
                path.lineTo(x+xUnit,bottomY-y);
                path.lineTo(x+xUnit,bottomY);
                path.close();
                canvas.drawPath(path,paint);
            }
        }

        if(typePointList!=null){
            int size=typePointList.size();
            float xUnit=(xCenter-(2*xPadding)-(size-1)*xSpaceing)/size;
            Path path=new Path();
            for(int i=0;i<size;i++){
                float x=yLabelWidth+xCenter+xPadding+i*xSpaceing+i*xUnit;
                float y=typePointList.get(i).getyValue()*(yUnit/yUnitValue);
                path.moveTo(x,bottomY);
                path.lineTo(x,bottomY-y);
                path.lineTo(x+xUnit,bottomY-y);
                path.lineTo(x+xUnit,bottomY);
                path.close();
                canvas.drawPath(path,paint);
            }
        }
    }

    public void setValuePointList(List<PointAttributeValue> valuePointList) {
        this.valuePointList = valuePointList;
    }

    public void setTypePointList(List<PointAttributeValue> typePointList) {
        this.typePointList = typePointList;
    }
}
