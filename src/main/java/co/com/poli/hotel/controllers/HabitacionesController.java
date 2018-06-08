/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.hotel.controllers;

import co.com.poli.hotel.business.IHabitacionBusiness;
import co.com.poli.hotel.controllers.paths.HabitacionPaths;
import co.com.poli.hotel.models.Habitacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sala305
 */
@RestController
@RequestMapping(value = "/")
public class HabitacionesController {
    
    @Autowired
    private IHabitacionBusiness habitacionBusiness;
    
    @GetMapping(HabitacionPaths.HABITACIONES)
    public String insertarHabitacion(@RequestBody Habitacion habitacion) {
        String result;
        if (habitacionBusiness.Insertar(habitacion)) {
            result = "Habitacion insertada";
        } else {
            result = "No se pudo insertar la habitacion";
        }
        return result;
    }
    
}
