package com.example.module_4.service;

import com.example.module_4.model.Branch;
import com.example.module_4.model.Employee;
import com.example.module_4.repository.IBranchRepository;
import com.example.module_4.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;
    @Autowired
    private IBranchRepository branchRepository;

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public boolean save(Employee employee) {
        if (employee.getId() == null) {
            if (check(employee.getCode())) {
                employeeRepository.save(employee);
                return true;
            } else {
                return false;
            }
        }
        employeeRepository.save(employee);
        return true;
    }

    @Override
    public void remove(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    @Cacheable(value = "employeeListBybranch", key = "#branch.id")
    public List<Employee> findAllByBranch(Branch branch) {
        return employeeRepository.findAllByBranch(branch);
    }

    @Override
    public List<Employee> sortByAge() {
        return employeeRepository.sortByAge();
    }

    private boolean check(String code){
        Iterable<Employee> employees = findAll();
        for(Employee employee: employees){
            if (employee.getCode().equals(code)){
                return false;
            }
        }
        return true;
    }

    @Override
    public void render() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            Employee employee = new Employee();
            employee.setName("Javis " + i);
            employee.setCode("MNV" + i);
            employee.setAge(random.nextInt(40) + 20);
            employee.setSalary(random.nextDouble() * 5000 + 3000);
            employee.setBranch(branchRepository.findById((long) (random.nextInt(3) + 1)).orElse(null));
            employeeRepository.save(employee);
        }
    }
}
