package com.primefaces.dto;

import java.sql.Date;

/**
 *
 * @author jean.cortes
 */
public class CategoriaJugador {

    private Jugador jugador;
    private Date fechaInicio;
    private Date fechaFin;    
    private long idCategoria;
    private String nombreCategoria;

    public long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }    

    public CategoriaJugador() {
    }
        
    @Override
    public String toString() {
        return "Categoria Jugador{" + "categoria=" + categoria + "idCategoria=" + idCategoria + ", nombreCategoria=" + nombreCategoria
                    + ", jugador=" + jugador + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + '}';
    }

    public CategoriaJugador(Jugador jugador, long idCategoria, String nombreCategoria, Date fechaInicio, Date fechaFin) {
        this.jugador = jugador;
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }


}
