package com.example.christian.tcc.modelo;

import android.content.ContentValues;
import android.content.Context;

/**
 * Created by christian on 24/03/2018.
 */


import android.database.Cursor;

import com.example.christian.tcc.dados.DbGateway;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public final String TABLE_USUARIOS = "Usuarios";
    private DbGateway gw;

    public UsuarioDAO(Context ctx){
        gw = DbGateway.getInstance(ctx);
    }


    public List<Usuario> retornarTodos(){
        List<Usuario> usuarios = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Usuarios", null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("_IdUsuario"));
            int idUsuarioLogado  =cursor.getInt(cursor.getColumnIndex("IdUsuariosLogado"));
            String tipoUsuario =cursor.getString(cursor.getColumnIndex("TipoUsuario"));
            int distanciaVoluntario =cursor.getInt(cursor.getColumnIndex("TempoVoluntario"));
            int tempoVoluntario  =cursor.getInt(cursor.getColumnIndex("DistanciaVoluntario"));
            usuarios.add(new Usuario(id, idUsuarioLogado, tipoUsuario, tempoVoluntario, distanciaVoluntario));
        }
        cursor.close();
        return usuarios;
    }



    public Usuario retornarUltimo(){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Usuarios ORDER BY ID DESC", null);
        if(cursor.moveToFirst()){
            int id = cursor.getInt(cursor.getColumnIndex("_IdUsuario"));
            int idUsuarioLogado  =cursor.getInt(cursor.getColumnIndex("IdUsuariosLogado"));
            String tipoUsuario =cursor.getString(cursor.getColumnIndex("TipoUsuario"));
            int distanciaVoluntario =cursor.getInt(cursor.getColumnIndex("TempoVoluntario"));
            int tempoVoluntario  =cursor.getInt(cursor.getColumnIndex("DistanciaVoluntario"));
            cursor.close();
            return new Usuario(id, idUsuarioLogado, tipoUsuario, distanciaVoluntario, tempoVoluntario);
        }

        return null;
    }

    public boolean salvar(int idLogado, String tipo,int tempo, int distancia){
        return salvar(0, idLogado, tipo, distancia, tempo);
    }

    public boolean salvar(int _IdUsuario, int idUsuarioLogado, String tipoUsuario, int tempoVoluntario, int distanciaVoluntario){
        ContentValues cv = new ContentValues();
        cv.put("IdUsuariosLogado", idUsuarioLogado);
        cv.put("TipoUsuario", tipoUsuario);
        cv.put("TempoVoluntario", tempoVoluntario);
        cv.put("DistanciaVoluntario", distanciaVoluntario);
        if(idUsuarioLogado > 0)
            return gw.getDatabase().update(TABLE_USUARIOS, cv, "_IdUsuario=?", new String[]{ _IdUsuario + "" }) > 0;
        else
            return gw.getDatabase().insert(TABLE_USUARIOS, null, cv) > 0;
    }

    public boolean excluir(int id){
        return gw.getDatabase().delete(TABLE_USUARIOS, "ID=?", new String[]{ id + "" }) > 0;
    }


}