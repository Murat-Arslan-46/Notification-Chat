package com.marslan.notificationchat;

import android.app.Application;

import com.marslan.notificationchat.room.EntityNotification;
import com.onesignal.OSNotificationOpenedResult;
import com.onesignal.OneSignal;

import org.json.JSONObject;

public class MainApplication extends Application {
    private static final String ONESIGNAL_APP_ID = "b4722c47-4c09-4ffb-a72e-21f43f41533b";

    @Override
    public void onCreate() {
        super.onCreate();
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);
        OneSignal.setNotificationOpenedHandler(new OneSignal.OSNotificationOpenedHandler() {
            @Override
            public void notificationOpened(OSNotificationOpenedResult result) {
                String data = result.getNotification().getAdditionalData().toString();
                String body = result.getNotification().getBody();
                String title = result.getNotification().getTitle();
                EntityNotification notification = new EntityNotification(0, body,title, data);
                new MainViewModel(MainApplication.this).newNotification(notification);
            }
        });
    }
}