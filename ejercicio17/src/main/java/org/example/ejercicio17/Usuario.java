package org.example.ejercicio17;

import java.util.List;
import java.util.ArrayList;
public class Usuario {

	private String nombre;
	private String direccion;
	private int DNI;
	private List<Reserva>alquileres;
	private List<Reserva>reservas;



	public Usuario(String nombre, String direccion, int DNI) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.DNI = DNI;
		this.alquileres = new ArrayList<>();
		this.reservas = new ArrayList<>();
	}
	public void agregarReserva(Reserva reserva) {
		reservas.add(reserva);
	}

	public void crearReserva(Propiedad propiedad,DateLapse date) {
		if(propiedad.estoyDisponible(date.getFrom(),date.getTo())){
			Reserva reserva=new Reserva(date,propiedad);
			this.agregarReserva(reserva);
		}
		else{
			throw new IllegalStateException("La propiedad no está disponible en las fechas indicadas.");
		}

	}

	public void cancelarReserva(Reserva reserva) {
		reserva.cancelar();
		reservas.remove(reserva);
	}


	public double calcularIngresos(DateLapse periodo){
		return this.alquileres.stream().filter(a -> a.estoyEnElPeriodo(periodo)).mapToDouble(Reserva::calcularPrecio).sum()*0.75;
	}
}
