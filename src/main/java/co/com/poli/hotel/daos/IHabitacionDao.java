/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.hotel.daos;

import co.com.poli.hotel.models.Habitacion;

/**
 *
 * @author sala305
 */
public interface IHabitacionDao {
    
    boolean Insertar(Habitacion habitacion);
    boolean existe(Habitacion habitacion);
    
}
