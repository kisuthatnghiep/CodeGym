package com.example.module_4.service;

import com.example.module_4.model.Branch;
import com.example.module_4.model.Employee;
import com.example.module_4.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;
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
}
