//package com.example.tripplanner2;
//
//import android.content.Context;
//
//import androidx.room.Database;
//import androidx.room.Room;
//import androidx.room.RoomDatabase;
//
//@Database(entities = {TripModel.class}, version = 1)
//public abstract class AppDatabase extends RoomDatabase {
//
////    public abstract TripDao tripDao();
//
//    private static AppDatabase sInstance;
//
//    public static synchronized AppDatabase getInstance(Context context) {
//        if (sInstance == null) {
//            sInstance = Room.databaseBuilder(context.getApplicationContext(),
//                            AppDatabase.class, "app_database").allowMainThreadQueries().build();
//        }
//        return sInstance;
//    }
//}
