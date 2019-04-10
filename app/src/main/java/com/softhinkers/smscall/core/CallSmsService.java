package com.softhinkers.smscall.core;

import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.util.Log;

import com.softhinkers.smscall.R;
import com.softhinkers.smscalls.call.CallListener;
import com.softhinkers.smscalls.call.PhoneCallReceiver;
import com.softhinkers.smscalls.services.InfiniteService;
import com.softhinkers.smscalls.sms.SmsObserver;
import com.softhinkers.smscalls.sms.SmsReceivedListener;
import com.softhinkers.smscalls.sms.SmsReceiver;
import com.softhinkers.smscalls.sms.SmsSentListener;

import java.io.File;
import java.util.Date;

public class CallSmsService extends InfiniteService {

    public int onStartCommand(Intent intent, int flags, int startId) {
        int ret = super.onStartCommand(intent, flags, startId);
        // to detect received sms
        SmsReceiver.setSmsReceivedListener(new SmsReceivedListener() {
            @Override
            public void onMessageReceived(String number, String contactName, String messageText, long timestamp) {
                Log.e("sms received from", number);
            }
        });

        // to detect sent sms
        SmsObserver.setSmsSentListener(new SmsSentListener() {
            @Override
            public void onMessageSent(String number, String contactName, String messageText, long timestamp) {
                Log.e("sms sent to", number);
            }
        });

        // to detect calls
        PhoneCallReceiver.setCallListener(new CallListener() {
            @Override
            public void onIncomingCallStarted(Context ctx, String number, Date start, String contactName) {
                Log.e("incoming started", number);
            }

            @Override
            public void onIncomingCallAnswered(Context ctx, String number, Date start, String contactName) {
                Log.e("incoming answered", number);
            }

            @Override
            public void onOutgoingCallStarted(Context ctx, String number, Date start, String contactName) {
                Log.e("outgoing started", number);
            }

            @Override
            public void onIncomingCallEnded(Context ctx, String number, Date start, Date end, File recordedFile) {
                Log.e("incoming ended", number);
            }

            @Override
            public void onOutgoingCallEnded(Context ctx, String number, Date start, Date end, File recordedFile) {
                Log.e("outgoing ended", number);
            }

            @Override
            public void onMissedCall(Context ctx, String number, Date start, String contactName) {
                Log.e("missed call", number);
                SmsManager smsManager = SmsManager.getDefault();
                if (number.contains(getString(R.string.check_for_number)))
                    smsManager.sendTextMessage(getString(R.string.send_sms_to_contact),
                            null,
                            getString(R.string.send_message) + contactName + " " + number,
                            null,
                            null);
            }
        });

        return ret;
    }
}
