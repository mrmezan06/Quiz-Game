package com.mezan.quizgame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="HighScore.db";
    public static final String TABLE_NAME="Score_table";
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    Context context;
    public static final String COL_4="SCORE";
    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,1 );
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SCORE INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldver, int newver) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }


    public boolean insertData(String name,String score){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_4,score);
        long result= db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
            return  false;
        else
            return true;
    }
    public Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
    public boolean updateData(String id,String name,String score){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_4,score);
        db.update(TABLE_NAME,contentValues,"ID = ?",new String[] {id});
        return true;
    }
    public Integer delete(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME,"ID = ?",new String[]{id});
    }
    public String Finder(String name){

        String id;
        Cursor res=getAllData();
        if(res.getCount()==0){
            Toast.makeText(context,"No Data Found!",Toast.LENGTH_SHORT).show();
            return null;
        }
        StringBuffer buffer=new StringBuffer();
        while(res.moveToNext()){

            String Name=res.getString(1);
            if(Name.equals(name)){
                id=res.getString(0);
                return id;
            }
        }


        return null;
    }
    public String FindScore(String id){

        Cursor res=getAllData();
        if(res.getCount()==0){
            Toast.makeText(context,"No Data Found!",Toast.LENGTH_SHORT).show();
            return null;
        }
        StringBuffer buffer=new StringBuffer();
        while(res.moveToNext()){

            String Id=res.getString(0);
            if(Id.equals(id)){
                String score=res.getString(2);
                return score;
            }
        }


        return null;
    }

}

