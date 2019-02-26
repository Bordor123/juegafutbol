/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.juegaFutbol.hotel.daos;

import co.com.poli.juegaFutbol.models.Reserva;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sala305
 */
public interface IReservaDao {
    
    public boolean insertar(Reserva reserva) throws Exception;
    public boolean actualizar(Reserva reserva, int reservaId) throws Exception;
    public boolean eliminar(int reservaId) throws Exception;
    public List<Reserva> obtenerReservas() throws Exception;
    public Reserva obtenerReserva(int idReserva) throws Exception;
    
}
