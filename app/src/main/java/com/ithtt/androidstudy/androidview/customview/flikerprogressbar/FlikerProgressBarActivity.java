package com.ithtt.androidstudy.androidview.customview.flikerprogressbar;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.ithtt.androidstudy.R;
import com.ithtt.androidstudy.app.BaseActivity;

import butterknife.BindView;

/**
 * Created by ithtt on 16/10/3.
 */

public class FlikerProgressBarActivity extends BaseActivity{
    @BindView(R.id.fliker_progressbar)
    protected FlikerProgressBar flikerProgressBar;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            flikerProgressBar.setProgress(msg.arg1);
            if(msg.arg1 == 100){
                flikerProgressBar.finishLoad();
            }
        }
    };

    @Override
    protected int getContentLayout() {
        return R.layout.activity_androidview_flickerprogressbar;
    }

    @Override
    protected void initView() {
        flikerProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!flikerProgressBar.isFinish()){
                    flikerProgressBar.toggle();
                }
            }
        });
        downLoad();
    }

    @Override
    protected void handleIntent(Intent intent) {

    }

    private void downLoad() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(200);
                        Message message = handler.obtainMessage();
                        message.arg1 = i + 1;
                        handler.sendMessage(message);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
