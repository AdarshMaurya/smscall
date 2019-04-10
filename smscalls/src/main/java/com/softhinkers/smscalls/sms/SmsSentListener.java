package com.softhinkers.smscalls.sms;

/**
 * Created by Adarsh Maurya on 08-04-2019.
 */

public interface SmsSentListener {
    void onMessageSent(String number, String contactName, String messageText, long timestamp);
}
