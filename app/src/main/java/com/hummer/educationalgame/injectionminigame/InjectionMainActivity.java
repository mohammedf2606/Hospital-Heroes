package com.hummer.educationalgame.injectionminigame;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

import com.hummer.educationalgame.PreScan;

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

        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);

        gamePanel = new InjectionGamePanel(this, point.x, point.y);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        InjectionConstants.SCREEN_WIDTH = dm.widthPixels;
        InjectionConstants.SCREEN_HEIGHT = dm.heightPixels;

        setContentView(gamePanel);
        gamePanel.setGameActivity(this);
    }

}
