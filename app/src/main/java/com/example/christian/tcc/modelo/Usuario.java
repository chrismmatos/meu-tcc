package com.example.christian.tcc.modelo;

import java.io.Serializable;

/**
 * Created by christian on 11/03/2018.
 */


public class Usuario implements Serializable {
    private Integer IdUsuario = 0;
    private Integer IdUsuarioLogado = 0;
    private String TipoUsuario = "";
    private Integer TempoVoluntario = 2;
    private Integer DistanciaVoluntario = 1000;

    public Integer getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        IdUsuario = idUsuario;
    }

    public Integer getIdUsuarioLogado() {
        return IdUsuarioLogado;
    }

    public void setIdUsuarioLogado(Integer idUsuarioLogado) {
        IdUsuarioLogado = idUsuarioLogado;
    }

    public String getTipoUsuario() {
        return TipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        TipoUsuario = tipoUsuario;
    }

    public Integer getTempoVoluntario() {
        return TempoVoluntario;
    }

    public void setTempoVoluntario(Integer tempoVoluntario) {
        TempoVoluntario = tempoVoluntario;
    }

    public Integer getDistanciaVoluntario() {
        return DistanciaVoluntario;
    }

    public void setDistanciaVoluntario(Integer distanciaVoluntario) {
        DistanciaVoluntario = distanciaVoluntario;
    }
}
