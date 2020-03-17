package com.hummer.hospital_heroes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class CharacterSelection extends Activity implements View.OnClickListener{

    Button boy1, boy2, girl1, girl2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        setContentView(R.layout.character_selection);

        boy1 = (Button) findViewById(R.id.boy1);
        boy1.setOnClickListener(this);

        boy2 = (Button) findViewById(R.id.boy2);
        boy2.setOnClickListener(this);

        girl1 = (Button) findViewById(R.id.girl1);
        girl1.setOnClickListener(this);

        girl2 = (Button) findViewById(R.id.girl2);
        girl2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.boy1:
                Constants.setPlayerCharacter(R.drawable.boy_1);
                Constants.setPlayerSitting(R.drawable.boy_chair);
                Constants.setIsBlack(false);
                break;
            case R.id.boy2:
                Constants.setPlayerCharacter(R.drawable.boy_2);
                Constants.setPlayerSitting(R.drawable.boy_chair);
                Constants.setIsBlack(true);
                break;
            case R.id.girl1:
                Constants.setPlayerCharacter(R.drawable.girl_1);
                Constants.setPlayerSitting(R.drawable.girl_chair);
                Constants.setIsBlack(false);
                break;
            case R.id.girl2:
                Constants.setPlayerCharacter(R.drawable.girl_2);
                Constants.setPlayerSitting(R.drawable.girl_chair);
                Constants.setIsBlack(true);
                break;
        }
        if(Constants.isFood()) {
            Intent food_selection = new Intent(CharacterSelection.this, FoodSelection.class);
            startActivity(food_selection);
        }
        else {
            Intent injection_room = new Intent(CharacterSelection.this, InjectionRoom.class);
            startActivity(injection_room);
        }
    }
}
