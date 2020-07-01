package com.controller.bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Jean Cortes
 */
@ManagedBean
@ViewScoped
public class IndexBean implements Serializable {

    public String indexPersona() {
        return "../Persona/index";
    }

}
