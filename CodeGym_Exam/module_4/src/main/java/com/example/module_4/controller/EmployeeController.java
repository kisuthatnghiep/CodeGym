package com.example.module_4.controller;

import com.example.module_4.model.Branch;
import com.example.module_4.model.Employee;
import com.example.module_4.service.IBranchService;
import com.example.module_4.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IBranchService branchService;

    @GetMapping
    public ResponseEntity<Object> display() {
        Iterable<Employee> employees = employeeService.findAll();
        List<Object> list = new ArrayList<>();
        list.add(employees);
        Iterable<Branch> branches = branchService.findAll();
        list.add(branches);
        if (employees.iterator().hasNext()) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Employee employee) {
        if (employeeService.save(employee)){
        return new ResponseEntity<>("Create successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Employee employee) {
        Optional<Employee> oldEmployee = employeeService.findById(id);
        if (oldEmployee.isPresent()) {
            if (employeeService.save(employee)) {
                return new ResponseEntity<>("Update successfully!", HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Optional<Employee> oldEmployee = employeeService.findById(id);
        if (oldEmployee.isPresent()) {
            employeeService.remove(id);
            return new ResponseEntity<>("Delete employee successfully!", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> findOne(@PathVariable Long id) {
        Optional<Employee> oldEmployee = employeeService.findById(id);
        if (oldEmployee.isPresent()) {
            return new ResponseEntity<>(oldEmployee.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/branch/{id}")
    public ResponseEntity<Iterable<Employee>> findByBranch(@PathVariable Long id) {
        Branch branch = branchService.findById(id).get();
        List<Employee> employees = employeeService.findAllByBranch(branch);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/sort")
    public ResponseEntity<Iterable<Employee>> sort(){
        List<Employee> employees = employeeService.sortByAge();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/render")
    public ResponseEntity<String> render() {
        employeeService.render();
        return new ResponseEntity<>("Done!", HttpStatus.OK);
    }
}
