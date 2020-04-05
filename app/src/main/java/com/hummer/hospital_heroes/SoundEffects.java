package com.hummer.hospital_heroes;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;

/**
 * Class that allows sound effects to be used throughout the app
 *
 * @author Fahim Mohammed
 * @version 1.0
 */
public class SoundEffects {

    private static SoundPool soundPool;
    private static int[] sounds;

    /**
     * Initialise a sound player with all the needed sounds
     * @param context where the sounds were initialised
     */
    static void initSounds(Context context){
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setLegacyStreamType(AudioManager.STREAM_MUSIC).build();
        soundPool = new SoundPool.Builder().setMaxStreams(6)
                .setAudioAttributes(audioAttributes).build();

        sounds = new int[4];

        sounds[0] = soundPool.load(context, R.raw.success_major, 1);
        sounds[1] = soundPool.load(context, R.raw.splattersound, 1);
        sounds[2] = soundPool.load(context, R.raw.rocketcrash, 1);
        sounds[3] = soundPool.load(context, R.raw.creamappliedding, 1);

    }

    /**
     * Play a sound effect
     * @param sound the sound effect to be used
     */
    public static void playSound(int sound) {
        soundPool.play(sounds[sound], 1, 1, 0, 0, 1f);
    }

    /**
     * Clean up after the app ends
     */
    static void cleanUpIfEnd() {
        sounds = null;
        soundPool.release();
        soundPool = null;
    }
}
