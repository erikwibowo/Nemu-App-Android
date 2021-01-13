package com.erikwibowo.nemuapp.helper;

import android.util.Log;
import androidx.annotation.NonNull;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.firebase.messaging.FirebaseMessagingService;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
        Log.d("Token", s);
        send_token_to_server(s);
    }

    private void send_token_to_server(String s){
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, "http://192.168.42.254/test-notif-firebase/insert.php?token="+s, null,
            new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Log.d("Token", "Send token : "+s);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("Volley Error", error.toString());
                }
        });

        VolleySingleton.getInstance(this).addToRequestQueue(request);
    }
}
