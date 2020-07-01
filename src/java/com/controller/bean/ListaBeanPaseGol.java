/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.bean;

import com.primefaces.dao.EstaturaDAO;
import com.primefaces.dao.PaseGolDAO;
import com.primefaces.dto.Estatura;
import com.primefaces.dto.PaseGol;
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
public class ListaBeanPaseGol implements Serializable{

    private List<PaseGol> pasesGoles;
    private PaseGol paseGol;
    private PaseGolDAO pasegolDAO;
    private long pk;
    //Creamos lista aux para los pases goles por jugador
    private List<PaseGol> paseGolByIds;

    public ListaBeanPaseGol() {
        this.paseGol = new PaseGol();
        pasegolDAO = new PaseGolDAO();
    }

    @PostConstruct
    public void init() {
        this.pasesGoles = new ArrayList<>();
        this.paseGolByIds = new ArrayList<>();

    }

    public List<PaseGol> getPasesGoles() {
        pasesGoles = pasegolDAO.obtenerTodos();
        return pasesGoles;
    }

    public void setPasesGoles(List<PaseGol> pasesGoles) {
        this.pasesGoles = pasesGoles;
    }

    public PaseGol getPaseGol() {
        return paseGol;
    }

    public void setPaseGol(PaseGol paseGol) {
        this.paseGol = paseGol;
    }

    public ListaBeanPaseGol(PaseGolDAO pasegolDAO) {
        this.pasegolDAO = pasegolDAO;
    }

    public long getPk() {
        return pk;
    }

    public void setPk(long pk) {
        this.pk = pk;
    }

    public List<PaseGol> getPaseGolByIds() {
        paseGolByIds = pasegolDAO.obtenerTodosById(pk);
        return paseGolByIds;
    }

    public void setPaseGolByIds(List<PaseGol> paseGolByIds) {
        this.paseGolByIds = paseGolByIds;
    }

    public void buscarPK() {
        //Instaciamos el DAO de las operaciones
        PaseGolDAO paseGolDAO = new PaseGolDAO();
        //La lista aux toma el valor de la lista obtenida por Id por medio de las operaciones DAO
        paseGolByIds = paseGolDAO.obtenerTodosById(pk);
        if (paseGolByIds == null) {
            paseGolByIds = new ArrayList<>();
        }
    }

    public String salir() {
        return "index";
    }

//
//    private List<PaseGol> cargarPasegol() {
//        PaseGolDAO pasegolDAO = new PaseGolDAO();
//        return pasegolDAO.obtenerTodos();
//    }
    /*
       public void buscarPK() {
        PaseGolDAO paseGolDAO = new PaseGolDAO();
        this.paseGol = paseGolDAO.obtener(pk);
        if (paseGol == null) {
            paseGol = new PaseGol();
        }
    }
     */
}
