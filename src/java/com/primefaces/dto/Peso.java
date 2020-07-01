/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primefaces.dto;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author Sergio
 */
public class Peso {
 private Jugador jugador;
    private Date fecha;
    private BigDecimal peso;

    public Peso() {
    }

    public Peso(Jugador jugador, Date fecha, BigDecimal peso) {
        this.jugador = jugador;
        this.fecha = fecha;
        this.peso = peso;
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

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Peso{" + "jugador_id=" + jugador + ", fecha=" + fecha + ", peso=" + peso + '}';
    }
    
    
}
