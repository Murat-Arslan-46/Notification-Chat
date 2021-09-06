package com.marslan.notificationchat.services;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import com.onesignal.OSMutableNotification;
import com.onesignal.OSNotification;
import com.onesignal.OSNotificationReceivedEvent;
import com.onesignal.OneSignal;

import org.json.JSONObject;

import java.math.BigInteger;

@SuppressWarnings("unused")
public class NotificationServiceExtension implements OneSignal.OSRemoteNotificationReceivedHandler {

    @Override
    public void remoteNotificationReceived(Context context, OSNotificationReceivedEvent notificationReceivedEvent) {
        OSNotification notification = notificationReceivedEvent.getNotification();
        OSMutableNotification mutableNotification = notification.mutableCopy();
        mutableNotification.setExtender(builder -> {
            builder.setColor(new BigInteger("FF0000", 16).intValue());
            Spannable spannableTitle = new SpannableString(notification.getTitle());
            spannableTitle.setSpan(new ForegroundColorSpan(Color.RED),0,notification.getTitle().length(),0);
            builder.setContentTitle(spannableTitle);
            Spannable spannableBody = new SpannableString(notification.getBody());
            spannableBody.setSpan(new ForegroundColorSpan(Color.BLUE),0,notification.getBody().length(),0);
            builder.setContentText(spannableBody);
            builder.setTimeoutAfter(30000);
            return builder;
        });
        JSONObject json = notification.getAdditionalData();
        Log.i("OneSignalExample", "Received Notification Data: " + json);
        notificationReceivedEvent.complete(mutableNotification);
    }
}