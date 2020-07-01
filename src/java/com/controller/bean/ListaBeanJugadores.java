package com.controller.bean;

import com.primefaces.dao.ContactoEmergenciaDAO;
import com.primefaces.dao.JugadorDAO;
import com.primefaces.dto.ContactoEmergencia;
import com.primefaces.dto.Jugador;
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
 * @author OscarEsteban
 */
@ManagedBean
@ViewScoped
public class ListaBeanJugadores extends Persona implements Serializable {

    private List<Jugador> Jugadores;
    private JugadorDAO jugadorDAO;
    private Jugador jugador;
    private long pk;

    public ListaBeanJugadores() {
        jugadorDAO = new JugadorDAO();
    }

    @PostConstruct
    public void init() {
        jugador = new Jugador();
    }

   
    public List<Jugador> getJugadores() {
        this.Jugadores = jugadorDAO.obtenerTodos();
        return Jugadores;
    }

    public void setJugadores(List<Jugador> Jugadores) {
        this.Jugadores = Jugadores;
    }

//    private List<Jugador> cargarJugadores() {
//        JugadorDAO jugadorDAO = new JugadorDAO();
//        return jugadorDAO.obtenerTodos();
//    }
    public void buscarPK() {
        JugadorDAO jugadorDAO = new JugadorDAO();
        this.jugador = jugadorDAO.obtener(pk);
        if (jugador == null) {
            jugador = new Jugador();
        }
    }

    public JugadorDAO getJugadorDAO() {
        return jugadorDAO;
    }

    public void setJugadorDAO(JugadorDAO jugadorDAO) {
        this.jugadorDAO = jugadorDAO;
    }

    public Jugador getJugador() {
//        jugador = jugadorDAO.obtener(pk);
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public long getPk() {

        return pk;
    }

    public void setPk(long pk) {
        this.pk = pk;
    }

    public String salir() {
        return "index";
    }

}
