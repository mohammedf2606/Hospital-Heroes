package com.hummer.hospital_heroes.cream_minigame;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import com.hummer.hospital_heroes.R;
import com.hummer.hospital_heroes.WaitingRoom;

/**
 * GameActivity represents the class which contains the activity
 * the game runs in. An activity is a 'screen' which is interactive.
 * The XML for the activity is empty since the background images and
 * sprites are drawn using the GameView class.
 *
 * @author Jawad Zeidan
 * @version 1.0
 */
public class GameActivity extends Activity {

    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);

        gameView = new GameView(this, displayMetrics.widthPixels, displayMetrics.heightPixels);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        overridePendingTransition(R.anim.slideinright, R.anim.slideoutright);

        setContentView(gameView);
        gameView.setGameActivity(this);
    }

    /**
     * Proceeds to the next scene (activity)
     */
    public void nextScene() {
        Intent waiting_room = new Intent(GameActivity.this, WaitingRoom.class);
        startActivity(waiting_room);
    }
}
