package com.aleenaadil.project;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SQLDBHelper extends SQLiteOpenHelper {
    public SQLDBHelper(Context context) {
        super(context, "News.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table NewsFlash(id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, content TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop Table if exists NewsFlash");
    }

    public Boolean addNewsData(NewsFlash newsFlash){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", newsFlash.getTitle());
        contentValues.put("content", newsFlash.getDescription());
        long result = db.insert("NewsFlash", null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }


    public ArrayList<NewsFlash> getAllNews(){
        ArrayList<NewsFlash> news = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from NewsFlash", null);
        if (cursor.getCount() == 0){
            return news;
        }
        else{
            while(cursor.moveToNext()){
                NewsFlash newsFlash = new NewsFlash();
                newsFlash.setTitle(cursor.getString(1));
                newsFlash.setDescription(cursor.getString(2));
                news.add(newsFlash);
            }
            return news;
        }
    }

}
