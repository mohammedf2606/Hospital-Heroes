package com.hummer.hospital_heroes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.os.Handler;
import android.widget.Button;

public class PreScan extends AppActivity implements View.OnClickListener{

    Button scan_room;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

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
        }, 0);

    }
}
