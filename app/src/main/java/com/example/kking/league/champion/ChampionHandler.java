package com.example.kking.league.champion;

import android.content.Context;
import android.util.Log;
import android.util.LruCache;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.kking.league.links.ChampionLink;
import com.example.kking.league.links.Links;
import com.example.kking.league.champion.championmodel.Champion;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by kking on 10/20/2017.
 */

public class ChampionHandler {

    RequestQueue mReqQue;
    Links cLink;
    Gson gson;
    LruCache<String, JSONObject> cache;

    private static String CHAMPDATA = "champ_data";

    private HashMap<String, String> linkparams;
    private String mainLink;
    private int id_ = 0;


    public static String HTTP_ = "https://";
    public static String ALLCHAMPIONLINK = "api.riotgames.com/lol/static-data/v3/champions?";
    public static String CHAMPIONBYIDLINK = "api.riotgames.com/lol/static-data/v3/champions/";

    public static String API_KEY = "RGAPI-c8183911-f646-4206-9010-f1a75c163438";

    protected String region = "na1."; //e.g. na1, ru

    public static String api_key = "api_key";

    public ChampionHandler(Context c) {
        mReqQue = Volley.newRequestQueue(c);
        cLink = new ChampionLink();
        Log.i("LINK",cLink.getLink());
        gson = new Gson();
        cache = new LruCache<>(4*1024*1024);
        linkparams = new HashMap<>();
        addParams(api_key, API_KEY);
    }

    public void getAllChampions(String tag, final completion c){
        id_ = 0;
        addParams("tags", tag);
        Log.i("LINK",getLink());
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                cLink.getLink(),
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {


                        try {
                            JSONObject data = response.getJSONObject("data");
                            Iterator<String> keys = data.keys();
                            HashMap<String, JSONObject> list = new HashMap<>();
                            cache.put(CHAMPDATA, data);
                            while (keys.hasNext()) {
                                String key = keys.next();
                                JSONObject jobj = data.getJSONObject(key);
                                list.put(key, jobj);
                                Log.i(key, jobj.toString());
                            }

                            c.onSuccess(list,true);
                        } catch (JSONException e){
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }

        );

        checkCacheFirst(request, getLink());
        reset();

//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
//                Request.Method.GET,
//                cLink.getLink(),
//                null,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        System.out.println(response.toString());
//                        try {
//                            for(int i=0; i < response.length(); i++){
//                                JSONObject jobj = response.getJSONObject(i);
//                                Log.i("Object", "nun");
//                    Champion champion = gson.fromJson(jobj.toString(), Champion.class);
//                                c.onSuccess(null, "");
//                }
//    }catch (JSONException e){
//        e.printStackTrace();
//    }
//}
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                    }
//                }
//        ){
//            @Override
//            protected Response<JSONArray> parseNetworkResponse(NetworkResponse response) {
//                Log.i("NNETWORK", "RESPONSE");
//                try {
//                    String json = new String(
//                            response.data,
//                            HttpHeaderParser.parseCharset(response.headers));
//                    Log.i("DATA", json);
//                    JSONObject j = new JSONObject(json);
//                    JSONObject data = j.getJSONObject("data");
//                    Log.i("PARSED DATA", data.toString());
//
//                    Iterator<String> keys = data.keys();
//
//                    while (keys.hasNext()){
//                        Log.i("Keys", keys.next());
//                    }
//
//                    Type list = new TypeToken<List<Champion>>(){}.getType();
//                    List<Champion> champ = gson.fromJson(json, list);
//                    Log.i("LIST LENGTH", ""+champ.size());
//                }catch (UnsupportedEncodingException e){
//                    e.printStackTrace();
//                }catch (JSONException e){
//                    e.printStackTrace();
//                }
//                return super.parseNetworkResponse(response);
//            }
//
//            @Override
//            protected void deliverResponse(JSONArray response) {
//                for(int i = 0; i < response.length(); i++){
//
//                }
//                super.deliverResponse(response);
//            }
//        };


//        ChampionRequest<JSONObject> championRequest = new ChampionRequest<JSONObject>(
//                cLink.getLink(),
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        c.onSuccess(null, error.getMessage());
//                    }
//                },
//                JSONObject.class,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Log.i("RESPONSE", response.toString());
//                       //c.onSuccess(response, "Success");
//                    }
//                }
//        ){
//            @Override
//            protected Response parseNetworkResponse(NetworkResponse response) {
//                try {
//                    Gson gson = new Gson();
//                    String json = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
//
//                    Js
//                    JSONObject jsonObj = new JSONObject();
//
//
//
//                    Log.i("STATUS", json);
//
//                    return Response.success(gson.fromJson(json, JSONObject.class), HttpHeaderParser.parseCacheHeaders(response));
//                }catch (UnsupportedEncodingException e){
//                    return Response.error(new ParseError(e));
//                }
//            }
//        };

       // mReqQue.add(championRequest);
    }

//    public void getChampion(int id, String tag, final completion c){
//        cLink.addParams(cLink.tags,tag);
//        cLink.addParams("id",id+"");
//
//        ChampionRequest<Champion> championRequest = new ChampionRequest<>(
//                cLink.getLink(),
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        c.onSuccess(null, error.getMessage());
//                    }
//                },
//                Champion.class,
//                new Response.Listener<Champion>() {
//                    @Override
//                    public void onResponse(Champion response) {
//                        c.onSuccess(response, "Success");
//                    }
//                });
//
//
//    }

    public void getChampion(int id, completion c){
        id_ = id;
        addParams("tags", "all");
        String link = getLink();
        Log.i("LINK",link);

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                link,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("response", response.toString());
                        Champion champ = gson.fromJson(response.toString(), Champion.class);
                        Log.i("Champion", champ.getName());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );

        mReqQue.add(request);
    }

    public <T> void checkCacheFirst(Request<T> request, String tag){
        synchronized (cache) {
            if(cache.get(CHAMPDATA) == null) {
                mReqQue.add(request);
                Log.i("Data use", "not using cached info");
            }else{
                Log.i("Data use", "using cached info");
                JSONObject data = cache.get(CHAMPDATA);
                Iterator<String> keys = data.keys();
                HashMap<String, JSONObject> list = new HashMap<>();
                try {
                    while (keys.hasNext()) {
                        String key = keys.next();
                        JSONObject jobj = data.getJSONObject(key);
                        list.put(key, jobj);
                        //Log.i(key, jobj.toString());
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public  interface completion {
        <T> void onSuccess(T res, Boolean isSuccess);
    }

    public void addParams(String key, String val){
        linkparams.put(key,val);
    }


    public void setRegion(String r){
        region = r+".";
    }

    public String getLink(){
        if (id_ == 0)
            return HTTP_+region+ALLCHAMPIONLINK+convertLink(linkparams);
        return HTTP_+region+CHAMPIONBYIDLINK+id_+"?"+convertLink(linkparams);
    }


    public String convertLink(HashMap<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String,String> entry : params.entrySet()) {
            if (sb.length() > 0)
                sb.append("&");
            sb.append(entry.getKey()+"="+entry.getValue());
        }
        return sb.toString();
    }

    private void reset(){
        linkparams = new HashMap<>();
        linkparams.put(api_key, API_KEY);
        id_ = 0;
    }
}
