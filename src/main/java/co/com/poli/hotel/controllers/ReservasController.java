/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.hotel.controllers;

import co.com.poli.hotel.business.IReservaBusiness;
import co.com.poli.hotel.controllers.paths.ReservaPaths;
import co.com.poli.hotel.models.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sala305
 */
@RestController
@RequestMapping(value = "/")
public class ReservasController {
    
    @Autowired
    private IReservaBusiness reservaBusiness;
    
    @PostMapping(ReservaPaths.HABITACIONES)
    public String insertarReserva(@RequestBody Reserva reserva) {
        String result;
        if (reservaBusiness.insertar(reserva)) {
            result = "Reserva insertada";
        } else {
            result = "No se pudo insertar la reserva";
        }
        return result;
    }
    
}
