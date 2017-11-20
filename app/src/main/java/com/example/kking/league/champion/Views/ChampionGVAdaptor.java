package com.example.kking.league.champion.Views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kking.league.Constants;
import com.example.kking.league.R;
import com.example.kking.league.champion.championmodel.Champion;
import com.example.kking.league.champion.championmodel.Image;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kking on 10/27/2017.
 */

public class ChampionGVAdaptor extends BaseAdapter {

    private Context mContext;
    private ArrayList<Champion> championArrayList;

    public ChampionGVAdaptor(Context c, ArrayList<Champion> champList) {
        mContext = c;
        championArrayList = champList;
    }

    @Override
    public int getCount() {
        return championArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return championArrayList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View mView;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(view == null){
            mView = inflater.inflate(R.layout.champion_grid_view_item, null);
        } else {
            mView = (View) view;
        }
        String url = Constants.IMGLINK+championArrayList.get(i).getKey()+Constants.PNG;
        ImageView imageView = (ImageView) mView.findViewById(R.id.champion_item_img);
        Picasso.with(this.mContext).load(url).into(imageView);
        Log.i(championArrayList.get(i).getName(), url);
//        try {
//            ImageView imageView = (ImageView) mView.findViewById(R.id.champion_item_img);
//            //        imageView.setImageDrawable(LoadImageFromWebOperations(Constants.IMGLINK+
//            //        championArrayList.get(i).getKey()+Constants.PNG));
//            Bitmap bmp = BitmapFactory.decodeStream((InputStream) new URL(url).getContent());
//            imageView.setImageBitmap(bmp);
//        } catch (IOException e){
//
//        }
        TextView textView = mView.findViewById(R.id.champion_item_txt);
        textView.setText(championArrayList.get(i).getName());

        return mView;
    }

    public static Drawable LoadImageFromWebOperations(String url) {
        Log.i("IMG URL", url);
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }
}
