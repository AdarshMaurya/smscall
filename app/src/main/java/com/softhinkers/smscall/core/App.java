package com.softhinkers.smscall.core;

import android.app.Application;
import android.content.Intent;

import com.softhinkers.smscall.CallSmsDetector;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CallSmsDetector.askForPermissions(this);
        CallSmsDetector.callDeviceAdmin(this);
        Intent intent = new Intent(this, CallSmsService.class);
        startService(intent);
    }
}
