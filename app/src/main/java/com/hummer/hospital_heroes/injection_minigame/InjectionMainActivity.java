package com.hummer.hospital_heroes.injection_minigame;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

<<<<<<< HEAD
import com.hummer.hospital_heroes.cream_minigame.GameView;
=======
import com.hummer.hospital_heroes.R;

>>>>>>> 6d080cd10476dda82d1f8f6c93f0e48c6c56ddf9

/**
 * InjectionMainActivity is the class of the game that represents the main activity. It builds
 * and displays the main activity and all other components.
 *
 * @author Fareed Faisal
 * @version 1.0
 */
public class InjectionMainActivity extends Activity
{
    private InjectionGamePanel gamePanel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);

        gamePanel = new InjectionGamePanel(this, displayMetrics.widthPixels, displayMetrics.heightPixels);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        InjectionConstants.SCREEN_WIDTH = dm.widthPixels;
        InjectionConstants.SCREEN_HEIGHT = dm.heightPixels;

        overridePendingTransition(R.anim.slideinright, R.anim.slideoutright);

        setContentView(gamePanel);
        gamePanel.setGameActivity(this);
    }

}
