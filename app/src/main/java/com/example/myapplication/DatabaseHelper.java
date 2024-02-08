package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "student_management";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_SCHEDULE = "schedule";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_SUBJECT = "subject";
    private static final String COLUMN_TYPE = "type";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_TIME = "time";

    private static final String TABLE_EXAMS = "exams";
    private static final String COLUMN_EXAM_ID = "exam_id";
    private static final String COLUMN_EXAM_SUBJECT = "subject";
    private static final String COLUMN_EXAM_DATE = "date";
    private static final String COLUMN_EXAM_TIME = "time";
    private static final String COLUMN_GRADE = "grade";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createScheduleTableQuery = "CREATE TABLE " + TABLE_SCHEDULE + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_SUBJECT + " TEXT, " +
                COLUMN_TYPE + " TEXT, " +
                COLUMN_DATE + " TEXT, " +
                COLUMN_TIME + " TEXT)";
        db.execSQL(createScheduleTableQuery);

        String createExamsTableQuery = "CREATE TABLE " + TABLE_EXAMS + " (" +
                COLUMN_EXAM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_EXAM_SUBJECT + " TEXT, " +
                COLUMN_EXAM_DATE + " TEXT, " +
                COLUMN_EXAM_TIME + " TEXT, " +
                COLUMN_GRADE + " TEXT)";
        db.execSQL(createExamsTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCHEDULE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXAMS);
        onCreate(db);
    }

    public boolean insertScheduleData(String subject, String type, String date, String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_SUBJECT, subject);
        contentValues.put(COLUMN_TYPE, type);
        contentValues.put(COLUMN_DATE, date);
        contentValues.put(COLUMN_TIME, time);
        long result = db.insert(TABLE_SCHEDULE, null, contentValues);
        return result != -1;
    }

    public boolean insertExamData(String subject, String date, String time, String grade) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_EXAM_SUBJECT, subject);
        contentValues.put(COLUMN_EXAM_DATE, date);
        contentValues.put(COLUMN_EXAM_TIME, time);
        contentValues.put(COLUMN_GRADE, grade);
        long result = db.insert(TABLE_EXAMS, null, contentValues);
        return result != -1;
    }

    public Cursor getAllScheduleData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_SCHEDULE, null);
    }

    public Cursor getAllExamData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_EXAMS, null);
    }
}
