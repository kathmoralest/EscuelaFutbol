package com.controller.bean;

import com.primefaces.dao.CategoriaJugadorDAO;
import com.primefaces.dto.CategoriaJugador;
import com.primefaces.dto.Jugador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author jean.cortes
 */
@ManagedBean
@ViewScoped
public class ListaBeanCategoriaJugador implements Serializable {

    private CategoriaJugador categoriaJugador;
    private List<CategoriaJugador> categoriaJugadors;
    private CategoriaJugadorDAO categoriaJugadorDAO;
    private long pk;

    @PostConstruct
    public void init() {
        categoriaJugadorDAO = new CategoriaJugadorDAO();
        categoriaJugador = new CategoriaJugador();
    }

    public ListaBeanCategoriaJugador() {
        categoriaJugadorDAO = new CategoriaJugadorDAO();
    }

    public CategoriaJugador getCategoriaJugador() {
        return categoriaJugador;
    }

    public void setCategoriaJugador(CategoriaJugador categoriaJugador) {
        this.categoriaJugador = categoriaJugador;
    }

    public List<CategoriaJugador> getCategoriaJugadors() {
        this.categoriaJugadors = categoriaJugadorDAO.obtenerTodos();
        return categoriaJugadors;
    }

    public void setCategoriaJugadors(List<CategoriaJugador> categoriaJugadors) {
        this.categoriaJugadors = categoriaJugadors;
    }

    public long getPk() {
        return pk;
    }

    public void setPk(long pk) {
        this.pk = pk;
    }


//    private List<CategoriaJugador> cargarCategoriaJugadores() {
//        CategoriaJugadorDAO categoriaJugadorDAO = new CategoriaJugadorDAO();
//        return categoriaJugadorDAO.obtenerTodos();
//    }
//    
    public void buscarPK() {
        CategoriaJugadorDAO categoriaJugadorDAO = new CategoriaJugadorDAO();
        this.categoriaJugador = categoriaJugadorDAO.obtener(pk);
        if (categoriaJugador == null) {
            categoriaJugador = new CategoriaJugador();
        }
    }

    public String regresar() {
        return "index";
    }
}
