package edu.washington.ttulga.quizdroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by mbmtuvshin on 2/23/15.
 */
public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String url = intent.getStringExtra("url");

        // For our recurring task, we'll just display a message
        Toast.makeText(context, "Questions downloaded from: " + url, Toast.LENGTH_SHORT).show();
    }
}
