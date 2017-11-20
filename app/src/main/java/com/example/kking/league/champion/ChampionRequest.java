package com.example.kking.league.champion;

import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

/**
 * Created by kking on 10/20/2017.
 */

public class ChampionRequest<T> extends Request<T> {

    private Class<T> clazz;
    private Response.Listener<T> listener;



    public ChampionRequest(String url, Response.ErrorListener listener, Class<T> clazz, Response.Listener<T> l) {
        super(Method.GET, url, listener);
        this.clazz = clazz;
        this.listener = l;
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {

        try {
            Gson gson = new Gson();
            JSONObject jsonObj = new JSONObject();
            Log.i("STATUS", response.data.toString());
            String json = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            return Response.success(gson.fromJson(json, clazz), HttpHeaderParser.parseCacheHeaders(response));
        }catch (UnsupportedEncodingException e){
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(T response) {
        listener.onResponse(response);
    }
}
