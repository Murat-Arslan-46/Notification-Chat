package com.marslan.notificationchat;

import android.app.Application;

import com.marslan.notificationchat.enums.ContentType;
import com.marslan.notificationchat.enums.MessageStatus;
import com.marslan.notificationchat.room.tables.EntityMessage;
import com.marslan.notificationchat.viewmodel.MainViewModel;
import com.onesignal.OSNotification;
import com.onesignal.OSNotificationOpenedResult;
import com.onesignal.OneSignal;

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
                OSNotification notification = result.getNotification();
                String data = notification.getAdditionalData().toString();
                String body = notification.getBody();
                String title = notification.getTitle();
                EntityMessage entityMessage = new EntityMessage(
                        0,
                        body,
                        "06/09/21 13:00",
                        "",
                        "",
                        MessageStatus.NOT_SENT,
                        ContentType.TEXT,
                        "none"
                );
                new MainViewModel(MainApplication.this).newMessage(entityMessage);
            }
        });
    }
}