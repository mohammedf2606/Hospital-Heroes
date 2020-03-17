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
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
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
                Constants.setPlayerStanding(R.drawable.boy_1_stand);
                Constants.setPlayerChair(R.drawable.boy_1_chair);
                Constants.setPlayerSitting(R.drawable.boy_1_sit);
                Constants.setIsBlack(false);
                break;
            case R.id.boy2:
                Constants.setPlayerStanding(R.drawable.boy_2_stand);
                Constants.setPlayerChair(R.drawable.boy_2_chair);
                Constants.setPlayerSitting(R.drawable.boy_2_sit);
                Constants.setIsBlack(true);
                break;
            case R.id.girl1:
                Constants.setPlayerStanding(R.drawable.girl_1_stand);
                Constants.setPlayerChair(R.drawable.girl_1_chair);
                Constants.setPlayerSitting(R.drawable.girl_1_sit);
                Constants.setIsBlack(false);
                break;
            case R.id.girl2:
                Constants.setPlayerStanding(R.drawable.girl_2_stand);
                Constants.setPlayerChair(R.drawable.girl_2_chair);
                Constants.setPlayerSitting(R.drawable.girl_2_sit);
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
