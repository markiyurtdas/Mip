package com.marki.mipan;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class StockAPI {
    public void stockApiHisse(Context mContext) {
        RequestQueue queue = Volley.newRequestQueue(mContext);


        final String url = "https://api.collectapi.com/economy/hisseSenedi";
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONObject query = new JSONObject((response));

                            JSONArray arr = query.getJSONArray("result");
                            Log.i("hisse", "0: " + arr.getString(0) + "5: " + arr.getString(5) + "6: " + arr.getString(6));

                        } catch (JSONException e) {
                            e.printStackTrace();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json; charset=UTF-8");
                params.put("Authorization", "apikey 51GJK53AEhi3Fi9mxMbcc1:54A6X1enR9GHg4csXYixs2");

                return params;
            }
        };
        queue.add(request);
    }

    public void stockApiDoviz(Context mContext) {
        RequestQueue queue = Volley.newRequestQueue(mContext);


        final String url = "https://api.collectapi.com/economy/allCurrency";
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONObject query = new JSONObject((response));

                            JSONArray arr = query.getJSONArray("result");
                            Log.i("döviz", "dolar " + arr.getString(0) + "euro " + arr.getString(1) + "sterlin " + arr.getString(2));

                        } catch (JSONException e) {
                            e.printStackTrace();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json; charset=UTF-8");
                params.put("Authorization", "apikey 51GJK53AEhi3Fi9mxMbcc1:54A6X1enR9GHg4csXYixs2");

                return params;
            }
        };
        queue.add(request);
    }

    public void stockApiAltin(Context mContext) {

        RequestQueue queue = Volley.newRequestQueue(mContext);


        final String url = "https://api.collectapi.com/economy/goldPrice";
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONObject query = new JSONObject((response));

                            JSONArray arr = query.getJSONArray("result");
                            Log.i("Altın", "GramAltınAlışSatış " + arr.getString(5));

                        } catch (JSONException e) {
                            e.printStackTrace();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json; charset=UTF-8");
                params.put("Authorization", "apikey 51GJK53AEhi3Fi9mxMbcc1:54A6X1enR9GHg4csXYixs2");

                return params;
            }
        };
        queue.add(request);


    }
}
