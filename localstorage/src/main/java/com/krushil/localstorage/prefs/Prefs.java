package com.krushil.localstorage.prefs;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {
    private static final String EMPLOYEE_USER="employee";
    private static final String EMPLOYEE_NAME="employee_name";
    private static final String EMPLOYEE_USERNAME="employee_username";

    public static void saveEmployee(Context context, String name){
        SharedPreferences sharedPreferences = context.getSharedPreferences(EMPLOYEE_USER,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(EMPLOYEE_NAME,name).apply();
    }

    public static String getEmployeeName(Context context){
        SharedPreferences sharedPreferences=context.getSharedPreferences(EMPLOYEE_USER,Context.MODE_PRIVATE);
        return sharedPreferences.getString(EMPLOYEE_NAME,"null");
    }

    public static void saveEmployeeUsername(Context context, String name){
        SharedPreferences sharedPreferences = context.getSharedPreferences(EMPLOYEE_USER,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(EMPLOYEE_USERNAME,name).apply();
    }

    public static String getEmployeeUsename(Context context){
        SharedPreferences sharedPreferences=context.getSharedPreferences(EMPLOYEE_USER,Context.MODE_PRIVATE);
        return sharedPreferences.getString(EMPLOYEE_USERNAME,"null");
    }
}
