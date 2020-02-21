package com.hummer.educationalgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class MaleCharSelection extends Activity implements View.OnClickListener {

    ImageButton male1, male2, male3, male4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.male_characters);

        male1 = findViewById(R.id.boy1);
        male1.setOnClickListener(this);

        male2 = findViewById(R.id.boy2);
        male2.setOnClickListener(this);

        male3 = findViewById(R.id.boy3);
        male3.setOnClickListener(this);

        male4 = findViewById(R.id.boy4);
        male4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.boy1:
                Constants.setPlayerSitting(R.drawable.boy_chair);
                Constants.setPlayerCharacter(R.drawable.boy_character);
                break;
            case R.id.boy2:
                Constants.setPlayerSitting(R.drawable.boy_chair);
                Constants.setPlayerCharacter(R.drawable.boy_character);
                break;
            case R.id.boy3:
                Constants.setPlayerSitting(R.drawable.boy_chair);
                Constants.setPlayerCharacter(R.drawable.boy_character);
                break;
            case R.id.boy4:
                Constants.setPlayerSitting(R.drawable.boy_chair);
                Constants.setPlayerCharacter(R.drawable.boy_character);
                break;
        }
        if(Constants.isFood()) {
            Intent food_selection = new Intent(MaleCharSelection.this, FoodSelection.class);
            startActivity(food_selection);
        }
        else {
            Intent injection_room = new Intent(MaleCharSelection.this, InjectionRoom.class);
            startActivity(injection_room);
        }
    }
}
