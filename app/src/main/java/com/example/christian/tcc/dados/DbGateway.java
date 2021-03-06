package com.example.christian.tcc.dados;

/**
 * Created by christian on 24/03/2018.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class DbGateway {

    private static DbGateway gw;
    private SQLiteDatabase db;

    private DbGateway(Context ctx){
        DBHelper helper = new DBHelper(ctx);
        db = helper.getWritableDatabase();
    }

    public static DbGateway getInstance(Context ctx){
        if(gw == null)
            gw = new DbGateway(ctx);
        return gw;
    }

    public SQLiteDatabase getDatabase(){
        return this.db;
    }


}