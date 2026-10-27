package com.example.quanlythietbi.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ThietBi.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final String TEN_DATABASE = "quan_ly_thiet_bi.db";
    private static volatile AppDatabase instance;

    public abstract ThietBiDao thietBiDao();

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (AppDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            TEN_DATABASE
                    ).build();
                }
            }
        }
        return instance;
    }
}
