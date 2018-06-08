/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.hotel.business.impl;

import co.com.poli.hotel.business.IReservaBusiness;
import co.com.poli.hotel.daos.IHabitacionDao;
import co.com.poli.hotel.daos.IReservaDao;
import co.com.poli.hotel.models.Habitacion;
import co.com.poli.hotel.models.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sala305
 */
@Service
public class ReservaBusinessImpl implements IReservaBusiness {
    
    private final String TAG = "RESERVAS: ";
    
    @Autowired
    private IReservaDao reservaDao;
    
    @Autowired
    private IHabitacionDao habitacionDao;

    @Override
    public boolean insertar(Reserva reserva) {
        if (validarReserva(reserva)) {
            return reservaDao.insertar(reserva);
        }
        return false;
    }
    
    private boolean validarReserva(Reserva reserva) {
        boolean result = false;
        try {
            Habitacion habitacion = habitacionDao.obtenerHabitacion(reserva.getIdHabitacion());
            if (reservaDao.verificarDisponibilidad(reserva.getIdHabitacion())) {
                switch (habitacion.getTipoHabitacion()) {
                    case Habitacion.HABITACION_COMPARTIDA:
                         reserva.setPrecioXCama(30000d);
                         return true;
                    case Habitacion.HABITACION_PRIVADA:
                         reserva.setPrecioXCama(50000d);
                         return true;
                    default:
                        return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
    
}
