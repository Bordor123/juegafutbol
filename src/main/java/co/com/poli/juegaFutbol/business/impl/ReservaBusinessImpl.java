/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.juegaFutbol.business.impl;

import co.com.poli.juegaFutbol.business.IReservaBusiness;
import co.com.poli.juegaFutbol.hotel.daos.IReservaDao;
import co.com.poli.juegaFutbol.models.Reserva;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author sala305
 */
@Service
public class ReservaBusinessImpl implements IReservaBusiness {
    
    private final String TAG = "RESERVAS: ";
    
    @Autowired
    private IReservaDao reservaDao;

    @Override
    public boolean insertar(Reserva reserva) throws Exception {
        boolean resultado = reservaDao.insertar(reserva);
        if (!resultado) {
            throw new Exception("No se pudo insetar el registro");
        }
        return resultado;
    }

    @Override
    public Reserva actualizar(int idReserva, Reserva reserva) throws Exception {
        boolean resultado = reservaDao.actualizar(reserva, idReserva);
        if (!resultado) {
            throw new Exception("No se pudo actualizar el registro");
        }
        return reservaDao.obtenerReserva(idReserva);
    }

    @Override
    public boolean eliminar(int idReserva) throws Exception {
        boolean resultado = reservaDao.eliminar(idReserva);
        if (!resultado) {
            throw new Exception("No se pudo eliminar el registro");
        }
        return resultado;
    }

    @Override
    public List<Reserva> obtenerReservas() throws Exception {
        return reservaDao.obtenerReservas();
    }

    @Override
    public Reserva obtenerReserva(int idReserva) throws Exception {
        return reservaDao.obtenerReserva(idReserva);
    }

                
}
