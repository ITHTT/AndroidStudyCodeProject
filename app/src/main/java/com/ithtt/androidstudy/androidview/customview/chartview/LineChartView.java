package com.ithtt.androidstudy.androidview.customview.chartview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ithtt on 2017/8/2.
 */

public class LineChartView extends BaseChartView {

    public LineChartView(Context context) {
        super(context);
    }

    public LineChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LineChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LineChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void drawChart(Canvas canvas) {
        if(pointList!=null){
            Path path=new Path();
            paint.setStyle(Paint.Style.FILL);
            float fontHeight=paint.getFontMetrics().descent-paint.getFontMetrics().ascent;
            int size=pointList.size();
            for(int i=0;i<size;i++){
                PointValue point=pointList.get(i);
                float x=xLabelWidth+point.getX()*xUnit;
                float y=height-yLabelHeight-point.getY()*yUnit-fontHeight/3;
                if(i==0){
                    path.moveTo(x,y);
                }else{
                    path.lineTo(x,y);
                }
                canvas.drawCircle(x,y,10f,paint);
            }
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawPath(path,paint);
        }
    }
}
