package com.hummer.educationalgame.CreamMinigame;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.hummer.educationalgame.MainMenu;
import com.hummer.educationalgame.R;
import com.hummer.educationalgame.WaitingRoom;

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

        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);

        gameView = new GameView(this, point.x, point.y);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

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
