package com.controller.bean;

import com.primefaces.dao.EstaturaDAO;
import com.primefaces.dto.Estatura;
import com.primefaces.dto.Persona;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author OscarEsteban
 */
@ManagedBean
@ViewScoped
public class ListaBeanEstatura implements Serializable {

    private List<Estatura> estaturas;
    private Estatura estatura;
    private EstaturaDAO estaturaDAO;
    private long pk;
    private List<Estatura> estaturasByIds;

    public ListaBeanEstatura() {
        this.estatura = new Estatura();
        this.estaturaDAO = new EstaturaDAO();
    }

    @PostConstruct
    public void init() {
        estaturas = new ArrayList<>();
        estaturasByIds = new ArrayList<>();
    }

    public List<Estatura> getEstaturas() {
        estaturas = estaturaDAO.obtenerTodos();
        return estaturas;
    }

    public void setEstaturas(List<Estatura> estaturas) {
        this.estaturas = estaturas;
    }

    public Estatura getEstatura() {
        return estatura;
    }

    public void setEstatura(Estatura estatura) {
        this.estatura = estatura;
    }

    public long getPk() {
        return pk;
    }

    public void setPk(long pk) {
        this.pk = pk;
    }

    public List<Estatura> getEstaturasByIds() {
        estaturasByIds = estaturaDAO.obtenerTodosById(pk);
        return estaturasByIds;
    }

    public void setEstaturasByIds(List<Estatura> estaturasByIds) {
        this.estaturasByIds = estaturasByIds;
    }

    public void buscarPK() {
        //La lista aux toma el valor de la lista obtenida por Id por medio de las operaciones DAO
        estaturasByIds = estaturaDAO.obtenerTodosById(pk);
        if (estaturasByIds == null) {
            estaturasByIds = new ArrayList<>();
        }
    }

//    private List<Estatura> cargarEstaturas() {
//        EstaturaDAO personaDAO = new EstaturaDAO();
//        return personaDAO.obtenerTodos();
//    }
    public String salir() {
        return "index";
    }

}
