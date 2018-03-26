package com.example.christian.tcc.dados;


import android.provider.BaseColumns;

public class UsuariosContract {

    private UsuariosContract() {}

    public static abstract class UsuarioEntry implements BaseColumns {

        public static final String TABLE_NAME = "usuarios";

        public static final String _ID = "_id";
        public static final String COLUMN_ID_USUARIO_LOGADO = "idUsuarioLogado";
        public static final String COLUMN_TIPO_USUARIO = "tipoUsuario";
        public static final String COLUMN_TEMPO_VOLUNTARIO = "tempoVoluntario";
        public static final String COLUMN_DISTANCIA_VOLUNTARIO = "distanciaVoluntario";
    }
}