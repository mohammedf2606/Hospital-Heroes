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
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
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
