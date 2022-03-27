package com.example.filmlercalismasii123123;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.filmlercalismasii123123.dao.DatabaseCopyHelper;
import com.example.filmlercalismasii123123.dao.FilmlerDao;
import com.example.filmlercalismasii123123.dao.VeritabaniYardimcisi;
import com.example.filmlercalismasii123123.objects.Filmler;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    VeritabaniYardimcisi vt = new VeritabaniYardimcisi(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kopyala();

        ArrayList<Filmler> gelenFilmler = new FilmlerDao().tumFilmler(vt);

        for(Filmler f:gelenFilmler){
            Log.e("*******","***********");
            Log.e("film_id",String.valueOf(f.getFilm_id()));
            Log.e("film_ad",f.getFilm_ad());
            Log.e("film_resim",f.getFilm_resim());
            Log.e("film_yil",String.valueOf(f.getFilm_yil()));
            Log.e("film_kategori",String.valueOf(f.getKategori().getKategori_ad()));
            Log.e("film_yonetmen",String.valueOf(f.getYonetmen().getYonetmen_ad()));

            Log.e("*******","***********");
        }

    }

    public void kopyala(){
        DatabaseCopyHelper helper =new DatabaseCopyHelper(this);
        try {
            helper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        helper.openDataBase();
    }
}