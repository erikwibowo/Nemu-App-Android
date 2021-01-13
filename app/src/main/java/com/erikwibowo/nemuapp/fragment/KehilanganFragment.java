package com.erikwibowo.nemuapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erikwibowo.nemuapp.databinding.FragmentKehilanganBinding;

public class KehilanganFragment extends BaseFragment {

    private FragmentKehilanganBinding binding;

    @Override
    public View onCreateView (LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState) {
        binding = FragmentKehilanganBinding.inflate(inflater, container, false);
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

    }
}