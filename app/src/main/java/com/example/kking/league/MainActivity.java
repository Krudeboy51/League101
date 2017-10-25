package com.example.kking.league;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kking.league.champion.ChampionHandler;

public class MainActivity extends AppCompatActivity {

    ChampionHandler championHandler;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        championHandler = new ChampionHandler(getApplicationContext());
        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              championHandler.getAllChampions("tags", new ChampionHandler.completion() {
//                  @Override
//                  public <T> void onSuccess(T res, Boolean isSuccess) {
//
//                  }
//              });
                championHandler.getChampion(62, new ChampionHandler.completion() {
                    @Override
                    public <T> void onSuccess(T res, Boolean isSuccess) {

                    }
                });
            }
        });
    }
}
