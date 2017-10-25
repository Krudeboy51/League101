package com.example.kking.league.links;

import android.util.Log;

import com.android.volley.VolleyError;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kking on 10/20/2017.
 */

public class Links {

    private HashMap<String, String> linkparams;
    private String mainLink;
    private int id_ = 0;


    public static String HTTP_ = "https://";
    public static String ALLCHAMPIONLINK = "api.riotgames.com/lol/static-data/v3/champions?";
    public static String CHAMPIONBYIDLINK = "api.riotgames.com/lol/static-data/v3/champions/";

    public static String API_KEY = "RGAPI-c8183911-f646-4206-9010-f1a75c163438";

    protected String region = "na1."; //e.g. na1, ru

    public static String api_key = "api_key";

    public Links(){
        linkparams = new HashMap<>();
        addParams(api_key, API_KEY);
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

}
