package com.softhinkers.smscalls.reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.softhinkers.smscalls.services.InfiniteService;

/**
 * Created by admin on 08-04-2019.
 */

public class RestartReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //Log.e("RestartReceiver", "broadcast received");
        context.startService(new Intent(context.getApplicationContext(), InfiniteService.class));
    }
}
