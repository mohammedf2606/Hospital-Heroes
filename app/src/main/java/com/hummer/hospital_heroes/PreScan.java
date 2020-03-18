package com.hummer.hospital_heroes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import com.hummer.educationalgame.injectionminigame.InjectionMainActivity;

import java.util.ArrayList;

public class PreScan extends Activity implements View.OnClickListener{

    Button scan_room;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.pre_scan);


        scan_room = (Button) findViewById(R.id.scan_door);

        scan_room.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(i == 0) {
                    setContentView(R.layout.pre_scan_door_open);
                    handler.postDelayed(this, 2000);
                    i++;
                }
                else if(i == 1){
                    setContentView(R.layout.pre_scan_entering_door);
                    handler.postDelayed(this, 2000);
                    i++;
                }
                else {
                    Intent scanRoom = new Intent(PreScan.this, ScanRoom.class);
                    startActivity(scanRoom);
                }
            }
        }, 0000);

    }
}
