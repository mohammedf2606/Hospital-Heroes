package com.hummer.educationalgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class FemaleCharSelection extends Activity implements View.OnClickListener {

    ImageButton female1, female2, female3, female4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        setContentView(R.layout.female_characters);

        female1 = findViewById(R.id.girl1);
        female1.setOnClickListener(this);

        female2 = findViewById(R.id.girl2);
        female2.setOnClickListener(this);

        female3 = findViewById(R.id.girl3);
        female3.setOnClickListener(this);

        female4 = findViewById(R.id.girl4);
        female4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.girl1:
                Constants.setPlayerSitting(R.drawable.girl_chair);
                Constants.setPlayerCharacter(R.drawable.girl_character);
                break;
            case R.id.girl2:
                Constants.setPlayerSitting(R.drawable.girl_chair);
                Constants.setPlayerCharacter(R.drawable.girl_character);
                break;
            case R.id.girl3:
                Constants.setPlayerSitting(R.drawable.girl_chair);
                Constants.setPlayerCharacter(R.drawable.girl_character);
                break;
            case R.id.girl4:
                Constants.setPlayerSitting(R.drawable.girl_chair);
                Constants.setPlayerCharacter(R.drawable.girl_character);
                break;
        }
        if(Constants.isFood()) {
            Intent food_selection = new Intent(FemaleCharSelection.this, FoodSelection.class);
            startActivity(food_selection);
        }
        else {
            Intent injection_room = new Intent(FemaleCharSelection.this, InjectionRoom.class);
            startActivity(injection_room);
        }
    }
}
