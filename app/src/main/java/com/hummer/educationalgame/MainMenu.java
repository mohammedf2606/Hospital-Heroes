package com.hummer.educationalgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class MainMenu extends AppCompatActivity implements View.OnClickListener {

    ImageButton nurse, girl_eating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.menu);

        nurse = (ImageButton) findViewById(R.id.nurse);
        girl_eating = (ImageButton) findViewById(R.id.girl_eating);

        nurse.setOnClickListener(this);
        girl_eating.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent menu_page = new Intent(MainMenu.this, Reception.class);
        startActivity(menu_page);
    }
}
