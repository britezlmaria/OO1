package org.example.ejercicio17;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Propiedad {

    private String direccion;
    private String nombre;
    private double precio;
    private List<DateLapse>reservas;

    public Propiedad(String direccion, String nombre, double precio) {
        this.direccion = direccion;
        this.nombre = nombre;
        this.precio = precio;
        this.reservas = new ArrayList<>();
    }

    public void reservarPropiedad(DateLapse date){
        this.reservas.add(date);
    }


    public boolean estoyDisponible(LocalDate from, LocalDate to){
        return !this.reservas.stream().anyMatch(r -> r.includesDate(from) && r.includesDate(to));
    }

    public double getPrecio(){
        return this.precio;
    }

    public void disponibilizar(DateLapse date){
        this.reservas.remove(date);
    }
}
