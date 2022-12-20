package Minitest.minitest2.Material;

import java.time.LocalDate;
import java.time.Period;


    public class CrispyFlour extends Material implements Discount{
        private int quantity;

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public CrispyFlour(int quantity) {
            this.quantity = quantity;
        }

        public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
            super(id, name, manufacturingDate, cost);
            this.quantity = quantity;
        }

        @Override
        public double getAmount() {
            return getQuantity()*getCost();
        }

        @Override
        public LocalDate getExpiryDate() {
            return getManufacturingDate().plusYears(1);
        }

        @Override
        public double getRealMoney() {
            Period period = Period.between(LocalDate.now(), this.getExpiryDate());
            System.out.println(period.getMonths());
            if (period.getYears() * 12 + period.getMonths() > 4){
                return this.getCost() * 0.05;
            }else if(period.getYears() * 12 + period.getMonths() > 2){
                return this.getCost() * 0.2;
            }else if(period.getYears() * 12 + period.getMonths() > 0){
                return this.getCost() * 0.4;
            }else return this.getCost();
        }
    }
