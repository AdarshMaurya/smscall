package com.softhinkers.smscalls.sms;

/**
 * Created by Adarsh Maurya on 08-04-2019.
 */

public interface SmsReceivedListener {
    void onMessageReceived(String number, String contactName, String messageText, long timestamp);
}
