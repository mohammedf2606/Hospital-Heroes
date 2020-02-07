package com.hummer.educationalgame;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        blinkTapToStart();
    }
    private void blinkTapToStart() {
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int timeIntervals = 700;
                try{Thread.sleep(timeIntervals);}catch (Exception e) {e.printStackTrace();}
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        TextView tapToStart = findViewById(R.id.tap_to_start);
                        if(tapToStart.getVisibility() == View.VISIBLE){
                            tapToStart.setVisibility(View.INVISIBLE);
                        } else {
                            tapToStart.setVisibility(View.VISIBLE);
                        }
                        blinkTapToStart();
                    }
                });
            }
        }).start();
    }

}
