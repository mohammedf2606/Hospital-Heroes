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

    public void nextScene() {
        Intent waiting_room = new Intent(GameActivity.this, WaitingRoom.class);
        startActivity(waiting_room);
    }
}
