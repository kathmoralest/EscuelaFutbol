package com.controller.bean;

import com.primefaces.dao.ContactoEmergenciaDAO;
import com.primefaces.dao.JugadorDAO;
import com.primefaces.dao.LesionJugadorDAO;
import com.primefaces.dto.ContactoEmergencia;
import com.primefaces.dto.Jugador;
import com.primefaces.dto.LesionJugador;
import com.primefaces.dto.Persona;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Jean Cortes
 */
@ManagedBean
@ViewScoped
public class ListaBeanLesionJugador  implements Serializable {

    private List<LesionJugador> lesionJugadores;
    private LesionJugador lesionJugador;
    private LesionJugadorDAO lesionJugadorDAO;
    private long pk;
    //Creamos lista aux para los goles por jugador
    private List<LesionJugador> lesionJugadoresByIds;

    public ListaBeanLesionJugador() {
        this.lesionJugador = new LesionJugador();
        this.lesionJugadorDAO = new LesionJugadorDAO();
    }

    @PostConstruct
    public void init() {
        lesionJugadores = new ArrayList<>();
        lesionJugadoresByIds = new ArrayList<>();
    }

    public List<LesionJugador> getLesionJugadores() {
        lesionJugadores = lesionJugadorDAO.obtenerTodos();
        return lesionJugadores;
    }

    public void setLesionJugadores(List<LesionJugador> lesionJugadores) {
        this.lesionJugadores = lesionJugadores;
    }

    public LesionJugador getLesionJugador() {
        return lesionJugador;
    }

    public void setLesionJugador(LesionJugador lesionJugador) {
        this.lesionJugador = lesionJugador;
    }

    public long getPk() {
        return pk;
    }

    public void setPk(long pk) {
        this.pk = pk;
    }

    public List<LesionJugador> getLesionJugadoresByIds() {
        lesionJugadoresByIds = lesionJugadorDAO.obtenerTodosById(pk);
        return lesionJugadoresByIds;
    }

    public void setLesionJugadoresByIds(List<LesionJugador> lesionJugadoresByIds) {
        this.lesionJugadoresByIds = lesionJugadoresByIds;
    }

    public void buscarPK() {
        //Instaciamos el DAO de las operaciones
        LesionJugadorDAO lesionJugadorDAO = new LesionJugadorDAO();
        //La lista aux toma el valor de la lista obtenida por Id por medio de las operaciones DAO
        lesionJugadoresByIds = lesionJugadorDAO.obtenerTodosById(pk);
        if (lesionJugadoresByIds == null) {
            lesionJugadoresByIds = new ArrayList<>();
        }
    }
//    private List<LesionJugador> cargarLesionesJugadores() {
//        LesionJugadorDAO lesionJugadorDAO = new LesionJugadorDAO();
//        return lesionJugadorDAO.obtenerTodos();
//    }

    public String salir() {
        return "index";
    }

}
