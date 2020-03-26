package com.hummer.hospital_heroes;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppActivity implements View.OnClickListener {

    Button tap_screen_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        setContentView(R.layout.activity_main);
        blinkTapToStart();

        tap_screen_start = (Button) findViewById(R.id.tap_screen_start);

        tap_screen_start.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        Intent reception = new Intent(MainActivity.this, Reception.class);
        startActivity(reception);
    }
}
