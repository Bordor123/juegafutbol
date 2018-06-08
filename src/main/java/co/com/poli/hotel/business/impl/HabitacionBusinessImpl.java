/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.hotel.business.impl;

import co.com.poli.hotel.daos.IHabitacionDao;
import co.com.poli.hotel.business.IHabitacionBusiness;
import co.com.poli.hotel.models.Habitacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sala305
 */
@Service
public class HabitacionBusinessImpl implements IHabitacionBusiness {

    @Autowired
    private IHabitacionDao dao;

    @Override
    public boolean Insertar(Habitacion habitacion) {
        boolean result = false;
        if (validar(habitacion)) {
            result = dao.Insertar(habitacion);
        }
        return result;
    }

    private boolean validar(Habitacion habitacion) {
        return habitacion != null
                && habitacion.getNumCamas() > 0
                && validarTipo(habitacion.getIdHabitacion())
                && !dao.existe(habitacion);
    }

    private boolean validarTipo(int tipoHabitacion) {
        return tipoHabitacion == Habitacion.HABITACION_COMPARTIDA || tipoHabitacion == Habitacion.HABITACION_PRIVADA;
    }

}
