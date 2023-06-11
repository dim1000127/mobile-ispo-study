package com.example.laba27;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.provider.BaseColumns;
import android.widget.RemoteViews;

import androidx.core.app.NotificationCompat;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class MyApp extends Application {
    //private final List<String> notes = new ArrayList<>();
    private final List<Note> notes = new ArrayList<>();
    ToastHelper toast;
    private DbHelper dbHelper;
    private Cursor cursor;
    static final int ADDNOT = 0x000012;
    static final int EDITNOT = 0x000200;
    static final String CHANNEL_ID = "Not";

    public MyApp() {
        super();
        toast = new ToastHelper(this);
        dbHelper = new DbHelper(this);
    }

    public void setNotes(List<Note> notes){
        if(notes != null) {
            notes.clear();
        }
        loadNotes();
        if(cursor.moveToFirst()){
            do{
                notes.add(
                        new Note(
                                cursor.getString(cursor.getColumnIndex(DbHelper.Tests.COLUMN_NAME)),
                                cursor.getString(cursor.getColumnIndex(DbHelper.Tests.COLUMN_TEXT)),
                                Time.valueOf(cursor.getString(cursor.getColumnIndex(DbHelper.Tests.COLUMN_TIME)))
                        )
                );
            }while (cursor.moveToNext());
        }
    }

    public void addNotes(Note note){
        DbHelper.Tests.insertTest(dbHelper.getWritableDatabase(), note);
        toast.show(getResources().getString(R.string.addTextToast));
        createNotificationChannel();
        showNotification(ADDNOT, "Запись "+note.getName()+" добавлена", note.getContent());
        loadNotes();
    }

    public void setItem(int id, Note note){
        DbHelper.Tests.updTest(dbHelper.getWritableDatabase(), String.valueOf(id), note);
        toast.show(getResources().getString(R.string.editTextToast));
        createNotificationChannel();
        showNotification(EDITNOT, "Запись "+note.getName()+" изменена", note.getContent());
        loadNotes();
    }

    public void loadNotes() {
        cursor = dbHelper.getReadableDatabase().rawQuery(
                String.format(
                        "SELECT * FROM %s",
                        DbHelper.Tests.TABLE_NAME
                ), null);
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
