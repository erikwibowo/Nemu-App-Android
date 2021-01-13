package com.erikwibowo.nemuapp.helper;

import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;

public class Setting {

    public void dark_mode(Context context){
        PrefManager prefManager = new PrefManager(context);
        if (prefManager.getString("dark_mode").equals("1")){
            prefManager.setString("dark_mode", "1");
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else if (prefManager.getString("dark_mode").equals("")){
            prefManager.setString("dark_mode", "");
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        }else {
            prefManager.setString("dark_mode", "0");
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    public void set_dark_mode(){

    }
}
