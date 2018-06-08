/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.hotel.business.impl;

import co.com.poli.hotel.daos.IHabitacionDao;
import co.com.poli.hotel.business.IHabitacionBusiness;
import co.com.poli.hotel.daos.IReservaDao;
import co.com.poli.hotel.models.Habitacion;
import co.com.poli.hotel.models.Reserva;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sala305
 */
@Service
public class HabitacionBusinessImpl implements IHabitacionBusiness {

    private final String TAG = "HABITACIONS: ";

    @Autowired
    private IHabitacionDao daoHabitacion;

    @Autowired
    private IReservaDao daoReserva;

    @Override
    public boolean Insertar(Habitacion habitacion) {
        boolean result = false;
        if (validar(habitacion)) {
            result = daoHabitacion.Insertar(habitacion);
        }
        return result;
    }

    private boolean validar(Habitacion habitacion) {
        System.out.println(TAG + habitacion);
        try {
            return habitacion != null
                    && validarHabitacion(habitacion.getNumCamas(), habitacion.getTipoHabitacion())
                    && !daoHabitacion.existe(habitacion);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean validarHabitacion(int numCamas, int tipoHabitacion) {
        boolean informacionValida;
        switch (tipoHabitacion) {
            case Habitacion.HABITACION_COMPARTIDA: {
                informacionValida = numCamas >= 4 && numCamas <= 10;
                break;
            }
            case Habitacion.HABITACION_PRIVADA: {
                informacionValida = numCamas >= 2 && numCamas <= 4;
                break;
            }
            default: {
                informacionValida = false;
            }
        }
        System.out.println(TAG + informacionValida);
        return informacionValida;
    }

    @Override
    public double totalHabitacionesOcupadas() {
        Double total = 0d;
        ArrayList<Habitacion> habitaciones = daoHabitacion.obtenerHabitaciones();
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getTipoHabitacion().equals(Habitacion.HABITACION_PRIVADA)) {
                ArrayList<Reserva> reservas = daoReserva.obtenerReservasPorHabitacion(habitacion.getIdHabitacion());
                for (Reserva reserva : reservas) {
                    total += reserva.getNumCamas() * reserva.getPrecioXCama();
                }
            }
        }
    return total ;
    }
}
