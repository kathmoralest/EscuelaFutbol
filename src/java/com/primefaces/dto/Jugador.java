package com.primefaces.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * YO cambie la posicion por enum pilo a corregirlo
 *
 * @author jean.cortes
 */
public class Jugador extends Persona {

    private ContactoEmergencia contactoEmergencia;
    private String posicion;
    private BigDecimal  estatura;

    public BigDecimal getEstatura() {
            return estatura;
    }

    public void setEstatura(BigDecimal estatura) {
        this.estatura = estatura;
    }

    public Jugador() {
    }

    public Jugador(long id, ContactoEmergencia contactoEmergencia, String posicion) {
        super(id);
        this.contactoEmergencia = contactoEmergencia;
        this.posicion = posicion;

    }
//    public Jugador(long id, String nombre, String apellido, Date fechaNacimiento, String correo, List<ContactoEmergencia> contactoEmergencias, String posicion) {
//        super(id, nombre, apellido, fechaNacimiento, correo);
//        this.contactoEmergencias = contactoEmergencias;
//        this.posicion = posicion;
//    }

    public Jugador(long id, String nombre, String apellido, Date fechaNacimiento, String correo, String posicion, ContactoEmergencia contactoEmergencia) {
        super(id, nombre, apellido, fechaNacimiento, correo);
        this.contactoEmergencia = contactoEmergencia;
        this.posicion = posicion;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public ContactoEmergencia getContactoEmergencia() {
        return contactoEmergencia;
    }

    public void setContactoEmergencia(ContactoEmergencia contactoEmergencia) {
        this.contactoEmergencia = contactoEmergencia;
    }

    @Override
    public String toString() {
        return "Jugador{" + super.toString() + "contactoEmergencia=" + contactoEmergencia + ", posicion=" + posicion + '}';
    }

}
