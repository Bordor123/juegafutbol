/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.juegaFutbol.business;

import co.com.poli.juegaFutbol.models.Reserva;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author sala305
 */
public interface IReservaBusiness {
    
    boolean insertar(Reserva reserva) throws Exception;
    Reserva actualizar(int idReserva, Reserva reserva) throws Exception;
    boolean eliminar(int idReserva) throws Exception;
    List<Reserva> obtenerReservas() throws Exception;
    Reserva obtenerReserva(int idReserva) throws Exception;
    
}
