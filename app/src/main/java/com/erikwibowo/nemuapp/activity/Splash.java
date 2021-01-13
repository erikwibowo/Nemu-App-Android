package com.erikwibowo.nemuapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.erikwibowo.nemuapp.MainActivity;
import com.erikwibowo.nemuapp.helper.Setting;

public class Splash extends Activity {

    private Setting setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setting =  new Setting();
        setting.dark_mode(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //setelah loading maka akan langsung berpindah ke home activity
                Intent i = new Intent(Splash.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },1000);
    }
}
