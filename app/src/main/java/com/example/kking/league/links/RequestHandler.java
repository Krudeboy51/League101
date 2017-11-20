package com.example.kking.league.links;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.util.LruCache;

//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.JsonObjectRequest;
//import com.android.volley.toolbox.Volley;
//import com.example.kking.league.Constants;
//import com.example.kking.league.champion.championmodel.Champion;
//import com.google.gson.Gson;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//
///**
// * Created by kking on 10/27/2017.
// */
//
//public class RequestHandler implements Parcelable{
//
//    private String region = "na1";
//
//    //Private Objects
//    private LruCache<String, JSONObject> cache;
//    private RequestQueue mReqQue;
//    private Gson gson;
//
//    //DATA OBJECTS
//    public ArrayList<Champion> ChampionList;
//
//
//    public void getAllChampions(final onRequestComplete requestComplete){
//        HashMap<String, String> params = new HashMap<>();
//        params.put("tags","tags");
//        final String link = Constants.HTTP_+getRegion()+ Constants.ALLCHAMPIONLINK+convertLink(params);
//        JsonObjectRequest request = new JsonObjectRequest(
//                Request.Method.GET,
//                link,
//                null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            JSONObject data = response.getJSONObject("data");
//                            cache.put(link, data);
//                            Iterator<String> keys = data.keys();
//                            while (keys.hasNext()){
//                                JSONObject json = data.getJSONObject(keys.next());
//                                JsonObject jobj = (JsonObject) new JsonParser().parse(json.toString());
//                                Champion temp = gson.fromJson(jobj,Champion.class);
//                                ChampionList.add(temp);
//                                Log.i("Champion", temp.getName());
//                                requestComplete.onCompletion(true);
//                            }
//                        }catch (JSONException e){
//                            requestComplete.onCompletion(true);
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                    }
//                }
//        );
//
//        mReqQue.add(request);
//    }
//
//
//
//    public RequestHandler(RequestQueue r){
//       // mReqQue = Volley.newRequestQueue(ge);
//        cache = new LruCache<>(8*1024*1024);
//        gson = new Gson();
//        ChampionList = new ArrayList<>();
//    }
//
//    public void getAllData(final onRequestComplete complete){
//        getAllChampions(new onRequestComplete() {
//            @Override
//            public void onCompletion(boolean isComplete) {
//                complete.onCompletion(isComplete);
//            }
//        });
//    }
//
//    public void setRegion(String region){
//        this.region = region;
//    }
//
//    public String getRegion(){
//        return region;
//    }
//
//    private String convertLink(HashMap<String, String> params) {
//        StringBuilder sb = new StringBuilder();
//        for (Map.Entry<String,String> entry : params.entrySet()) {
//            if (sb.length() > 0)
//                sb.append("&");
//            sb.append(entry.getKey() + "=" + entry.getValue());
//        }
//        sb.append("&api_key=" + Constants.API_KEY);
//        return sb.toString();
//    }
//
//    public interface onRequestComplete {
//        void onCompletion(boolean isComplete);
//    }
//
//    @Override
//    public void writeToParcel(Parcel parcel, int i) {
//        Bundle b = new Bundle();
//        //b.putParcelableArrayList("Champions", ChampionList);
//        parcel.writeBundle(b);
//    }
//
//    public static final Parcelable.Creator<RequestHandler> CREATOR = new Creator<RequestHandler>() {
//        @Override
//        public RequestHandler createFromParcel(Parcel parcel) {
//            RequestHandler r = new RequestHandler(null);
//
//            return null;
//        }
//
//        @Override
//        public RequestHandler[] newArray(int i) {
//            return new RequestHandler[0];
//        }
//    }
//}
