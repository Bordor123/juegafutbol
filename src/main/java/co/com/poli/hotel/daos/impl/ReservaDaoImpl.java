/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.hotel.daos.impl;

import co.com.poli.hotel.daos.IHabitacionDao;
import co.com.poli.hotel.daos.IReservaDao;
import co.com.poli.hotel.models.Habitacion;
import co.com.poli.hotel.models.Reserva;
import data.ReservaData;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sala305
 */
@Repository
public class ReservaDaoImpl implements IReservaDao {

    @Autowired
    IHabitacionDao daoHabitacion;

    @Override
    public boolean insertar(Reserva reserva) {
        return ReservaData.getReservaList().add(reserva);
    }

    @Override
    public boolean existe(Reserva reserva) {
        return ReservaData.getReservaList().lastIndexOf(reserva) != -1;
    }

    @Override
    public ArrayList<Reserva> obtenerReservasPorHabitacion(Integer idHabitacion) {
        ArrayList<Reserva> reservasHabitacion = new ArrayList<Reserva>();
        ArrayList<Reserva> reservaList = ReservaData.getReservaList();
        for (Reserva reserva : reservaList) {
            if (reserva.getIdHabitacion().equals(idHabitacion)) {
                reservasHabitacion.add(reserva);
            }
        }
        return reservasHabitacion;
    }

    @Override
    public boolean verificarDisponibilidad(Integer idHabitacion) {
        Habitacion habitacion;
        if ((habitacion = daoHabitacion.obtenerHabitacion(idHabitacion)) != null) {
            ArrayList<Reserva> reservaList = ReservaData.getReservaList();
            int numCamasOcupadas = 0;
            for (Reserva reserva : reservaList) {
                if (habitacion.getTipoHabitacion() == Habitacion.HABITACION_PRIVADA) {
                    System.out.println("hay una reserva privada");
                    return false;
                } else if (reserva.getIdHabitacion().equals(idHabitacion)) {

                    numCamasOcupadas += reserva.getNumCamas();
                }
            }
            System.out.println(numCamasOcupadas + "/" + habitacion.getNumCamas());
            return numCamasOcupadas < habitacion.getNumCamas();
        }
        return false;
    }

}
