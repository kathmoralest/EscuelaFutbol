package com.controller.bean;

import com.primefaces.dao.PersonaDAO;
import com.primefaces.dto.Persona;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author
// *
*/
@ManagedBean //This error occurs if I change it to @Named  --> WELD-001303: No active contexts for scope type javax.enterprise.context.SessionScoped
@SessionScoped
public class ListaBeanPersonas implements Serializable {

//    @EJB
    private List<Persona> Personas;
    private PersonaDAO personaDAO;
    private Persona persona;
    private long pk;

//    private BeanPersona beanPersona;
    public ListaBeanPersonas() {
        personaDAO = new PersonaDAO();
//        beanPersona = new BeanPersona();
    }

    @PostConstruct
    public void init() {
        persona = new Persona();
    }

    public List<Persona> getPersonas() {
        this.Personas = personaDAO.obtenerTodos();
        return Personas;
    }

    public void setPersonas(List<Persona> Personas) {
        this.Personas = Personas;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public long getPk() {
        return pk;
    }

    public void setPk(long pk) {
        this.pk = pk;
    }

    public void buscarPK() {
        PersonaDAO personaDAO = new PersonaDAO();
        this.persona = personaDAO.obtener(pk);
        if (persona == null) {
            persona = new Persona();
        }
    }

    public String regresar() {
        return "index";
    }

}
