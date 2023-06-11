package com.example.laba24;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.RemoteViews;

import androidx.core.app.NotificationCompat;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class MyApp extends Application {
    //private final List<String> notes = new ArrayList<>();
    private final List<Note> notes = new ArrayList<>();
    ToastHelper toast;
    static final int ADDNOT = 0x000012;
    static final int EDITNOT = 0x000200;
    static final String CHANNEL_ID = "Not";

    public MyApp() {
        super();
        notes.add(new Note("1", "Record 1", new Time(System.currentTimeMillis())));
        notes.add(new Note("2", "Record 2", new Time(System.currentTimeMillis())));
        /*notes.add("Record 1");
        notes.add("Record 2");*/
        toast = new ToastHelper(this);
    }

    public List<Note> getList(){
        return notes;
    }

    public void addNotes(Note str){
        notes.add(str);
        toast.show(getResources().getString(R.string.addTextToast));
        createNotificationChannel();
        showNotification(ADDNOT, "Запись добавлена", str.getName());
    }

    public void setItem(int id, Note str){
        notes.set(id, str);
        toast.show(getResources().getString(R.string.editTextToast));
        createNotificationChannel();
        showNotification(EDITNOT, "Запись изменена", str.getName());
    }

    private void showNotification(int id, String textAct, String text){
        Intent intent = new Intent(this, Main.class);
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, 0);

        RemoteViews view = new RemoteViews(getPackageName(), R.layout.not);
        view.setImageViewResource(R.id.image, R.drawable.icon);
        view.setTextViewText(R.id.title, getString(R.string.app_name));
        view.setTextViewText(R.id.name, textAct);
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
}
