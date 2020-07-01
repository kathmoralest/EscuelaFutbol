package com.primefaces.dto;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 *
 * @author jean.cortes
 */
public class TipoEvento {

    private long id;
    private Date fecha;
    private String lugar;
    private Timestamp hora;
    
    public TipoEvento() {
    }

    public TipoEvento(long id, Date fecha, String lugar, Timestamp hora) {
        this.id = id;
        this.fecha = fecha;
        this.lugar = lugar;
        this.hora = hora;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Timestamp getHora() {
        return hora;
    }

    public void setHora(Timestamp hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "TipoEvento{" + "id=" + id + ", fecha=" + fecha + ", lugar=" + lugar + ", hora=" + hora + '}';
    }


}
