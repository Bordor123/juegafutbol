/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.juegaFutbol.daos.impl;

import co.com.poli.juegaFutbol.hotel.daos.IReservaDao;
import co.com.poli.juegaFutbol.models.Reserva;
import co.com.poli.juegaFutbol.utils.BDUtils;
import data.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sala305
 */
@Repository
public class ReservaDaoImpl implements IReservaDao {

    private static String SP_INSERTAR_RESERVA = "SP_INSERTARRESERVA";
    private static String SP_ACTUALIZAR_RESERVA = "SP_ACTUALIZARRESERVA";
    private static String SP_ELIMINAR_RESERVA = "SP_ELIMINARRESERVA";
    
    @Override
    public boolean insertar(Reserva reserva) throws SQLException, ClassNotFoundException {
        Connection con = Conexion.getConnection();
        CallableStatement llamada = con.prepareCall(SP_INSERTAR_RESERVA);
        llamada.setInt(1, reserva.getIdReserva());
        llamada.setDate(2, new Date(reserva.getHoraInicio().getTime()));
        llamada.setDate(3, new Date(reserva.getHoraFin().getTime()));
        llamada.setInt(4, reserva.getIdEncargado());
        llamada.setInt(5, reserva.getIdCancha());
        llamada.setInt(6, reserva.getIdPersona());
        boolean resultado = llamada.execute();
        Conexion.cerrarConexion(con);
        return resultado;
    }

    @Override
    public boolean actualizar(Reserva reserva, int reservaId) throws SQLException, ClassNotFoundException {
        Connection con = Conexion.getConnection();
        CallableStatement llamada = con.prepareCall(SP_INSERTAR_RESERVA);
        llamada.setInt(1, reserva.getIdReserva());
        llamada.setDate(2, new Date(reserva.getHoraInicio().getTime()));
        llamada.setDate(3, new Date(reserva.getHoraFin().getTime()));
        llamada.setInt(4, reserva.getIdEncargado());
        llamada.setInt(5, reserva.getIdCancha());
        llamada.setInt(6, reserva.getIdPersona());
        boolean resultado = llamada.execute();
        Conexion.cerrarConexion(con);
        return resultado;
    }

    @Override
    public boolean eliminar(int reservaId) throws SQLException, ClassNotFoundException {
        Connection con = Conexion.getConnection();
        CallableStatement llamada = con.prepareCall(SP_INSERTAR_RESERVA);
        llamada.setInt(1, reservaId);
        boolean resultado = llamada.execute();
        Conexion.cerrarConexion(con);
        return resultado;
    }

    @Override
    public List<Reserva> obtenerReservas() throws SQLException, ClassNotFoundException {
        Connection con = Conexion.getConnection();
        List<Reserva> reservas = new ArrayList<>();
        String[] columnas = new String[]{ 
            BDUtils.TablaReservas.ID_RESERVA,
            BDUtils.TablaReservas.HORA_INICIO,
            BDUtils.TablaReservas.HORA_FIN,
            BDUtils.TablaReservas.ID_ENCARGADO,
            BDUtils.TablaReservas.ID_CANCHA,
            BDUtils.TablaReservas.ID_PERSONA 
        };
        String query = String.format("SELECT ? FROM ?");
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, String.join(", ", columnas));
        preparedStatement.setString(2, BDUtils.TablaReservas.NOMBRE_TABLA);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            int idReserva = resultSet.getInt(BDUtils.TablaReservas.ID_RESERVA);
            Date horaInicio = resultSet.getDate(BDUtils.TablaReservas.HORA_INICIO);
            Date horaFin = resultSet.getDate(BDUtils.TablaReservas.HORA_FIN);
            int idEncargado = resultSet.getInt(BDUtils.TablaReservas.ID_ENCARGADO);
            int idCancha = resultSet.getInt(BDUtils.TablaReservas.ID_CANCHA);
            int idPersona = resultSet.getInt(BDUtils.TablaReservas.ID_PERSONA);
            Reserva reserva = new Reserva(idReserva, horaInicio, horaFin, idEncargado, idCancha, idPersona);
            reservas.add(reserva);
        }
        Conexion.cerrarConexion(con);
        return reservas;
    }

    @Override
    public Reserva obtenerReserva(int idReserva) throws SQLException, ClassNotFoundException {
        Connection con = Conexion.getConnection();
        Reserva reserva = null;
        Conexion.cerrarConexion(con);
        String[] columnas = new String[]{ 
            BDUtils.TablaReservas.ID_RESERVA,
            BDUtils.TablaReservas.HORA_INICIO,
            BDUtils.TablaReservas.HORA_FIN,
            BDUtils.TablaReservas.ID_ENCARGADO,
            BDUtils.TablaReservas.ID_CANCHA,
            BDUtils.TablaReservas.ID_PERSONA 
        };
        String query = "SELECT ? FROM ? WHERE ? = ?";
        PreparedStatement preparedStatement = con.prepareCall(query);
        preparedStatement.setString(1, String.join(", ", columnas));
        preparedStatement.setString(2, BDUtils.TablaReservas.NOMBRE_TABLA);
        preparedStatement.setString(3, BDUtils.TablaReservas.ID_RESERVA);
        preparedStatement.setInt(4, idReserva);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Date horaInicio = resultSet.getDate(BDUtils.TablaReservas.HORA_INICIO);
            Date horaFin = resultSet.getDate(BDUtils.TablaReservas.HORA_FIN);
            int idEncargado = resultSet.getInt(BDUtils.TablaReservas.ID_ENCARGADO);
            int idCancha = resultSet.getInt(BDUtils.TablaReservas.ID_CANCHA);
            int idPersona = resultSet.getInt(BDUtils.TablaReservas.ID_PERSONA);
            reserva = new Reserva(idReserva, horaInicio, horaFin, idEncargado, idCancha, idPersona);
        }
        return reserva;
    }

    
}
