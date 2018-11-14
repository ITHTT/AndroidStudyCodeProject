package com.ithtt.androidstudy.androidview.customview.chartview;

import android.content.Intent;

import com.ithtt.androidstudy.R;
import com.ithtt.androidstudy.app.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ithtt on 2017/8/2.
 */

public class ChartViewActivity extends BaseActivity{
    @BindView(R.id.line_chartview)
    protected LineChartView lineChartView;

    @BindView(R.id.histogramview)
    protected HistogramView histogramView;

    @Override
    protected int getContentLayout() {
        return R.layout.activity_androidview_chartview;
    }

    @Override
    protected void initView() {
        lineChartView.setyLabels(new String[]{"100%","75%","50%","25%","0"});
        lineChartView.setxLabels(new String[]{"03/21","03/22","03/23","03/24","03/25"});

        List<PointValue> pointList=new ArrayList<>(7);
        PointValue pointValue=new PointValue();
        pointValue.setX(0);
        pointValue.setY(80f/25f);
        pointList.add(pointValue);

        pointValue=new PointValue();
        pointValue.setX(1);
        pointValue.setY(75f/25f);
        pointList.add(pointValue);

        pointValue=new PointValue();
        pointValue.setX(2);
        pointValue.setY(90f/25f);
        pointList.add(pointValue);

        pointValue=new PointValue();
        pointValue.setX(3);
        pointValue.setY(50f/25f);
        pointList.add(pointValue);

        pointValue=new PointValue();
        pointValue.setX(4);
        pointValue.setY(30/25f);
        pointList.add(pointValue);

        lineChartView.setPointList(pointList);

        List<PointAttributeValue> valueList=new ArrayList<>(3);

        PointAttributeValue point=new PointAttributeValue();
        point.setxLabel("122");
        point.setyValue(1220);
        valueList.add(point);

        point=new PointAttributeValue();
        point.setxLabel("246");
        point.setyValue(1478);
        valueList.add(point);

        point=new PointAttributeValue();
        point.setxLabel("412");
        point.setyValue(2600);
        valueList.add(point);

        histogramView.setValuePointList(valueList);

        List<PointAttributeValue> typeList=new ArrayList<>(3);

        point=new PointAttributeValue();
        point.setxLabel("高杆");
        point.setyValue(1000);
        typeList.add(point);

        point=new PointAttributeValue();
        point.setxLabel("中杆");
        point.setyValue(1800);
        typeList.add(point);

        point=new PointAttributeValue();
        point.setxLabel("庭院");
        point.setyValue(3671);
        typeList.add(point);

        histogramView.setTypePointList(typeList);
    }

    @Override
    protected void handleIntent(Intent intent) {

    }
}
