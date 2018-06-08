/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import co.com.poli.hotel.models.Habitacion;
import java.util.ArrayList;

/**
 *
 * @author sala305
 */
public class HabitacionData {

    private static ArrayList<Habitacion> habitacionList;

    static {
        habitacionList = new ArrayList<Habitacion>() {
            {
                add(new Habitacion(1, Habitacion.HABITACION_PRIVADA, 4));
            }
        };
    }

    public static ArrayList<Habitacion> getHabitacionList() {
        return habitacionList;
    }
    
}
