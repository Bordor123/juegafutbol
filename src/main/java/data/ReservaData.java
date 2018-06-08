/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import co.com.poli.hotel.models.Reserva;
import java.util.ArrayList;

/**
 *
 * @author sala305
 */
public class ReservaData {

    private static ArrayList<Reserva> reservaList;

    static {
        reservaList = new ArrayList<Reserva>() {
            {
                add(new Reserva(1, 1, 1, 50000d));
            }
        };
    }

    public static ArrayList<Reserva> getReservaList() {
        return reservaList;
    }

}
