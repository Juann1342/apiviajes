package com.gestor.demo.controller;

import com.gestor.demo.model.Viaje;
import com.gestor.demo.service.ViajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ViajeController {
    //el controlador siempre se comunica con su servicio
    //para eso hacemos nuevamente una inyección de dependencias
    private final ViajeService viajeService;

    public ViajeController(ViajeService viajeService) {
        this.viajeService = viajeService;
    }

    //creamos el métodoo para obtener todoo el listado de viajes
    @GetMapping("/viajes")
    public List<Viaje> obtenerViajes() {
        return viajeService.obtenerViajes();

    }

    @PostMapping("/viaje")

    public ResponseEntity<Viaje> crearViaje(@RequestBody Viaje viaje) {//le decimos que nos va a devolver un objeto de tipo viaje, que vamos a recibir en el body un viaje de tipo Viaje

        //le decimos que nos retorne lo que nos devuelva el servicio
        Viaje viajeCreado = viajeService.crearViaje(viaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(viajeCreado); //nos devuelve el código del ok, y en el body va a ir el viaje creado

    }

    @PutMapping("/viaje")
    public ResponseEntity<Viaje> actualizarViaje(@RequestBody Viaje viaje) {
        Viaje viajeActualizado = viajeService.actualizarViaje(viaje); //es practicamente el mismo código que para crear, luego jpa lo diferencia porque esta va con el id
        return ResponseEntity.status(HttpStatus.CREATED).body(viajeActualizado);

    }

    //Actualiza solo algunos campos
    @PatchMapping("/viaje")
    public ResponseEntity<Viaje> actualizarPrecio(@RequestBody Viaje viaje) {
        Viaje viajeActualizado = viajeService.actualizarPrecio(viaje); //es practicamente el mismo código que para crear, luego jpa lo diferencia porque esta va con el id
        return ResponseEntity.status(HttpStatus.CREATED).body(viajeActualizado);

    }
    @DeleteMapping("/viaje")
    public ResponseEntity<Viaje> eliminarViaje(@RequestParam Long id) {
        Viaje viajeElimnado = viajeService.eliminarViaje(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(viajeElimnado);

    }

}