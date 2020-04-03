package com.hummer.hospital_heroes;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;

public class SoundEffects {

    private static SoundPool soundPool;
    private static int[] sounds;
    private static AudioManager amg;

    static void initSounds(Context context){
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setLegacyStreamType(AudioManager.STREAM_MUSIC).build();
        soundPool = new SoundPool.Builder().setMaxStreams(6)
                .setAudioAttributes(audioAttributes).build();

        sounds = new int[4];

        sounds[0] = soundPool.load(context, R.raw.success_major, 1);
        sounds[1] = soundPool.load(context, R.raw.splattersound, 2);

        sounds[3] = soundPool.load(context, R.raw.creamappliedding, 4);

        sounds[2] = soundPool.load(context, R.raw.rocketcrash, 1);

        amg = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);

    }

    public static void playSound(int sound) {
        soundPool.play(sounds[sound], 1, 1, 0, 0, 1f);
    }

    public final void cleanUpIfEnd() {
        sounds = null;
        soundPool.release();
        soundPool = null;
    }
}
