package org.example.ejercicio17;

    import java.time.LocalDate;

    public interface DateCalculator {

        public int sizeInDays();

        public boolean includesDate(LocalDate date);
    }

