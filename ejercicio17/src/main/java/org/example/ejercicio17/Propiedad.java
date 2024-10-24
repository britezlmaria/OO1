package org.example.ejercicio17;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Propiedad {

    private String direccion;
    private String nombre;
    private double precio;
    private List<Reserva>reservas;

    public Propiedad(String direccion, String nombre, double precio) {
        this.direccion = direccion;
        this.nombre = nombre;
        this.precio = precio;
        this.reservas = new ArrayList<>();
    }

    private void reservarPropiedad(Reserva reserva){
        this.reservas.add(reserva);
    }

    public void agregarReserva(Usuario usuario,DateLapse periodo){
        if(estoyDisponible(periodo.getFrom(),periodo.getTo())){
            Reserva reserva=new Reserva(periodo,this,usuario);
        }
    }

    public List<Reserva>getReservas(){
        return reservas;
    }

    public boolean estoyDisponible(LocalDate from, LocalDate to){
        DateLapse date=new DateLapse(from,to);
        return !this.getReservas().stream().anyMatch(r -> r.estoyEnElPeriodo(date));
    }

    public double getPrecio(){
        return this.precio;
    }

    public void disponibilizar(Reserva reserva){
        this.reservas.remove(reserva);
    }

    public double tengoReservasEnPeriodo(DateLapse date){
        return this.getReservas().stream().filter(r -> r.estoyEnElPeriodo(date)).mapToDouble(r -> r.calcularPrecio()).sum();
    }
}
