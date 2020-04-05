package com.hummer.hospital_heroes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Class that represents the end screen of the game
 *
 * @author Fahim Mohammed
 * @version 1.0
 */
public class EndScreen extends AppActivity implements View.OnClickListener {

    ImageView character;
    ImageButton restart, quit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_screen);

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        character = findViewById(R.id.character);
        character.setImageResource(Constants.getPlayerStanding());

        restart = findViewById(R.id.restart);
        restart.setOnClickListener(this);

        quit = findViewById(R.id.quit);
        quit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.restart:
                stopService(new Intent(EndScreen.this, MusicService.class));
                Intent start_again = new Intent(EndScreen.this, MainMenu.class);
                startActivity(start_again);
                break;
            case R.id.quit:
                stopService(new Intent(EndScreen.this, MusicService.class));
                finishAndRemoveTask();
                break;
        }
    }
}
