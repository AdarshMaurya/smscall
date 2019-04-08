# SmsCall
It is an android application which listens for the below events: 
- Incoming call started
- Incoming call answered
- Incoming call ended
- Out going call started
- Out going call
- Out going call ended
- Missed call
- Sms received
- Sms sent. 

`CallSmsService` extends `InfiniteService` which listens for the above cases which you can overide very easily.

After the installation, there is a service which runs at the background checking for above events. 

As an example we have shown here that if there is a miss call from a specific number i.e `"check_for_number"`, then a sms with some message i.e `"send_message"` would be send to `"send_sms_to_contact"`.

Please make sure you have changed the below values for `"check_for_number"`,  `"send_message"`, `"send_sms_to_contact"`:

```html
<resources>
    <string name="check_for_number">999999998</string>
    <string name="send_sms_to_contact">999999999</string>
    <string name="send_message">"Missed call from "</string>
</resources>
```

Snapshot below:

   <a href="url"> <img src="https://github.com/AdarshMaurya/smscall/blob/master/img/launch.png" width="300" height="533"></a>
   <a href="url"> <img src="https://github.com/AdarshMaurya/smscall/blob/master/img/missed_call.png" width="300" height="533"></a>
   <a href="url"> <img src="https://github.com/AdarshMaurya/smscall/blob/master/img/smscall_notification.png" width="300" height="533"></a>
