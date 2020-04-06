package com.hummer.hospital_heroes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Class that represents the screen where the user selects a character
 *
 * @author Fahim Mohammed, Bleon Uka
 * @version 1.3
 */

public class CharacterSelection extends AppActivity implements View.OnClickListener {

    Button boy1, boy2, girl1, girl2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

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
                Constants.setPlayerGettingStrapped(0,R.drawable.scanner_boyc1_0);
                Constants.setPlayerGettingStrapped(1,R.drawable.scanner_boyc1_1);
                Constants.setPlayerGettingStrapped(2,R.drawable.scanner_boyc1_2);
                Constants.setPlayerGettingStrapped(3,R.drawable.scanner_boyc1_3);
                Constants.setPlayerGettingStrapped(4,R.drawable.scanner_boyc1_4);
                break;
            case R.id.boy2:
                Constants.setPlayerStanding(R.drawable.boy_2_stand);
                Constants.setPlayerChair(R.drawable.boy_2_chair);
                Constants.setPlayerSitting(R.drawable.boy_2_sit);
                Constants.setIsBlack(true);
                Constants.setPlayerGettingStrapped(0,R.drawable.scanner_boyc2_0);
                Constants.setPlayerGettingStrapped(1,R.drawable.scanner_boyc2_1);
                Constants.setPlayerGettingStrapped(2,R.drawable.scanner_boyc2_2);
                Constants.setPlayerGettingStrapped(3,R.drawable.scanner_boyc2_3);
                Constants.setPlayerGettingStrapped(4,R.drawable.scanner_boyc2_4);
                break;
            case R.id.girl1:
                Constants.setPlayerStanding(R.drawable.girl_1_stand);
                Constants.setPlayerChair(R.drawable.girl_1_chair);
                Constants.setPlayerSitting(R.drawable.girl_1_sit);
                Constants.setIsBlack(false);
                Constants.setPlayerGettingStrapped(0,R.drawable.scanner_girlc1_0);
                Constants.setPlayerGettingStrapped(1,R.drawable.scanner_girlc1_1);
                Constants.setPlayerGettingStrapped(2,R.drawable.scanner_girlc1_2);
                Constants.setPlayerGettingStrapped(3,R.drawable.scanner_girlc1_3);
                Constants.setPlayerGettingStrapped(4,R.drawable.scanner_girlc1_4);
                break;
            case R.id.girl2:
                Constants.setPlayerStanding(R.drawable.girl_2_stand);
                Constants.setPlayerChair(R.drawable.girl_2_chair);
                Constants.setPlayerSitting(R.drawable.girl_2_sit);
                Constants.setIsBlack(true);
                Constants.setPlayerGettingStrapped(0,R.drawable.scanner_girlc2_0);
                Constants.setPlayerGettingStrapped(1,R.drawable.scanner_girlc2_1);
                Constants.setPlayerGettingStrapped(2,R.drawable.scanner_girlc2_2);
                Constants.setPlayerGettingStrapped(3,R.drawable.scanner_girlc2_3);
                Constants.setPlayerGettingStrapped(4,R.drawable.scanner_girlc2_4);
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
