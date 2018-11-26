package com.pedapp.pedapp.pedapp.Utilities;

public class Utilities {

    public static String TABLE_PLAYERS= "PLAYERS";
    public static String FIELD_ID = "ID";
    public static String FIELD_NAME = "NAME";
    public static String FIELD_GENDER = "GENDER";

    public static final String CREATE_TABLE_PLAYERS= "CREATE TABLE " +
            "" + TABLE_PLAYERS + " (" + FIELD_ID + " INTEGER PRIMARY KEY," +
            FIELD_NAME + " TEXT," + FIELD_GENDER + " TEXT)";

    public static String TABLE_CHALLENGE = "CHALLENGE";
    public static String FIELD_CATEGORY = "CATEGORY";
    public static String FIELD_CHALLENGE = "CHALLENGE";
    public static String FIELD_FROMUSER = "FROMUSER";
    public static String FIELD_RESPOND = "RESPOND";

    public static final String CREATE_TABLE_CHALLENGE= "CREATE TABLE " +
            "" + TABLE_CHALLENGE + " (" + FIELD_CATEGORY + " INTEGER," + FIELD_CHALLENGE + " TEXT," + FIELD_RESPOND + " TEXT," +  FIELD_FROMUSER + " INTEGER)";




}
