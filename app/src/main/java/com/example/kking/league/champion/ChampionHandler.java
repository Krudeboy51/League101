package com.example.kking.league.champion;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.kking.league.Constants;
import com.example.kking.league.DBAdaptorClass;
import com.example.kking.league.champion.championmodel.Champion;
import com.google.gson.Gson;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


/**
 * Created by kking on 10/20/2017.
 */

public class ChampionHandler {

    private RequestQueue mReqQue;
    private String region;
    private Gson gson;
    private DBAdaptorClass mDbAdaptorClass;

    public ChampionHandler(Context c, RequestQueue que) {
        mReqQue = que;
        this.region = "na1";
        gson = new Gson();
        mDbAdaptorClass = new DBAdaptorClass(c);
    }

    public ChampionHandler(Context c, RequestQueue que, String region) {
        mReqQue = que;
        this.region = region;
        gson = new Gson();
        mDbAdaptorClass = new DBAdaptorClass(c);
    }

    public void getAllChampions(String tag, final completion c){
        String link = Constants.HTTP_+region+Constants.ALLCHAMPIONLINK+Constants.ALLCHAMPIONLINK+"tags=image&"+"tags="+tag+Constants.TG_API_KEY;
        c.msg(link);
        executeReq(link, new reqComplete() {
            @Override
            public void onSuccess(JSONObject jobj) {
                ArrayList<Champion> champList = new ArrayList<>();
                try {
                    jobj = jobj.getJSONObject("data");
                    Iterator<String> keys = jobj.keys();
                    while (keys.hasNext()){
                        champList.add(gson.fromJson(jobj.getJSONObject(keys.next()).toString(), Champion.class));
                    }
                    c.onSuccess(champList, true);
                }catch (JSONException e){
                   e.printStackTrace();
                    c.onSuccess(new ArrayList<Champion>(), false);
                }
            }
        });
    }

    public class Tags {
        public final static String ALL = "all";
        public final static String ALLYTIPS = "allytips";
        public final static String BLURB = "blurb";
        public final static String ENEMYTIPS = "enemytips";
        public final static String FORMAT = "format";
        public final static String IMAGE = "image";
        public final static String INFO = "info";
        public final static String KEYS = "keys";
        public final static String LORE = "lore";
        public final static String PARTYPE = "partype";
        public final static String PASSIVE = "passive";
        public final static String RECOMMENDED = "recommended";
        public final static String SKINS = "skins";
        public final static String SPELLS = "SPELLS";
        public final static String STATS = "stats";
        public final static String TAGS = "tags";
    }

    public interface completion{
        void onSuccess(Champion champ, Boolean success);
        void onSuccess(ArrayList<Champion> champ, Boolean success);
        void msg(String msg);
    }

    private interface reqComplete{
        void onSuccess(JSONObject jobj);
    }

    private void executeReq(final String link, final reqComplete c){

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                link,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        mDbAdaptorClass.insertData(link, response.toString());
                        c.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("VOLLEY ERROR", error.getMessage());
                    }
                }
        );
        String data = mDbAdaptorClass.getData(link);
        if(data == null)
            mReqQue.add(jsonObjectRequest);
        else {
            try {
                c.onSuccess(new JSONObject(data));
            } catch(JSONException e ){
                Log.e("JSON ERROR 'executeReq'", e.getMessage());
            }
        }
    }
}


