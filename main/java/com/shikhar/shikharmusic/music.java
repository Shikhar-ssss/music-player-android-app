package com.shikhar.shikharmusic;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class music extends AppCompatActivity {

    ListView listView;

    List<String> list;

    ListAdapter adapter;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

         listView = (ListView) findViewById(R.id.ListView);

        list= new ArrayList<>();

        Field[] field = R.raw.class.getFields();
        for(int i=0;i<field.length;i++){
            list.add(field[i].getName());
        }




        adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                if (mediaPlayer != null){
                mediaPlayer.release();
            }
            int resID= getResources().getIdentifier(list.get(i),"raw",getPackageName());
            mediaPlayer = MediaPlayer.create(music.this,resID);
            mediaPlayer.start();

           }
        });
    }
}
