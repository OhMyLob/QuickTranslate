package com.lob.quicktranslate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class BootBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        if (settings.getBoolean("mustStartOnBoot", true)) {
            Intent startServiceIntent = new Intent(context, CopyService.class);
            context.startService(startServiceIntent);
        }
    }
}