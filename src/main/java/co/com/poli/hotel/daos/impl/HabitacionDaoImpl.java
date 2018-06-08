/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.hotel.daos.impl;

import co.com.poli.hotel.daos.IHabitacionDao;
import co.com.poli.hotel.models.Habitacion;
import data.HabitacionData;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sala305
 */
@Repository
public class HabitacionDaoImpl implements IHabitacionDao{
    
    @Override
    public boolean Insertar(Habitacion habitacion) {
        return HabitacionData.getHabitacionList().add(habitacion);
    }

    @Override
    public boolean existe(Habitacion habitacion) {
        return HabitacionData.getHabitacionList().lastIndexOf(habitacion) != -1;
    }
    
    
    
}
