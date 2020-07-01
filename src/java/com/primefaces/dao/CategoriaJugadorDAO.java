package com.primefaces.dao;

import com.primefaces.dto.CategoriaJugador;
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
public class CategoriaJugadorDAO implements IOperaciones<CategoriaJugador, Long> {

    private static final String SQL_SELECT_INNER_JOIN = "";

    private static final String SQL_SELECT = "SELECT jugador_id, categoria_id, fecha_inicio, fecha_fin\n"
            + "	FROM public.categoria_jugador";

    private static final String SQL_SELECT_BY_ID = "SELECT jugador_id, categoria_id, fecha_inicio, fecha_fin\n"
            + "	FROM public.categoria_jugador WHERE jugador_id = ?";

    private static final String INSERT = "INSERT INTO public.categoria_jugador(\n"
            + "	jugador_id, categoria_id, fecha_inicio, fecha_fin)\n"
            + "	VALUES (?, ?, ?, ?)";

    private static final String UPDATE = "";

    private static final String DELETE = "";

    @Override
    public int insertar(CategoriaJugador categoriaJugador) {
        Connection conn = new Conexion().getConnection();
        if (conn != null) {
            PreparedStatement stmt;
            try {
                stmt = conn.prepareStatement(INSERT);
                stmt.setLong(1, categoriaJugador.getJugador().getId());
                stmt.setLong(2, categoriaJugador.getCategoria().getId());
                stmt.setDate(3, (java.sql.Date) categoriaJugador.getFechaInicio());
                stmt.setDate(4, (java.sql.Date) categoriaJugador.getFechaFin());
                return stmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(CategoriaJugadorDAO.class.getName()).log(Level.SEVERE, "Error al insertar estatura", ex);
            } finally {

            }
        }
        return 0;
    }

    @Override
    public int modificar(CategoriaJugador categoria) {
        Connection conn = new Conexion().getConnection();
        if (conn != null) {
            PreparedStatement stmt;
            try {
                stmt = conn.prepareStatement(UPDATE);

                return stmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(CategoriaJugadorDAO.class.getName()).log(Level.SEVERE, "Error al insertar contacto de emergencia", ex);
            } finally {

            }
        }
        return 0;
    }

    @Override
    public int eliminar(CategoriaJugador estatura) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CategoriaJugador obtener(Long jugador_id) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConnection();
        if (conexion != null) {
            PreparedStatement stmt;
            try {
                stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
                stmt.setObject(1, jugador_id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    JugadorDAO jugadorDAO = new JugadorDAO();
                    Jugador jugador = jugadorDAO.obtener(Long.parseLong(rs.getString(1)));
                    CategoriaDAO categoriaDAO = new CategoriaDAO();
                    Categoria categoria = categoriaDAO.obtener(Long.parseLong(rs.getString(2)));
                    Date fechaInicio = rs.getDate(3);
                    Date fechaFin = rs.getDate(4);
                    //Creamos obj de la entidad correspondiente
                    CategoriaJugador categoriaJugador = new CategoriaJugador(jugador, categoria, fechaInicio, fechaFin);

                    return categoriaJugador;
                }
            } catch (SQLException ex) {
                Logger.getLogger(CategoriaJugadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                conexion.close(conn);
            }
        }
        return null;
    }
    
    
    
    @Override
    public List<CategoriaJugador> obtenerTodos() {
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConnection();//Realiza la conexion
        List<CategoriaJugador> categoriaJugadors = new ArrayList<>();

        if (conexion != null) {
            PreparedStatement stmt;
            try {
                stmt = conn.prepareStatement(SQL_SELECT);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {//Iteramos cada uno de los elementos que tengamos en el rs
                    //Recuperamos los campos de nuestra entidad

                    JugadorDAO jugadorDAO = new JugadorDAO();
                    Jugador jugador = jugadorDAO.obtener(Long.parseLong(rs.getString("jugador_id")));
                    CategoriaDAO categoriaDAO = new CategoriaDAO();
                    Categoria categoria = categoriaDAO.obtener(Long.parseLong(rs.getString("categoria_id")));
                    Date fechaInicio = rs.getDate("fecha_inicio");
                    Date fechaFin = rs.getDate("fecha_fin");
                    //Creamos obj de la entidad correspondiente
                    CategoriaJugador categoriaJugador = new CategoriaJugador(jugador, categoria, fechaInicio, fechaFin);
                    //agregamos nuestro objeto de tipo contacto de emergencia a la lista de contacto de emergencias
                    categoriaJugadors.add(categoriaJugador);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CategoriaJugadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                conexion.close(conn);
            }
        }
        return categoriaJugadors;

    }


}
