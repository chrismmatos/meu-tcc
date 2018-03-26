package com.example.christian.tcc.dados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 private Integer idUsuarioLogado = 0;
 private String tipoUsuario = "";
 private Integer tempoVoluntario = 2;
 private Integer distanciaVoluntario = 1000;
 */

public class DBHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "safe.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlTableUsuarios= "CREATE TABLE " + UsuariosContract.UsuarioEntry.TABLE_NAME + " (" +
                UsuariosContract.UsuarioEntry._ID + " INTEGER PRIMARY KEY, " +
                UsuariosContract.UsuarioEntry.COLUMN_ID_USUARIO_LOGADO + " TEXT NOT NULL, " +
                UsuariosContract.UsuarioEntry.COLUMN_TIPO_USUARIO + " TEXT NOT NULL, " +
                UsuariosContract.UsuarioEntry.COLUMN_TEMPO_VOLUNTARIO + " TEXT NOT NULL, " +
                UsuariosContract.UsuarioEntry.COLUMN_DISTANCIA_VOLUNTARIO + " TEXT NOT NULL" +
                ");";

        db.execSQL(sqlTableUsuarios);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + UsuariosContract.UsuarioEntry.TABLE_NAME);
        onCreate(db);
    }
}