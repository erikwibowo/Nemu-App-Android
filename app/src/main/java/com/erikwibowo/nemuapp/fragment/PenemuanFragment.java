package com.erikwibowo.nemuapp.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.erikwibowo.nemuapp.adapter.AdapterUser;
import com.erikwibowo.nemuapp.databinding.FragmentPenemuanBinding;
import com.erikwibowo.nemuapp.helper.ServerApi;
import com.erikwibowo.nemuapp.helper.VolleySingleton;
import com.erikwibowo.nemuapp.model.ModelUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PenemuanFragment extends BaseFragment {

    private FragmentPenemuanBinding binding;

    AdapterUser mAdapter;
    List<ModelUser> mItems;
    Integer halaman = 1;

    @Override
    public View onCreateView (LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState) {
        binding = FragmentPenemuanBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        initView();
        initListener();
        getData();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void initView() {
        mItems = new ArrayList<>();
        mAdapter = new AdapterUser(mItems, getContext());
        binding.recycle.setAdapter(mAdapter);
    }

    @Override
    public void initListener() {
        binding.swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mItems.clear();
                getData();
                binding.swipe.setRefreshing(false);
            }
        });
    }

    private void getData(){
        binding.recycle.setVisibility(View.GONE);
        binding.shimmer.setVisibility(View.VISIBLE);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, ServerApi.user+halaman.toString(), null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        binding.recycle.setVisibility(View.VISIBLE);
                        binding.shimmer.setVisibility(View.GONE);
                        try {
                            JSONArray data = response.getJSONArray("data");
                            Log.d("volley", "response : "+data.toString());
                            for (int i = 0; i < data.length(); i++){
                                JSONObject item = data.getJSONObject(i);
                                ModelUser md = new ModelUser();
                                md.setId(item.getString("id"));
                                md.setEmail(item.getString("email"));
                                md.setFirst_name(item.getString("first_name"));
                                md.setLast_name(item.getString("last_name"));
                                md.setAvatar(item.getString("avatar"));
                                mItems.add(md);
                            }
                            mAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("volley", "response : "+error.toString());
                        binding.recycle.setVisibility(View.GONE);
                        binding.shimmer.setVisibility(View.GONE);
                    }
                });
        VolleySingleton.getInstance(getContext()).addToRequestQueue(request);
    }
}