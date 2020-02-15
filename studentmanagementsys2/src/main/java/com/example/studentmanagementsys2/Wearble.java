package com.example.studentmanagementsys2;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.widget.TextView;

public class Wearble extends WearableActivity {


    private WifiReceiver wifiReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wearble);

        wifiReceiver = new WifiReceiver();

        createNotificationChannel();

        // Enables Always-on
        setAmbientEnabled();
    }

    private void createNotificationChannel() {
        NotificationChannel notificationChannel = new NotificationChannel("chatmandu", "Wi-Fi Status", NotificationManager.IMPORTANCE_HIGH);
        notificationChannel.setDescription("Wifi Status Notification");

        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(notificationChannel);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(wifiReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(wifiReceiver);
    }
}
