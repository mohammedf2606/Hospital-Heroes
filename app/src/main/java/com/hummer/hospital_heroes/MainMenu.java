package com.hummer.hospital_heroes;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;

public class MainMenu extends AppActivity implements View.OnClickListener {

    ImageButton injection_menu, food_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DisplayMetrics dp = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getRealMetrics(dp);
        Constants.setScreenHeight(dp.heightPixels);
        Constants.setScreenWidth(dp.widthPixels);
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        setContentView(R.layout.menu);

        injection_menu = (ImageButton) findViewById(R.id.injection_menu);
        food_menu = (ImageButton) findViewById(R.id.food_menu);

        injection_menu.setOnClickListener(this);
        food_menu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.injection_menu:
                Constants.setIsFood(false);
                break;
            case R.id.food_menu:
                Constants.setIsFood(true);
                break;
        }
        Intent main_page = new Intent(MainMenu.this, MainActivity.class);
        SoundEffects.initSounds(MainMenu.this);
        startService(new Intent(MainMenu.this, MusicService.class));
        startActivity(main_page);
    }
}
