package com.example.tripplanner2;
//
//import android.annotation.SuppressLint;
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TripDatabaseHelper extends SQLiteOpenHelper {
//
//    private static final String DATABASE_NAME = "trips.db";
//    private static final int DATABASE_VERSION = 1;
//
//    public static final String TABLE_TRIPS = "trips";
//    public static final String COLUMN_ID = "_id";
//    public static final String COLUMN_LOCATION = "location";
//    public static final String COLUMN_START_DATE = "start_date";
//    public static final String COLUMN_END_DATE = "end_date";
//
//    public static final String CREATE_TABLE_TRIPS =
//            "CREATE TABLE " + TABLE_TRIPS + "("
//                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
//                    + COLUMN_LOCATION + " TEXT NOT NULL, "
//                    + COLUMN_START_DATE + " TEXT NOT NULL, "
//                    + COLUMN_END_DATE + " TEXT NOT NULL"
//                    + ")";
//
//    public TripDatabaseHelper(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(CREATE_TABLE_TRIPS);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRIPS);
//        onCreate(db);
//    }
//
//    public long addTrip(Trip trip) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_LOCATION, trip.getLocation());
//        values.put(COLUMN_START_DATE, trip.getStartDate());
//        values.put(COLUMN_END_DATE, trip.getEndDate());
//
//        long id = db.insert(TABLE_TRIPS, null, values);
//        db.close();
//        return id;
//    }
//
//    @SuppressLint("Range")
//    public List<Trip> getAllTrips() {
//        List<Trip> trips = new ArrayList<>();
//
//        String selectQuery = "SELECT  * FROM " + TABLE_TRIPS;
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                Trip trip = new Trip();
//                trip.setId((int) cursor.getLong(cursor.getColumnIndex(COLUMN_ID)));
//                trip.setLocation(cursor.getString(cursor.getColumnIndex(COLUMN_LOCATION)));
//                trip.setStartDate(cursor.getString(cursor.getColumnIndex(COLUMN_START_DATE)));
//                trip.setEndDate(cursor.getString(cursor.getColumnIndex(COLUMN_END_DATE)));
//                trips.add(trip);
//            } while (cursor.moveToNext());
//        }
//
//        cursor.close();
//        db.close();
//
//        return trips;
//    }
//
//    public void updateTrip(Trip trip) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_LOCATION, trip.getLocation());
//        values.put(COLUMN_START_DATE, trip.getStartDate());
//        values.put(COLUMN_END_DATE, trip.getEndDate());
//
//        db.update(TABLE_TRIPS, values, COLUMN_ID + " = ?",
//                new String[] { String.valueOf(trip.getId()) });
//
//        db.close();
//    }
//
//    public void deleteTrip(long tripId) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_TRIPS, COLUMN_ID + " = ?",
//                new String[] { String.valueOf(tripId) });
//        db.close();
//    }
//}
//

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class TripDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "trips.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_EVENTS = "events";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_LOCATION = "location";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_START_DATE = "start_date";
    private static final String COLUMN_END_DATE = "end_date";

    private static final String CREATE_TABLE_EVENTS = "CREATE TABLE " + DATABASE_NAME + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_NAME + " TEXT," +
            COLUMN_LOCATION + " TEXT," +
            COLUMN_START_DATE + " INTEGER," +
            COLUMN_END_DATE + " INTEGER" +
            ")";

    public TripDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_EVENTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENTS);
        onCreate(db);
    }

    public boolean insert(TripModel tripModel) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, tripModel.getEndDate());
        values.put(COLUMN_LOCATION, tripModel.getLocation());
        values.put(COLUMN_START_DATE, tripModel.getStartDate());
        values.put(COLUMN_END_DATE, tripModel.getEndDate());
        long insert = database.insert(TABLE_EVENTS, null, values);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    public List<TripModel> getAllTrips() {
        List<TripModel> tripList = new ArrayList<>();

        String queryString = "SELECT * FROM " + DATABASE_NAME;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor != null && cursor.moveToFirst()) {
//            do {
//                int idIndex = cursor.getColumnIndex(COLUMN_ID);
//                int locationIndex = cursor.getColumnIndex(COLUMN_LOCATION);
//                int startDateIndex = cursor.getColumnIndex(COLUMN_START_DATE);
//                int endDateIndex = cursor.getColumnIndex(COLUMN_END_DATE);
//
//                if (idIndex >= 0 && locationIndex >= 0 && startDateIndex >= 0 && endDateIndex >= 0) {
//                    int id = cursor.getInt(idIndex);
//                    String location = cursor.getString(locationIndex);
//                    String startDate = cursor.getString(startDateIndex);
//                    String endDate = cursor.getString(endDateIndex);
//                    tripList.add(new TripModel(id, location, startDate, endDate));
//                }
//            } while (cursor.moveToNext());
            if (cursor.moveToFirst()) {
                do {
                    int id = cursor.getInt(0);
                    String name = cursor.getString(1);
                    String location = cursor.getString(1);
                    String startDate = cursor.getString(1);
                    String endDate = cursor.getString(1);
                    tripList.add(new TripModel(id, name, location, startDate, endDate));
                } while (cursor.moveToFirst());
            } else {

            }
        }
        assert cursor != null;
        cursor.close();
        db.close();
        return tripList;
    }
//
//    public void deleteTrip(int id) {
//        SQLiteDatabase db = getWritableDatabase();
//        db.delete(TABLE_EVENTS, COLUMN_ID + "=?", new String[]{String.valueOf(id)});
//        db.close();
//    }

//    public boolean isAdd(TripModel model) {
//        SQLiteDatabase database = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_LOCATION, model.getLocation());
//        values.put(COLUMN_START_DATE, model.getStartDate());
//        values.put(COLUMN_END_DATE, model.getEndDate());
//        long insert = database.insert(TABLE_EVENTS, null, values);
//        return insert != -1;
//    }
}
