package com.gestor.demo.repository;

import com.gestor.demo.model.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//este se conecta con la bd y extrae los datos
//usamos jpa, le indicamos con que entidad vamos a trabajar y cual es el tipo de dato de la primary key de esa entidad
public interface ViajeRepository extends JpaRepository<Viaje, Long> {
}