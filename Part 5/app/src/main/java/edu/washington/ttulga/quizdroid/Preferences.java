package edu.washington.ttulga.quizdroid;

import android.app.AlarmManager;
import android.app.DownloadManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Preferences extends ActionBarActivity {
    private PendingIntent pendingIntent;
    private EditText url;
    private EditText timer;

    private long enqueue;
    private DownloadManager downloadManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        final Intent alarmIntent = new Intent(Preferences.this, AlarmReceiver.class);

        url = (EditText) findViewById(R.id.urlEdit);
        timer = (EditText) findViewById(R.id.timerEdit);

        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button.getText().equals("Start")) {
                    if (!url.getText().toString().trim().equals("") &&
                            !timer.getText().toString().trim().equals("")) {

                        button.setText("Stop");
                        start();
                    }
                } else {
                    button.setText("Start");
                    stop();
                }
            }
        });
    }

    public void stop() {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        manager.cancel(pendingIntent);
        pendingIntent.cancel();

        Toast.makeText(this, "Alarm stopped", Toast.LENGTH_SHORT).show();
    }

    public void start() {
        String myHTTPUrl = "http://tednewardsandbox.site44.com/questions.json";
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(myHTTPUrl));

        request.setTitle("quizdata.json");
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        //request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "quizdata.json");

        downloadManager = (DownloadManager) this.getSystemService(Context.DOWNLOAD_SERVICE);
        enqueue = downloadManager.enqueue(request);

        Toast.makeText(getApplicationContext(), "Questions downloaded from: " + myHTTPUrl, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_preferences, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
