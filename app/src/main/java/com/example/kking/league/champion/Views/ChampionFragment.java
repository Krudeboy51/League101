package com.example.kking.league.champion.Views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.kking.league.Constants;
import com.example.kking.league.R;
import com.example.kking.league.champion.ChampionHandler;
import com.example.kking.league.champion.championmodel.Champion;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChampionFragment extends Fragment {


    private GridView gv;
    private ArrayList<Champion> championList;
    private ChampionHandler championHandler;
    private ChampionGVAdaptor adaptor;
    private Gson gson;
    private Toolbar tb;


    public ChampionFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.champion_type, menu);
        MenuItem item = menu.findItem(R.id.champ_type_spnr);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_champion, container, false);

        tb = mView.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(tb);


        championHandler = new ChampionHandler(getContext(), Volley.newRequestQueue(getContext()));
        String tags = ChampionHandler.Tags.TAGS;

        gv = mView.findViewById(R.id.champion_gridview);

        championHandler.getAllChampions(tags, new ChampionHandler.completion() {
            @Override
            public void onSuccess(Champion champ, Boolean success) {

            }

            @Override
            public void onSuccess(ArrayList<Champion> champ, Boolean success) {
                if(success)
                    championList = champ;
                gv.setAdapter(new ChampionGVAdaptor(getContext(), championList));
                gv.setOnItemClickListener(gridViewListener);
            }

            @Override
            public void msg(String msg) {
                Log.i("LINK", msg);
            }
        });

        return mView;
    }

    AdapterView.OnItemClickListener gridViewListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Toast.makeText(getContext(), "Champion: "+championList.get(i).getName(), Toast.LENGTH_SHORT).show();
        }
    };

}
