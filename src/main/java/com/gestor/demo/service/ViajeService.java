package com.gestor.demo.service;

import com.gestor.demo.model.Viaje;
import com.gestor.demo.repository.ViajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ViajeService {
    //hacemos una inyección de dependencias, inyectamos el repositorio para crear sus métodos
    private final ViajeRepository viajeRepository;

    //lo que estamos haciendo es inyectar en el servicio la dependencia de viajeRepository
    public ViajeService(ViajeRepository viajeRepository) {
        this.viajeRepository = viajeRepository;
    }

    //creamos el métodoo de obtener los viajes

    public List<Viaje> obtenerViajes(){
        List<Viaje> listaViajes = viajeRepository.findAll();
        return listaViajes;

    }

    //recibo el objeto viaje, le decimos al repositorio que lo guarde y si sale bien nos va a devolver el objeto de tipo viaje, es el mismo pero con el id incluido (la entidad completa)
    public Viaje crearViaje(Viaje viaje){
        return viajeRepository.save(viaje); //que retorne lo que devuelva el save

    }

    //se puede utilizar el mismo métodoo save, porque lo que hace JPA es que si le mandamos un objeto con su id es porque existe y debe actializarlo y si le mandamos sin id es porque debe crear uno nuevo

    public Viaje actualizarViaje(Viaje viaje){
        return viajeRepository.save(viaje);
    }

    public Viaje actualizarPrecio(Viaje viaje) {
        //obtengo la informacion del viaje a actualizar
        Optional<Viaje> optionalViaje = viajeRepository.findById(viaje.getId()); //optional quiere decir que puede ser nulo, puede encontrarlo o no
        if(optionalViaje.isPresent()){//si exite
            Viaje viajeActualizado = optionalViaje.get(); //obtenemos el viaje con sus datos
            viajeActualizado.setPrecioUSD(viaje.getPrecioUSD()); //actualizamos el precio
            viajeRepository.save(viajeActualizado);
            return viajeActualizado;
        }
        return null; //si no exite

    }

    public Viaje eliminarViaje(Long id) {
        Optional<Viaje> optionalViaje = viajeRepository.findById(id); 
        if(optionalViaje.isPresent()){//si exite
            Viaje viajeEliminado = optionalViaje.get();
            viajeRepository.delete(viajeEliminado);
            return viajeEliminado;
        }
        return null; //si no exite


    }
}