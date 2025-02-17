package com.hummer.hospital_heroes;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Abstract class that sets up each screen's initial state
 * - Allows the background music to paused when the game is exited
 * - When the back button is pressed, a password prompt is shown to stop unauthorised users from leaving the app
 *
 * @author Fahim Mohammed
 * @version 1.2
 */
public abstract class AppActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (level == TRIM_MEMORY_UI_HIDDEN) {
            MusicService.stop();
        }
    }

    @Override
    public void onBackPressed() {
        LoginToApp loginToApp = LoginToApp.newInstance();
        loginToApp.show(getFragmentManager(), LoginToApp.TAG);
    }
}
