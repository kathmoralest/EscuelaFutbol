/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primefaces.dto;

import java.sql.Date;

/**
 *
 * @author jean.cortes
 */
public class Pago {

    private long id;
    private Jugador jugador;
    private Date fecha;
    private String periodoPago;
    private float valor;
    private float saldoParcialMensual;
    private float saldoTotalPagado;
    private float saldoTotalEncontra;

    public Pago() {
    }

    public Pago(long id, Jugador jugador, Date fecha, String periodoPago, float valor, float saldoParcialMensual, float saldoTotalPagado, float saldoTotalEncontra) {
        this.id = id;
        this.jugador = jugador;
        this.fecha = fecha;
        this.periodoPago = periodoPago;
        this.valor = valor;
        this.saldoParcialMensual = saldoParcialMensual;
        this.saldoTotalPagado = saldoTotalPagado;
        this.saldoTotalEncontra = saldoTotalEncontra;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getPeriodoPago() {
        return periodoPago;
    }

    public void setPeriodoPago(String periodoPago) {
        this.periodoPago = periodoPago;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getSaldoParcialMensual() {
        return saldoParcialMensual;
    }

    public void setSaldoParcialMensual(float saldoParcialMensual) {
        this.saldoParcialMensual = saldoParcialMensual;
    }

    public float getSaldoTotalPagado() {
        return saldoTotalPagado;
    }

    public void setSaldoTotalPagado(float saldoTotalPagado) {
        this.saldoTotalPagado = saldoTotalPagado;
    }

    public float getSaldoTotalEncontra() {
        return saldoTotalEncontra;
    }

    public void setSaldoTotalEncontra(float saldoTotalEncontra) {
        this.saldoTotalEncontra = saldoTotalEncontra;
    }

    @Override
    public String toString() {
        return "Pago{" + "id=" + id + ", jugador=" + jugador.getId() + ", fecha=" + fecha + ", periodoPago=" + periodoPago + ", valor=" + valor + ", saldoParcialMensual=" + saldoParcialMensual + ", saldoTotalPagado=" + saldoTotalPagado + ", saldoTotalEncontra=" + saldoTotalEncontra + '}';
    }

}
