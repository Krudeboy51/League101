package com.example.kking.league.links;

import android.util.Log;

import java.util.HashMap;

/**
 * Created by kking on 10/20/2017.
 */

public class ChampionLink extends Links {


    public ChampionLink(){
        linkparams = new HashMap<String, String>();
        addParams(api_key, super.api_key);
    }


    public String getLink(){
        return MAINLINK+convertLink(linkparams);
    }


}
