package com.hummer.hospital_heroes;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Class that represents the injection room screen
 *
 * @author Fahim Mohammed, Bleon Uka
 * @version 1.2
 */
public class InjectionRoom extends AppActivity implements View.OnClickListener {

    ImageButton chair;
    ImageView character, parent;
    LinearLayout halo;
    AnimatorSet animatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        setContentView(R.layout.injection_room);

        character = findViewById(R.id.character);
        character.setImageResource(Constants.getPlayerStanding());

        chair = (ImageButton) findViewById(R.id.chair);
        chair.setOnClickListener(this);

        parent = (ImageView) findViewById(R.id.parent);
        if(Constants.isBlack()) {
            parent.setImageResource(R.drawable.mother_black);
        } else {
            parent.setImageResource(R.drawable.mother_white);
        }

        halo = (LinearLayout) findViewById(R.id.halo);
        animatorSet = new AnimatorSet();

        ObjectAnimator fadeAway = ObjectAnimator.ofFloat(halo, "alpha",0.5f,0.1f);
        fadeAway.setDuration(500);

        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(halo, "alpha",0.1f,0.5f);
        fadeIn.setDuration(500);

        animatorSet.play(fadeIn).after(fadeAway);

        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                animatorSet.start();
            }
        });

        animatorSet.start();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.chair:
                Intent sitting_chair = new Intent(InjectionRoom.this, SittingChair.class);
                startActivity(sitting_chair);
        }
    }
}
