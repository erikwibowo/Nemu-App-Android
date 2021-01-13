package com.erikwibowo.nemuapp.activity;

import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import com.erikwibowo.nemuapp.databinding.ActivitySettingBinding;
import com.erikwibowo.nemuapp.helper.PrefManager;

public class Setting extends BaseActivity {

    private ActivitySettingBinding binding;
    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initView();
        initListener();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void initView() {
        prefManager = new PrefManager(this);
        binding.switchDark.setChecked(prefManager.getString("dark_mode").equals("0") ? false:true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Pengaturan");
        binding.textNotif.setText(prefManager.getString("fcm_key"));
    }

    @Override
    public void initListener() {
        binding.switchDark.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    prefManager.setString("dark_mode", "1");
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }else {
                    prefManager.setString("dark_mode", "0");
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });
    }
}