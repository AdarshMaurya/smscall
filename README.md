# SmsCall
It is an android application which listens for the below events: 
- incoming call started
- incoming call answered
- incoming call ended
- Out going call started
- Out going call
- Out going call ended
- Missed call
- Sms received
- Sms sent. 

`CallSmsService` extends `InfiniteService` which listens for the above cases which you can overide very easily.

As an example we have shown here that if there is a miss call from a specific number i.e `"check_for_number"`, then a sms with some message i.e `"send_message"` would be send to `"send_sms_to_contact"`.

Please make sure you have changed the below values for `"check_for_number"`,  `"send_message"`, `"send_sms_to_contact"`:

```html
<resources>
    <string name="check_for_number">999999998</string>
    <string name="send_sms_to_contact">999999999</string>
    <string name="send_message">"Missed call from "</string>
</resources>
```
