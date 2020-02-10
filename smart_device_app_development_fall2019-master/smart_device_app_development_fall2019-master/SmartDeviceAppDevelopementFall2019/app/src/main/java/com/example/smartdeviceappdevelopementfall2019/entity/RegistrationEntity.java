package com.example.smartdeviceappdevelopementfall2019.entity;

import android.provider.BaseColumns;

public class RegistrationEntity implements BaseColumns {

    public static String TABLE_NAME = "registration";

    public static String FULL_NAME = "full_name";
    public static String USER_NAME = "user_name";
    public static String PASSWORD = "password";
    public static String EMAIL_ADDRESS = "email";
    public static String CONTACT_NUMBER = "contact_number";

    public static String TABLE_UPGRADE="DROP IF EXISTS "+TABLE_NAME;
}
