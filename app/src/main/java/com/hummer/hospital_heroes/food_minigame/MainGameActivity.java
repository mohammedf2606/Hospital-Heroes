package com.hummer.hospital_heroes.food_minigame;

import android.os.Bundle;
import com.hummer.hospital_heroes.AppActivity;
import com.hummer.hospital_heroes.Constants;
import com.hummer.hospital_heroes.R;

/**
 * MainGameActivity represents the class which contains the activity
 * the game runs in.
 *
 * @author Manav Parikh
 * @version 1.0
 */

public class MainGameActivity extends AppActivity {

    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gameView = new GameView(this);
        overridePendingTransition(R.anim.slideinright, R.anim.slideoutright);
        setContentView(gameView);
    }

    public GameView getGameView() {
        return gameView;
    }
}
