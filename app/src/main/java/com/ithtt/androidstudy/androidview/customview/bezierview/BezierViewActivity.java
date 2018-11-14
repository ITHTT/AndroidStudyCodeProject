package com.ithtt.androidstudy.androidview.customview.bezierview;

import android.content.Intent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.ithtt.androidstudy.R;
import com.ithtt.androidstudy.app.BaseActivity;

/**
 * Created by ithtt on 2017/6/21.
 */

public class BezierViewActivity extends BaseActivity{
    private BezierView mBezierView;

    private SeekBar mSeekBar;

    private TextView mTextView;

    private Switch mLoop, mTangent;

    @Override
    protected int getContentLayout() {
        return R.layout.activity_androidview_bezierview;
    }

    @Override
    protected void initView() {
        mBezierView = (BezierView) findViewById(R.id.bezier);
        mTextView = (TextView) findViewById(R.id.textview);
        mSeekBar = (SeekBar) findViewById(R.id.seekbar);
        mLoop = (Switch) findViewById(R.id.loop);
        mTangent = (Switch) findViewById(R.id.tangent);

        mTextView.setText(mBezierView.getOrderStr() + "阶贝塞尔曲线");

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress == 0) {
                    progress = 1;
                }
                mBezierView.setRate(progress * 2);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mLoop.setChecked(false);
        mTangent.setChecked(true);
        mLoop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mBezierView.setLoop(isChecked);
            }
        });
        mTangent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mBezierView.setTangent(isChecked);
            }
        });
    }

    @Override
    protected void handleIntent(Intent intent) {

    }

    public void start(View view) {
        mBezierView.start();
    }

    public void stop(View view) {
        mBezierView.stop();
    }

    public void add(View view) {
        Toast.makeText(this,"Add Point",Toast.LENGTH_SHORT).show();
        if (mBezierView.addPoint()) {
            mTextView.setText(mBezierView.getOrderStr() + "阶贝塞尔曲线");
        } else {
            Toast.makeText(this,"Add point failed.",Toast.LENGTH_SHORT).show();
        }
    }

    public void del(View view) {
        if (mBezierView.delPoint()) {
            mTextView.setText(mBezierView.getOrderStr() + "阶贝塞尔曲线");
        } else {
           Toast.makeText(this,"Delete point failed.",Toast.LENGTH_SHORT).show();
        }
    }
}
