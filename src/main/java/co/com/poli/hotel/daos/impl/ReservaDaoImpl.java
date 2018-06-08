/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.hotel.daos.impl;

import co.com.poli.hotel.daos.IReservaDao;
import co.com.poli.hotel.models.Reserva;
import data.ReservaData;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sala305
 */
@Repository
public class ReservaDaoImpl implements IReservaDao {

    @Override
    public boolean insertar(Reserva reserva) {
        return ReservaData.getReservaList().add(reserva);
    }

    @Override
    public boolean existe(Reserva reserva) {
        return ReservaData.getReservaList().lastIndexOf(reserva) != -1;
    }
    
    
    
}
