package com.twistedplane.sealnote;

import android.app.Application;

public class SealnoteApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static String getPassword() {
        return "test123";
    }
}