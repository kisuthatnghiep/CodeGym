package Minitest.minitest2.Employee;


public class EmployeeFullTime extends Employee implements ToTalIncome{
        private int bonus = 1000;
        private int fine = 500;
        private int salary = 1000000;

        public EmployeeFullTime() {
        }

        public EmployeeFullTime(String employeeCode, String name, int age, int phoneNo, String email, int bonus, int fine, int salary) {
            super(employeeCode, name, age, phoneNo, email);
            this.bonus = bonus;
            this.fine = fine;
            this.salary = salary;
        }

        public int getBonus() {
            return bonus;
        }

        public void setBonus(int bonus) {
            this.bonus = bonus;
        }

        public int getFine() {
            return fine;
        }

        public void setFine(int fine) {
            this.fine = fine;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

    @Override
    public int totalIncome() {
        return getSalary() - getFine() + getBonus();
    }

    public String toString(){
            return super.toString() + ", Salary = " + salary + " Bonus = " + bonus +
                    " Fine = " + fine + ", Total Income = " + totalIncome() + "}";
    }
}
