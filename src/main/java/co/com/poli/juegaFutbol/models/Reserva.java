/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.juegaFutbol.models;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author sala305
 */
public class Reserva {
    
    private int idReserva;
    private Date horaInicio;
    private Date horaFin;
    private int idEncargado;
    private int idCancha;
    private int idPersona;
    
    public Reserva() {
    }

    public Reserva(int idReserva, Date horaInicio, Date horaFin, int idEncargado, int idCancha, int idPersona) {
        this.idReserva = idReserva;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.idEncargado = idEncargado;
        this.idCancha = idCancha;
        this.idPersona = idPersona;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public int getIdEncargado() {
        return idEncargado;
    }

    public void setIdEncargado(int idEncargado) {
        this.idEncargado = idEncargado;
    }

    public int getIdCancha() {
        return idCancha;
    }

    public void setIdCancha(int idCancha) {
        this.idCancha = idCancha;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idReserva;
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
        if (this.idReserva != other.idReserva) {
            return false;
        }
        return true;
    }
    
}
