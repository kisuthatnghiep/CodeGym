package com.example.module_4.service;

import com.example.module_4.model.Branch;
import com.example.module_4.model.Employee;

import java.util.List;

public interface IEmployeeService extends IGeneralService<Employee> {
    List<Employee> findAllByBranch(Branch branch);
    List<Employee> sortByAge();
    void render();
}
