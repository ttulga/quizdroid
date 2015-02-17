package edu.washington.ttulga.quizdroid;

import android.app.Application;
import android.util.Log;


/*
 * Created by mbmtuvshin on 2/16/15.
 */
public class QuizApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Log.i("QuizApp", "App is running");
        initializeSingletons();
    }

    protected void initializeSingletons() {
        MySingleton.initInstance();
    }

    public void customAppMethod() {
        //custom app method
    }


}
