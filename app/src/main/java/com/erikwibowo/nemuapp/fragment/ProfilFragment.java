package com.erikwibowo.nemuapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erikwibowo.nemuapp.activity.Setting;
import com.erikwibowo.nemuapp.databinding.FragmentProfilBinding;

public class ProfilFragment extends BaseFragment {

    private FragmentProfilBinding binding;

    @Override
    public View onCreateView (LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState) {
        binding = FragmentProfilBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        initView();
        initListener();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        binding.textNotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Setting.class));
            }
        });
    }
}