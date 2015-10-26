package com.joaopedroguimaraes.stalk;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.joaopedroguimaraes.stalk.service.CapPhoto;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent service;

        Calendar cal = Calendar.getInstance();

        service = new Intent(getBaseContext(), CapPhoto.class);
        cal.add(Calendar.SECOND, 15);
        //TAKE PHOTO EVERY 15 SECONDS
        PendingIntent pendingIntent = PendingIntent.getService(this, 0, service, 0);
        AlarmManager alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        alarm.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),
                60*60*1000, pendingIntent);
        startService(service);
    }
}
