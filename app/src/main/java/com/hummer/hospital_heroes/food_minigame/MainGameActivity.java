package com.hummer.hospital_heroes.food_minigame;

import android.os.Bundle;
import com.hummer.hospital_heroes.AppActivity;
import com.hummer.hospital_heroes.R;

public class MainGameActivity extends AppActivity {

    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = findViewById(R.id.game_view);
        overridePendingTransition(R.anim.slideinright, R.anim.slideoutright);
        setContentView(R.layout.food_minigame);
    }

    public GameView getGameView() {
        return gameView;
    }
}
