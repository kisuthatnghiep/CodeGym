package Minitest.minitest2.Employee;
import java.util.Comparator;

public class AgeComparator  implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1 instanceof EmployeeFullTime && o2 instanceof EmployeeFullTime){
            return Integer.compare(((EmployeeFullTime) o1).totalIncome(), ((EmployeeFullTime) o2).totalIncome());
        }
        return 0;
    }
}
