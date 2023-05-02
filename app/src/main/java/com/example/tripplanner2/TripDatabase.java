//package com.example.tripplanner2;
//
//import android.content.Context;
//
//import androidx.room.Database;
//import androidx.room.Room;
//import androidx.room.RoomDatabase;
//
//@Database(entities = {TripModel.class}, version = 1)
//public abstract class TripDatabase extends RoomDatabase {
//
//    private static TripDatabase instance;
//
////    public abstract TripDao tripDao();
//
//    public static synchronized TripDatabase getInstance(Context context) {
//        if (instance == null) {
//            instance = Room.databaseBuilder(context.getApplicationContext(),
//                            TripDatabase.class, "trip_database")
//                    .fallbackToDestructiveMigration()
//                    .build();
//        }
//        return instance;
//    }
//}
