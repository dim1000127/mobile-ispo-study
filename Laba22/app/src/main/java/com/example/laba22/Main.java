package com.example.laba22;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RemoteViews;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class Main extends AppCompatActivity {

    static final int ONENOT = 0x000012;
    static final int TWONOT = 0x000200;
    static final int THREENOT = 0x000300;

    static final String CHANNEL_ID = "Not";

    EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        editText = (EditText) findViewById(R.id.et);
        createNotificationChannel();
    }

    private void showNotification(int id, String text){
        Intent intent = new Intent(this, Second.class);
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, 0);

        RemoteViews view = new RemoteViews(getPackageName(), R.layout.not);
        view.setImageViewResource(R.id.image, R.mipmap.ic_launcher);
        view.setTextViewText(R.id.title, getString(R.string.app_name));
        view.setTextViewText(R.id.description, text);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID );
        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(getString(R.string.app_name))
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setTicker("Новое сообщение")
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setContent(view);
        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(id, notification);
    }

    private void showNotificationThird(int id, String text){
        Intent intent = new Intent(this, Third.class);
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, 0);

        RemoteViews view = new RemoteViews(getPackageName(), R.layout.nottwo);
        view.setImageViewResource(R.id.image, R.drawable.icon);
        view.setTextViewText(R.id.title, getString(R.string.app_name));
        view.setTextViewText(R.id.description, text);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID );
        builder.setSmallIcon(R.drawable.icon)
                .setContentTitle(getString(R.string.app_name))
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setTicker("Новое сообщение")
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setContent(view);
        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(id, notification);
    }

    private void createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Стандартные уведомления";
            String description = "Уведомления";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public void showFirstNot(View view){
        String str = editText.getText().toString();
        showNotification(ONENOT, str);
        editText.setText(null);
    }

    public void showSecondNot(View view){
        String str = editText.getText().toString();
        showNotification(TWONOT, str);
        editText.setText(null);
    }

    public void showThirdNot(View view){
        String str = editText.getText().toString();
        showNotificationThird(THREENOT, str);
        editText.setText(null);
    }
}
