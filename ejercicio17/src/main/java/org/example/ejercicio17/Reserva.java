package org.example.ejercicio17;

import java.time.temporal.ChronoUnit;

public class Reserva {

    private DateLapse periodo;
    private Propiedad propiedad;



    public Reserva(DateLapse periodo,Propiedad propiedad){
        this.periodo = periodo;
        this.propiedad=propiedad;
    }


    public double calcularPrecio(){
        int noches=periodo.sizeInDays()-1;
        return noches*propiedad.getPrecio();
    }

    public void cancelar(){
        this.propiedad.disponibilizar(this.periodo);
    }


    public boolean estoyEnElPeriodo(DateLapse periodo){
        return periodo.includesDate(this.periodo.getFrom())&&periodo.includesDate(this.periodo.getTo());
    }
}
