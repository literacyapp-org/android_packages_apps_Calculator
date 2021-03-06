package com.android.calculator2.util;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by GSC on 12/11/2016.
 */
public class PlayerUtil {

    public static String RAW_FILE_EQUALS = "equals";

    public static final String[] NUMBER_RAW_FILES = new String[] {
            "digit_0",
            "digit_1",
            "digit_2",
            "digit_3",
            "digit_4",
            "digit_5",
            "digit_6",
            "digit_7",
            "digit_8",
            "digit_9"
    };

    public static void playRawFile(Context context, String rawFile) {
        int rawId = context.getResources().getIdentifier(rawFile, "raw", context.getPackageName());
        if (rawId != 0) {
            MediaPlayer mediaPlayer = MediaPlayer.create(context, rawId);
            mediaPlayer.start();
        }
    }

    public static void playResult(final Context context, final String result) {
        int rawId = context.getResources().getIdentifier(RAW_FILE_EQUALS, "raw", context.getPackageName());
        if (rawId != 0) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(context, rawId);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    playRawFile(context, result);
                }
            });
            mediaPlayer.start();
        }
    }
}
