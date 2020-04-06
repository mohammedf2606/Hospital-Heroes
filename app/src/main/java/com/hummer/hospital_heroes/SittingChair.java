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

import com.hummer.hospital_heroes.cream_minigame.*;

/**
 * Class that represents the character sitting in the injection room
 *
 * @author Fahim Mohammed, Bleon Uka
 * @version 1.0
 */
public class SittingChair extends AppActivity implements View.OnClickListener {

    ImageButton cream;
    ImageView chair, parent;
    private AnimatorSet animatorSet;
    private LinearLayout halo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        setContentView(R.layout.sitting_chair);

        cream = findViewById(R.id.cream);
        cream.setOnClickListener(this);

        chair = findViewById(R.id.chair);
        chair.setImageResource(Constants.getPlayerChair());

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
         Intent cream_minigame = new Intent(SittingChair.this, MainMenuForGame.class);
         startActivity(cream_minigame);
    }
}
