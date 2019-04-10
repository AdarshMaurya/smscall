package com.softhinkers.smscalls.sms;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;

import com.softhinkers.smscalls.CallSmsDetector;

/**
 * Created by Adarsh Maurya on 08-04-2019.
 */

public class SmsReceiver extends BroadcastReceiver {

    private static SmsReceivedListener mListener;

    @TargetApi(Build.VERSION_CODES.DONUT)
    @Override
    public void onReceive(Context context, Intent intent) {
        CallSmsDetector.startOutgoingSms(context);

        Bundle data = intent.getExtras();

        Object[] pdus = (Object[]) data.get("pdus");

        if (pdus != null) {
            for (Object pdu : pdus) {

                SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdu);
                String senderNum = currentMessage.getDisplayOriginatingAddress();

                String message = currentMessage.getDisplayMessageBody();

                long timestamp = currentMessage.getTimestampMillis();
                //String currentTime = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss", Locale.getDefault()).format(new Date(timestamp));

                String contactName = CallSmsDetector.retrieveContactName(context, senderNum);

                if (mListener != null)
                    mListener.onMessageReceived(senderNum, contactName, message, timestamp);
            }
        }
    }


    public static void setSmsReceivedListener(SmsReceivedListener smsListener) {
        mListener = smsListener;
    }
}
