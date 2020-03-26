package com.hummer.hospital_heroes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.hummer.hospital_heroes.rocket_minigame.MainMenu;

import java.util.ArrayList;

public class StrapToChair extends Activity implements View.OnClickListener {

    ImageButton strapping;
    ArrayList<Integer> differentStrap = new ArrayList<>();
    int i = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        setContentView(R.layout.strap_to_chair);

        differentStrap = Constants.getPlayerStraps();

        strapping = (ImageButton) findViewById(R.id.strapping);
        strapping.setImageResource(differentStrap.get(i));
        strapping.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(i < 5){
            strapping.setImageResource(differentStrap.get(i));
            i++;
        }
        else{
            Intent rocket_game = new Intent(StrapToChair.this, MainMenu.class);
            startActivity(rocket_game);
        }
    }
}
