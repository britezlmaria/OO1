package org.example.ejercicio17;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {

    private DateLapse periodo;
    private Propiedad propiedad;
    private Usuario usuario;


    public Reserva(DateLapse periodo,Propiedad propiedad,Usuario usuario){
        this.periodo = periodo;
        this.propiedad=propiedad;
        this.usuario=usuario;
    }


    public double calcularPrecio(){
        int noches=periodo.sizeInDays();
        return noches*propiedad.getPrecio();
    }

    private void disponibilizarPropiedad(){
        this.propiedad.disponibilizar(this);
    }


    public boolean estoyEnElPeriodo(DateLapse periodo){
        return periodo.includesDate(this.periodo.getFrom())&&periodo.includesDate(this.periodo.getTo());
    }

    public boolean estoyEnCurso(){
        DateLapse date=new DateLapse(this.periodo.getFrom(),this.periodo.getTo());
        return date.includesDate(LocalDate.now());
    }
    public Propiedad getPropiedad(){
        return propiedad;
    }
    public void cancelarReserva(){
        if(!estoyEnCurso()){
            this.getPropiedad().disponibilizar(this);
        }
        else{
            System.out.println("No se puede cancelar el reserva");
        }
    }


}
