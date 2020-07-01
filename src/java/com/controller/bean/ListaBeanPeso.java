/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.bean;

import com.primefaces.dao.PesoDAO;
import com.primefaces.dto.Peso;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Sergio
 */
@ManagedBean
@ViewScoped
public class ListaBeanPeso implements Serializable {

    private List<Peso> pesos;
    private Peso peso;
    private PesoDAO pesoDAO;
    private long pk;
    private List<Peso> pesosByIds;

    public ListaBeanPeso() {
        peso = new Peso();
        pesoDAO = new PesoDAO();
    }

    @PostConstruct
    public void init() {
        pesos = new ArrayList<>();
        pesosByIds = new ArrayList<>();

    }

    public List<Peso> getPesos() {
        pesos = pesoDAO.obtenerTodos();

        return pesos;
    }

    public void setPesos(List<Peso> pesos) {
        this.pesos = pesos;
    }

    public Peso getPeso() {
        return peso;
    }

    public void setPeso(Peso peso) {
        this.peso = peso;
    }

    public long getPk() {
        return pk;
    }

    public void setPk(long pk) {
        this.pk = pk;
    }

    public List<Peso> getPesosByIds() {
        pesosByIds = pesoDAO.obtenerTodosById(pk);
        return pesosByIds;
    }

    public void setPesosByIds(List<Peso> pesosByIds) {
        this.pesosByIds = pesosByIds;
    }

    public void buscarPK() {
        //La lista aux toma el valor de la lista obtenida por Id por medio de las operaciones DAO
        pesosByIds = pesoDAO.obtenerTodosById(pk);
        if (pesosByIds == null) {
            pesosByIds = new ArrayList<>();
        }
    }
//    private List<Peso> cargarPesos() {
//        PesoDAO pesoDAO = new PesoDAO();
//        return pesoDAO.obtenerTodos();
//    }

    public String salir() {
        return "index";
    }

}
