/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.bean;

import com.primefaces.dao.GolDAO;
import com.primefaces.dto.Gol;
import com.primefaces.dto.Jugador;
import java.io.Serializable;
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
public class BeanGol implements Serializable {

    private Jugador jugador;
    private Date fecha;
    private int numeroGol;

    public BeanGol() {
        jugador = new Jugador();
    }

    public void insertar() {
        if (jugador == null || fecha == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atención", "Datos vacios"));
            return;
        }
        Gol gol = new Gol();
        gol.setJugador(jugador);
        gol.setFecha(new java.sql.Date(fecha.getTime()));
        gol.setNumeroGol(numeroGol);

        GolDAO golDAO = new GolDAO();
        int rta = golDAO.insertar(gol);
        if (rta == 1) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", "Se registro el gol"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "No se pudo realizarel registro"));
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

    public int getNumeroGol() {
        return numeroGol;
    }

    public void setNumeroGol(int numeroGol) {
        this.numeroGol = numeroGol;
    }

    public String regresar() {
        return "index";
    }

}
