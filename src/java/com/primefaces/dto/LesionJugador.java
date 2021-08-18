package com.primefaces.dto;

import java.sql.*;

/**
 *
 * @author jean.cortes
 */
public class LesionJugador {

    private Date fecha;
    private Jugador jugador;
    private long id;
    private String descripcion;
    
    public LesionJugador() {
    }

    public LesionJugador(Date fecha, Jugador jugador, long id, String descripcion) {
        this.fecha = fecha;
        this.jugador = jugador;
        this.id = id;
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Jugador getJugador() {

        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public String toString() {
        return "LesionJugador{" + "id=" + id + ", descripcion=" + descripcion + "fecha=" + fecha + ", jugador=" + jugador.getNombre() + ", lesion=" + lesion.getId() + '}';
    }
}
