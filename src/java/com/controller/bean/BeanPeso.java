/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.bean;

import com.primefaces.dao.PesoDAO;
import com.primefaces.dto.Jugador;
import com.primefaces.dto.Peso;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Sergio
 */
@ManagedBean
@ViewScoped
public class BeanPeso implements Serializable {

    private Jugador jugador;
    private Date fecha;
    private BigDecimal peso;

    public BeanPeso() {
        jugador = new Jugador();
    }

    public void insertar() {
        if (fecha == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atención", "Datos vacios"));
            return;
        }
        Peso pesos = new Peso();
        pesos.setJugador(jugador);
        pesos.setFecha(new java.sql.Date(fecha.getTime()));
        pesos.setPeso(peso);

        PesoDAO pesoDAO = new PesoDAO();
        int rta = pesoDAO.insertar(pesos);
        if (rta == 1) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", "Se registro el peso"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", "No se pudo realizar el registro"));
        }

        System.out.println("rta " + rta);
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

    public String regresar() {
        return "index";
    }
}
