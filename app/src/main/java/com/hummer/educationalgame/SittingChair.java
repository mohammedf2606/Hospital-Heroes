package com.hummer.educationalgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class SittingChair extends Activity implements View.OnClickListener {

    ImageButton cream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        setContentView(R.layout.sitting_chair);

        cream = findViewById(R.id.cream);
        cream.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent waiting_room = new Intent(SittingChair.this, WaitingRoom.class);
        startActivity(waiting_room);
    }
}
