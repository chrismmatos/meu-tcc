package com.example.christian.tcc.modelo;

import java.io.Serializable;

/**
 * Created by christian on 11/03/2018.
 */


public class Usuario implements Serializable {
    private Integer idUsuario = 0;
    private Integer idUsuarioLogado = 0;
    private String tipoUsuario = "";
    private Integer tempoVoluntario = 2;
    private Integer distanciaVoluntario = 1000;

    public Usuario(Integer idUsuarioLogado, String tipoUsuario) {
        this.idUsuarioLogado = idUsuarioLogado;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario(Integer idUsuario, Integer idUsuarioLogado, String tipoUsuario, Integer tempoVoluntario, Integer distanciaVoluntario) {
        this.idUsuario = idUsuario;
        this.idUsuarioLogado = idUsuarioLogado;
        this.tipoUsuario = tipoUsuario;
        this.tempoVoluntario = tempoVoluntario;
        this.distanciaVoluntario = distanciaVoluntario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuarioLogado() {
        return idUsuarioLogado;
    }

    public void setIdUsuarioLogado(Integer idUsuarioLogado) {
        this.idUsuarioLogado = idUsuarioLogado;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getTempoVoluntario() {
        return tempoVoluntario;
    }

    public void setTempoVoluntario(Integer tempoVoluntario) {
        this.tempoVoluntario = tempoVoluntario;
    }

    public Integer getDistanciaVoluntario() {
        return distanciaVoluntario;
    }

    public void setDistanciaVoluntario(Integer distanciaVoluntario) {
        this.distanciaVoluntario = distanciaVoluntario;
    }
}
