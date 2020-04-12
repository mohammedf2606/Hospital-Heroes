package com.hummer.hospital_heroes.injection_minigame;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import com.hummer.hospital_heroes.AppActivity;
import com.hummer.hospital_heroes.Constants;
import com.hummer.hospital_heroes.R;

/**
 * InjectionMainActivity is the class of the game that represents the main activity. It builds
 * and displays the main activity and all other components.
 *
 * @author Fareed Faisal
 * @version 1.0
 */
public class InjectionMainActivity extends AppActivity
{
    private InjectionGamePanel gamePanel;

    public InjectionGamePanel getGamePanel() {
        return gamePanel;
    }

    /**
     *  create the activity that displays the game activity on the screen
     * @param savedInstanceState the bundle of the activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        gamePanel = new InjectionGamePanel(this, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        InjectionConstants.SCREEN_WIDTH = dm.widthPixels;
        InjectionConstants.SCREEN_HEIGHT = dm.heightPixels;

        overridePendingTransition(R.anim.slideinright, R.anim.slideoutright);

        setContentView(gamePanel);
        gamePanel.setGameActivity(this);
    }

}
