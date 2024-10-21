package org.example.ejercicio17;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


    public class DateLapse implements DateCalculator{

        private LocalDate from;
        private LocalDate to;


        public DateLapse(LocalDate from, LocalDate to) {
            if (from.isAfter(to)) {
                throw new IllegalArgumentException("La fecha 'from' debe ser anterior o igual a la fecha 'to'.");
            }
            this.from = from;
            this.to = to;
        }


        public LocalDate getFrom() {
            return from;
        }

        public LocalDate getTo() {
            return to;
        }

        @Override
        public int sizeInDays(){
            return (int) ChronoUnit.DAYS.between(this.getFrom(),this.getTo());
        }

        @Override
        public boolean includesDate(LocalDate other){
            return (other.isEqual(this.getFrom()) || other.isAfter(this.getFrom())) &&
                    (other.isEqual(this.getTo()) || other.isBefore(this.getTo()));
        }
    }


