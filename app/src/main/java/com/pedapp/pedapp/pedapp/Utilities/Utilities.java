package com.pedapp.pedapp.pedapp.Utilities;

public class Utilities {

    public static String TABLE_CHALLENGE = "Challenge";
    public static String FIELD_ID = "ID";
    public static String FIELD_CHALLENGE = "CHALLENGE";
    public static String FIELD_CATEGORY = "CATEGORY";

    public static final String CREATE_TABLE_CHALLENGE = "CREATE TABLE " +
            "" + TABLE_CHALLENGE + " (" + FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            FIELD_CHALLENGE + " TEXT," + FIELD_CATEGORY + " INT)";
}
