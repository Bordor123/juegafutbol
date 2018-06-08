/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.hotel.models;

import java.util.Objects;

/**
 *
 * @author sala305
 */
public class Reserva {
    
    private Integer idReserva;
    private Integer idHabitacion;
    private Integer numCamas;
    private Double precioXCama;

    public Reserva() {
    }

    public Reserva(Integer idReserva, Integer idHabitacion, Integer numCamas, Double precioXCama) {
        this.idReserva = idReserva;
        this.idHabitacion = idHabitacion;
        this.numCamas = numCamas;
        this.precioXCama = precioXCama;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Integer getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Integer idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public Integer getNumCamas() {
        return numCamas;
    }

    public void setNumCamas(Integer numCamas) {
        this.numCamas = numCamas;
    }

    public Double getPrecioXCama() {
        return precioXCama;
    }

    public void setPrecioXCama(Double precioXCama) {
        this.precioXCama = precioXCama;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.idReserva);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reserva other = (Reserva) obj;
        if (!Objects.equals(this.idReserva, other.idReserva)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reserva{" + "idReserva=" + idReserva + ", idHabitacion=" + idHabitacion + ", numCamas=" + numCamas + ", precioXCama=" + precioXCama + '}';
    }
    
    
}
