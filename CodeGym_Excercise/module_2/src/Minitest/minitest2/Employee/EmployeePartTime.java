package Minitest.minitest2.Employee;

public class EmployeePartTime extends Employee implements ToTalIncome{
    private int workingHour = 200;

    public EmployeePartTime() {
    }

    public EmployeePartTime(String employeeCode, String name, int age, int phoneNo, String email, int workingHour) {
        super(employeeCode, name, age, phoneNo, email);
        this.workingHour = workingHour;
    }

    public int getWorkingHour() {
        return workingHour;
    }

    public void setWorkingHour(int workingHour) {
        this.workingHour = workingHour;
    }

    @Override
    public int totalIncome() {
        return getWorkingHour() * 100000;
    }

    public String toString(){
        return super.toString() +", WorkingHour = " + workingHour + ", Total Income = " + totalIncome() + "}";
    }
}
