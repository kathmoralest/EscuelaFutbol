/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primefaces.dto;

import java.sql.Date;

/**
 *
 * @author Sergio
 */
public class PaseGol {
  private Jugador jugador;
    private Date fecha;
    private int paseGol;

    public PaseGol() {
    }

    public PaseGol(Jugador jugador, Date fecha, int pase_gol) {
        this.jugador = jugador;
        this.fecha = fecha;
        this.paseGol = pase_gol;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getPaseGol() {
        return paseGol;
    }

    public void setPaseGol(int paseGol) {
        this.paseGol = paseGol;
    }

    @Override
    public String toString() {
        return "PaseGol{" + "jugador_id=" + jugador.getId() + ", fecha=" + fecha + ", pase_gol=" + paseGol + '}';
    }
    
    
    
    
}
