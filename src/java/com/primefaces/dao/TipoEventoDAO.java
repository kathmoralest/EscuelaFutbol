package com.primefaces.dao;

import com.controller.bean.ListaBeanPersonas;
import com.primefaces.dto.Jugador;
import com.primefaces.dto.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jean.cortes
 */
public class TipoEventoDAO implements IOperaciones<TipoEvento, Long> {

    private static final String SQL_SELECT = "SSELECT id, fecha, lugar, hora\n"
            + "	FROM public.tipo_evento";

    private static final String SQL_SELECT_BY_ID = "SELECT id, fecha, lugar, hora\n"
            + "	FROM public.tipo_evento WHERE id = ?";

    private static final String INSERT = "INSERT INTO public.persona(\n"
            + "	id, nombre, apellido, fecha_nacimiento, correo)\n"
            + "	VALUES (?, ?, ?, ?, ?)";

    private static final String INSERTJ = "INSERT INTO public.jugador(id, contacto_emergencia_id,  posicion) \n"
            + "VALUES (?, ?, ?)";

    private static final String UPDATE = "UPDATE public.persona\n"
            + "	SET nombre=?, apellido=?, fecha_nacimiento=?, correo=?\n"
            + "	WHERE id = ?";

    private static final String DELETE = "DELETE FROM persona\n"
            + "	WHERE id = ?";

    @Override
    public int eliminar(TipoEvento persona) {
        Connection conn = new Conexion().getConnection();
        int filas = 0;
        if (conn != null) {
            PreparedStatement stmt;
            try {
                stmt = conn.prepareStatement(DELETE);
                stmt.setLong(1, persona.getId());
                return filas = stmt.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(TipoEventoDAO.class.getName()).log(Level.SEVERE, "Error al eliminar persona", ex);
            } finally {

            }
        }
        return filas;
    }

    @Override
    public int modificar(TipoEvento persona) {
        Connection conn = new Conexion().getConnection();
        int filas = 0;
        if (conn != null) {
            PreparedStatement stmt;

            try {
                stmt = conn.prepareStatement(UPDATE);

//                stmt.setString(1, persona.getNombre());
//                stmt.setString(2, persona.getApellido());
//                stmt.setDate(3, (java.sql.Date) persona.getFechaNacimiento());
//                stmt.setString(4, persona.getCorreo());
//                stmt.setLong(5, persona.getId());
                return filas = stmt.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(TipoEventoDAO.class.getName()).log(Level.SEVERE, "Error al modificar persona", ex);
            } finally {

            }
        }
        return filas;
    }

    @Override
    public int insertar(TipoEvento persona) {
        Connection conn = new Conexion().getConnection();
        if (conn != null) {
            PreparedStatement stmt;
            try {
                stmt = conn.prepareStatement(INSERT);
                stmt.setLong(1, persona.getId());
//                stmt.setString(2, persona.getNombre());
//                stmt.setString(3, persona.getApellido());
//                stmt.setDate(4, (java.sql.Date) persona.getFechaNacimiento());
//                stmt.setString(5, persona.getCorreo());

                return stmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(TipoEventoDAO.class.getName()).log(Level.SEVERE, "Error al insertar persona", ex);
            } finally {

            }
        }
        return 0;
    }

    @Override
    public TipoEvento obtener(Long id) {
        List<TipoEvento> dato = new ArrayList<>();
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConnection();

        if (conexion != null) {
            PreparedStatement stmt;
            try {
                stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
                stmt.setLong(1, id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {

                    TipoEvento persona = new TipoEvento();
                    persona.setId(rs.getInt(1));
//                    persona.setNombre(rs.getString(2));
//                    persona.setApellido(rs.getString(3));
//                    persona.setFechaNacimiento(rs.getDate(4));
//                    persona.setCorreo(rs.getString(5));

                    dato.add(persona);
                    return persona;
                }
            } catch (SQLException ex) {
                Logger.getLogger(TipoEventoDAO.class.getName()).log(Level.SEVERE, "Error al obtener persona por id", ex);
            } finally {
                conexion.close(conn);
            }
        }
        return null;
    }

    @Override
    public List<TipoEvento> obtenerTodos() {
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConnection();//Realiza la conexion
        //Connection conn = null;
        //PreparedStatement stmt = null;
        List<TipoEvento> tipoEventos = new ArrayList<>();

        if (conexion != null) {
            PreparedStatement stmt;
            try {
                stmt = conn.prepareStatement(SQL_SELECT);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {//Iteramos cada uno de los elementos que tengamos en el rs
                    //Recuperamos los campos de nuestra entidad
                    Long id = rs.getLong("id");
                    Date fecha = rs.getDate("fecha");
                    String lugar = rs.getString("lugar");
                    Timestamp hora = rs.getTimestamp("hora");
                    //Creamos obj de la entidad correspondiente 
                    TipoEvento tipoEvento = new TipoEvento(id, fecha, lugar, hora);
                    //agregamos nuestro objeto de tipo persona a la lista de personas
                    tipoEventos.add(tipoEvento);

                }

            } catch (SQLException ex) {
                Logger.getLogger(TipoEventoDAO.class
                        .getName()).log(Level.SEVERE, "Error al obtener lista de tipo de evento", ex);
            } finally {
                conexion.close(conn);
            }
        }
        return tipoEventos;

    }

}
