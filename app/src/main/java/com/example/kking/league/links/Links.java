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

    protected HashMap<String, String> linkparams;

    public static String HTTP_ = "https://";
    public static String MAINLINK = "https://na1.api.riotgames.com/lol/static-data/v3/champions?";


    public static String API_KEY = "RGAPI-43dca792-7b38-4694-9216-47f2f13460c3";

    private String region; //e.g. na1, ru

    //QUERY ITEMS
    public static String locale = "locale";
    public static String tags = "tags";
    public static String dataById = "dataById";
    public static String api_key = "api_key";


    public void addParams(String key, String val){
        linkparams.put(key,val);
    }

    public void setLocale(String locale) {
        this.addParams(ChampionLink.locale,locale);
    }

    public void setTags(String tags) {
        this.addParams(ChampionLink.tags,tags);
    }

    public void setDataById(String dataById) {
        this.addParams(ChampionLink.dataById,dataById);
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
