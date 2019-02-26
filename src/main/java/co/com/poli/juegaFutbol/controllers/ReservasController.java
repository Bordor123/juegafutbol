/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.juegaFutbol.controllers;

import co.com.poli.juegaFutbol.business.IReservaBusiness;
import co.com.poli.juegaFutbol.controllers.paths.ReservaPaths;
import co.com.poli.juegaFutbol.models.Reserva;
import co.com.poli.juegaFutbol.models.Respuesta;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PostMapping(ReservaPaths.RESERVAS)
    public ResponseEntity insertarReserva(@RequestBody Reserva reserva) {
        Respuesta payload = new Respuesta();
        ResponseEntity responseEntity;
        try {
            payload.success = reservaBusiness.insertar(reserva);
            payload.message = payload.success ? "Registro insertado con exito" : "No se pudo insertar el registro";
            responseEntity = new ResponseEntity(payload, payload.success ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            payload.success = false;
            payload.message = e.getMessage();
            responseEntity = new ResponseEntity(payload, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping(ReservaPaths.RESERVAS)
    public ResponseEntity obtenerReservas() {
        Respuesta payload = new Respuesta();
        ResponseEntity responseEntity;
        try {
            List<Reserva> reservas = reservaBusiness.obtenerReservas();
            payload.success = true;
            payload.data = reservas;
            responseEntity = new ResponseEntity(payload, HttpStatus.OK);
        } catch (Exception ex) {
            payload.success = false;
            payload.message = ex.getMessage();
            responseEntity = new ResponseEntity(payload, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PutMapping(ReservaPaths.RESERVAS_ID)
    public ResponseEntity actualizarReserva(@RequestBody Reserva reservaInfo, @PathVariable(name = "idReserva") int idReserva) {
        Respuesta payload = new Respuesta();
        ResponseEntity responseEntity;
        try {
            if (reservaBusiness.obtenerReserva(idReserva) == null) {
                payload.success = false;
                responseEntity = new ResponseEntity(payload, HttpStatus.NOT_FOUND);
            } else {
                Reserva reserva = reservaBusiness.actualizar(idReserva, reservaInfo);
                HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
                if (reserva != null) {
                    payload.success = true;
                    payload.message = "Registro actualizado con exito";
                    payload.data = reserva;
                } else {
                    payload.success = false;
                    payload.message = "No se pudo actualizar el registro";
                }
                responseEntity = new ResponseEntity(payload, status);
            }
        } catch (Exception e) {
            payload.success = false;
            payload.message = e.getMessage();
            responseEntity = new ResponseEntity(payload, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping(ReservaPaths.RESERVAS_ID)
    public ResponseEntity obtenerReserva(@PathVariable(name = "idReserva") int idReserva) {
        Respuesta payload = new Respuesta();
        ResponseEntity responseEntity;
        try {
            Reserva reserva = reservaBusiness.obtenerReserva(idReserva);
            if (reserva != null) {
                payload.success = true;
                payload.data = reserva;
                responseEntity = new ResponseEntity(payload, HttpStatus.OK);
            } else {
                payload.success = false;
                responseEntity = new ResponseEntity(payload, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            payload.success = false;
            payload.message = e.getMessage();
            responseEntity = new ResponseEntity(payload, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @DeleteMapping(ReservaPaths.RESERVAS_ID)
    public ResponseEntity EliminarReserva(@PathVariable(name = "idReserva") int idReserva) {
        Respuesta payload = new Respuesta();
        ResponseEntity responseEntity;
            try {
            if (reservaBusiness.obtenerReserva(idReserva) == null) {
                payload.success = false;
                responseEntity = new ResponseEntity(payload, HttpStatus.NOT_FOUND);
            } else {
                boolean resultado = reservaBusiness.eliminar(idReserva);
                payload.success = resultado;
                payload.message = resultado ? "Reserva eliminada con exito" : "No se pudo eliminar la reserva";
                responseEntity = new ResponseEntity(payload, HttpStatus.OK);
            }
        } catch (Exception ex) {
            payload.success = false;
            payload.message = ex.getMessage();
            responseEntity = new ResponseEntity(payload, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
