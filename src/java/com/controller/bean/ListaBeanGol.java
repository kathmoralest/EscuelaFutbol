/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.bean;

import com.primefaces.dao.EstaturaDAO;
import com.primefaces.dao.GolDAO;
import com.primefaces.dto.Estatura;
import com.primefaces.dto.Gol;
import java.io.Serializable;
import static java.lang.Integer.getInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Sergio
 */
@ManagedBean
@ViewScoped
public class ListaBeanGol implements Serializable {

    private List<Gol> goles;
    private Gol gol;
    private GolDAO golDAO;
    private long pk;
    //Creamos lista aux para los goles por jugador
    private List<Gol> golesByIds;

    public ListaBeanGol() {
//        this.goles = new ArrayList<>();
//        this.golesByIds = new ArrayList<>();
        this.gol = new Gol();
        this.golDAO = new GolDAO();

    }

    @PostConstruct
    public void init() {
//        this.goles = listarGoles();
        this.goles = new ArrayList<>();
        this.golesByIds = new ArrayList<>();
    }

    public List<Gol> getGoles() {
        goles = golDAO.obtenerTodos();
        return goles;
    }

    public void setGoles(List<Gol> goles) {
        this.goles = goles;
    }

    public List<Gol> getGolesByIds() {
        golesByIds = golDAO.obtenerTodosByIds(pk);
        return golesByIds;
    }

    public void setGolesByIds(List<Gol> golesByIds) {
        this.golesByIds = golesByIds;
    }

    public Gol getGol() {
        return gol;
    }

    public void setGol(Gol gol) {
        this.gol = gol;
    }

    public long getPk() {
        return pk;
    }

    public void setPk(long pk) {
        this.pk = pk;
    }

    public void buscarPK() {
        //Instaciamos el DAO de las operaciones
        GolDAO golDAO = new GolDAO();
        //La lista aux toma el valor de la lista obtenida por Id por medio de las operaciones DAO
        golesByIds = golDAO.obtenerTodosByIds(pk);
        if (golesByIds == null) {
            golesByIds = new ArrayList<>();
        }
    }
    
      public String salir() {
        return "index";
    }

    /*
    public List<Gol> listarGoles() {
        GolDAO golDAO = new GolDAO();
        return golDAO.obtenerTodos();
    }
     */
 /*
       public List<Gol> listarGolesByID() {
        //Creamos lista aux
        List<Gol> golesByIds = new ArrayList<>();
        //Instaciamos el DAO de las operaciones
        GolDAO golDAO = new GolDAO();
        //La lista aux toma el valor de la lista obtenida por Id por medio de las operaciones DAO
        golesByIds = golDAO.obtenerTodosByIds(pk);
        if (golesByIds == null) {
            golesByIds = new ArrayList<>();
        }
        return golesByIds;
    }
     */
  

}
