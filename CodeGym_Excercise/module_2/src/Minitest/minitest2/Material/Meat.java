package Minitest.minitest2.Material;

import java.time.LocalDate;
import java.time.Period;

public class Meat extends Material implements Discount{
        private double weight;

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public Meat(double weight) {
            this.weight = weight;
        }

        public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
            super(id, name, manufacturingDate, cost);
            this.weight = weight;
        }

        @Override
        public double getAmount() {
            return getCost()*getWeight();
        }

        @Override
        public LocalDate getExpiryDate() {
            return getManufacturingDate().plusDays(7);
        }

        @Override
        public double getRealMoney() {
            Period period = Period.between(LocalDate.now(), this.getExpiryDate());
            System.out.println(period.getDays());
            if (period.getDays() > 5){
                return this.getCost()* 0.1;
            }else if (period.getDays() > 0){
                return this.getCost()* 0.3;
            }else
                return this.getCost();
        }
}

