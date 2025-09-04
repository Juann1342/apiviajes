package com.gestor.demo.model;

import com.gestor.demo.service.ViajeService;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity

public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String origen;
    private String destino;
    private LocalDate fecha;
    private int dias;
    @Column(name = "precio_usd")
    private Double precioUSD;


    public Viaje(){
        
    }

    public Viaje(String origen, String destino, LocalDate fecha, int dias, Double precioUSD) {
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.dias = dias;
        this.precioUSD = precioUSD;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public Double getPrecioUSD() {
        return precioUSD;
    }

    public void setPrecioUSD(Double precioUSD) {
        this.precioUSD = precioUSD;
    }
}