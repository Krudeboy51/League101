package com.example.kking.league;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kking.league.champion.ChampionHandler;

public class MainActivity extends AppCompatActivity {

    ChampionHandler championHandler;
   // private RequestHandler request;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(getApplicationContext(), HomeScreen.class);
        startActivity(i);
//        request = new RequestHandler(this);
//        request.getAllChampions(new RequestHandler.onRequestComplete() {
//            @Override
//            public void onCompletion(boolean isComplete) {
//                if(isComplete){

//                }else{
//                    Toast.makeText(getApplicationContext(), "Unable to get data", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        championHandler = new ChampionHandler(getApplicationContext());
//        btn = (Button) findViewById(R.id.button);
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////              championHandler.getAllChampions("tags", new ChampionHandler.completion() {
////                  @Override
////                  public <T> void onSuccess(T res, Boolean isSuccess) {
////
////                  }
////              });
//                championHandler.getChampion(62, new ChampionHandler.completion() {
//                    @Override
//                    public <T> void onSuccess(T res, Boolean isSuccess) {
//
//                    }
//                });
//            }
//        });
    }
}
