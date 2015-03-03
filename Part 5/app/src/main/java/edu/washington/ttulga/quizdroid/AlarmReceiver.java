package edu.washington.ttulga.quizdroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import android.app.DownloadManager;
import android.os.Bundle;
import android.app.Activity;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.os.Environment;

/**
 * Created by mbmtuvshin on 2/23/15.
 */
public class AlarmReceiver extends BroadcastReceiver {
    private long enqueue;
    private DownloadManager downloadManager;
    private String url;


    public void onReceive(Context context, Intent intent) {
        /*url = intent.getStringExtra("url");
        Toast.makeText(context, "url: " + url, Toast.LENGTH_SHORT).show();
        downloadManager = (DownloadManager)context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri Download_Uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(Download_Uri);

        request.setTitle("Downloading file...");
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "quizdata.json");

        //Enqueue a new download and same the referenceId
        enqueue = downloadManager.enqueue(request);

        Toast.makeText(context, "Questions downloaded from: " + url, Toast.LENGTH_SHORT).show();
        */
    }
}
