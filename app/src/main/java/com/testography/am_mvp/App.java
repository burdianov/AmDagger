package com.testography.am_mvp;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.testography.am_mvp.di.components.AppComponent;

public class App extends Application {
    private static SharedPreferences sSharedPreferences;
    private static Context sAppContext;

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }

    private static AppComponent sAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        createComponent();

        sSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        sAppContext = getApplicationContext();
    }

    private void createComponent() {
//        sAppComponent
    }

    public static SharedPreferences getSharedPreferences() {
        return sSharedPreferences;
    }

    public static Context getAppContext() {
        return sAppContext;
    }
}
