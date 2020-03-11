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
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_reception);

        receptionist = (Button) findViewById(R.id.receptionist);
        receptionist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent gender_selection = new Intent(Reception.this, CharacterSelection.class);
        startActivity(gender_selection);
    }

}
