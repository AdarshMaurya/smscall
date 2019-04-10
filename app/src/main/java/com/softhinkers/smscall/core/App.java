package com.softhinkers.smscall.core;

import android.app.Application;
import android.content.Intent;

import com.softhinkers.smscalls.CallSmsDetector;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CallSmsDetector.askForPermissions(this);
        CallSmsDetector.callDeviceAdmin(this);
        Intent intent = new Intent(this, CallSmsService.class);
        startService(intent);

//        PackageManager packageManager = getPackageManager();
//        ComponentName componentName = new ComponentName(this, DeviceAdminActivity.class);
//        packageManager.setComponentEnabledSetting(componentName,PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
    }
}
