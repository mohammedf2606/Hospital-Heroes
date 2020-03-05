package com.hummer.educationalgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Reception extends Activity implements View.OnClickListener{

    Button receptionist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        setContentView(R.layout.activity_reception);

        receptionist = (Button) findViewById(R.id.receptionist);
        receptionist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent gender_selection = new Intent(Reception.this, GenderSelection.class);
        startActivity(gender_selection);
    }

}
