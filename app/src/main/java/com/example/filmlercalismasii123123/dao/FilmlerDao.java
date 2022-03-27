package com.example.filmlercalismasii123123.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.filmlercalismasii123123.objects.Filmler;
import com.example.filmlercalismasii123123.objects.Kategoriler;
import com.example.filmlercalismasii123123.objects.Yonetmenler;

import java.util.ArrayList;

public class FilmlerDao {
    public ArrayList<Filmler> tumFilmler(VeritabaniYardimcisi vt){
        ArrayList<Filmler> filmlerArrayList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = vt.getWritableDatabase();

        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM filmler, yonetmenler, kategoriler WHERE filmler.kategori_id = kategoriler.kategori_id and filmler.yonetmen_id = yonetmenler.yonetmen_id",null);

        while (c.moveToNext()){
            Kategoriler k = new Kategoriler(c.getInt(c.getColumnIndex("kategori_id")), c.getString(c.getColumnIndex("kategori_ad")));
            Yonetmenler y = new Yonetmenler(c.getInt(c.getColumnIndex("yonetmen_id")), c.getString(c.getColumnIndex("yonetmen_ad")));
            Filmler f = new Filmler(c.getInt(c.getColumnIndex("film_id")),
                    c.getString(c.getColumnIndex("film_ad")),
                    c.getInt(c.getColumnIndex("film_yil")),
                    c.getString(c.getColumnIndex("film_resim")),
                    k,
                    y);
            filmlerArrayList.add(f);

        }
        return filmlerArrayList;
    }
}
