package org.example.ejercicio17;

import java.util.List;
import java.util.ArrayList;
public class Usuario {

	private String nombre;
	private String direccion;
	private int DNI;
	private List<Propiedad>alquileres;




	public Usuario(String nombre, String direccion, int DNI) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.DNI = DNI;
		this.alquileres = new ArrayList<>();
	}



	public double calcularIngresos(DateLapse periodo){
		return this.alquileres.stream().mapToDouble(a -> a.tengoReservasEnPeriodo(periodo)).sum()*0.75;
	}
}
