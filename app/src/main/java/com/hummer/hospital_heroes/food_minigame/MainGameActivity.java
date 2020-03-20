package com.hummer.hospital_heroes.food_minigame;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.hummer.hospital_heroes.R;

public class MainGameActivity extends Activity {

    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        gameView = findViewById(R.id.game_view);

        overridePendingTransition(R.anim.slideinright, R.anim.slideoutright);

        setContentView(R.layout.food_minigame);
    }
}
