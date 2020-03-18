package com.hummer.hospital_heroes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.hummer.hospital_heroes.injection_minigame.InjectionMainMenu;

import java.util.ArrayList;

public class WaitingRoom extends Activity {

    ImageView waiting_room;
    ArrayList<Integer> timers = new ArrayList<>();
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.waiting_room);

        timers.add(0, R.drawable.waiting_room_00);
        timers.add(1, R.drawable.waiting_room_05);
        timers.add(2, R.drawable.waiting_room_10);
        timers.add(3, R.drawable.waiting_room_15);
        timers.add(4, R.drawable.waiting_room_20);
        timers.add(5, R.drawable.waiting_room_25);
        timers.add(6, R.drawable.waiting_room_30);
        timers.add(7, R.drawable.waiting_room_35);
        timers.add(8, R.drawable.waiting_room_40);
        timers.add(9, R.drawable.waiting_room_40);

        waiting_room = findViewById(R.id.waiting_room);

        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(i < 9) {
                    waiting_room.setImageResource(timers.get(i));
                    i++;
                    handler.postDelayed(this, 500);
                }
                else {
<<<<<<< HEAD:app/src/main/java/com/hummer/educationalgame/WaitingRoom.java
                    // TODO: Fareed replace the 2nd parameter below with your MainActivity
                    Intent injection_minigame = new Intent(WaitingRoom.this, PreScan.class);
=======
                    Intent injection_minigame = new Intent(WaitingRoom.this, InjectionMainMenu.class);
>>>>>>> bd5f39c38d640068efccf61b9a9bac265ac6b6a4:app/src/main/java/com/hummer/hospital_heroes/WaitingRoom.java
                    startActivity(injection_minigame);
                }
            }
        }, 2000);
    }


}
