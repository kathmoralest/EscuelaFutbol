package com.controller.bean;

import com.primefaces.dao.ContactoEmergenciaDAO;
import com.primefaces.dao.PagoDAO;

import com.primefaces.dto.Pago;
import com.primefaces.dto.Persona;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author
 */
@ManagedBean
@ViewScoped
public class ListaBeanPagos implements Serializable{

    private List<Pago> pagos;
    private Pago pago;
    private PagoDAO pagoDAO;
    private List<Pago> pagosByIds;
    private long pk;

    public ListaBeanPagos() {
        pago = new Pago();
        pagoDAO = new PagoDAO();
    }

    @PostConstruct
    public void init() {
        pagos = new ArrayList<>();
        pagosByIds = new ArrayList<>();
    }

    public List<Pago> getPagos() {
        this.pagos = pagoDAO.obtenerTodos();
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }

    public long getPk() {
        return pk;
    }

    public void setPk(long pk) {
        this.pk = pk;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public List<Pago> getPagosByIds() {
        this.pagosByIds = pagoDAO.obtenerTodosByIds(pk);
        return pagosByIds;
    }

    public void setPagosByIds(List<Pago> pagosByIds) {

        this.pagosByIds = pagosByIds;
    }

    public void buscarPK() {
        //La lista aux toma el valor de la lista obtenida por Id por medio de las operaciones DAO
        pagosByIds = pagoDAO.obtenerTodosByIds(pk);
        if (pagosByIds == null) {
            pagosByIds = new ArrayList<>();
        }
    }
//    private List<Pago> cargarPagos() {
//        PagoDAO pagoDAO = new PagoDAO();
//        return pagoDAO.obtenerTodos();
//    }
//
//    private Pago buscarPK(Long id) {
//        PagoDAO pagoDAO = new PagoDAO();
//        return pagoDAO.obtener(id);
//    }

    public String regresar() {
        return "Jugador/index";
    }

}
