package com.example.thimodule3.Service;

import com.example.thimodule3.DAO.DepartmentDAO;
import com.example.thimodule3.DAO.EmployeeDAO;
import com.example.thimodule3.Model.Employee;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class EmployeeService {
    private EmployeeDAO employeeDAO;
    private DepartmentDAO departmentDAO;

    public EmployeeService() {
        employeeDAO = new EmployeeDAO();
        departmentDAO = new DepartmentDAO();
    }

    public List<Employee> findAll(HttpServletRequest request) {
        return employeeDAO.findAll();
    }


    public Employee findById(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        return employeeDAO.findEmployeeById(id);
    }


    public boolean save(HttpServletRequest request) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String salary = request.getParameter("salary");
        String department_id = request.getParameter("department_id");
        if (id == null) {
            return employeeDAO.createEmployee(new Employee(name,email,address,phone,Double.parseDouble(salary),departmentDAO.findDepartmentById(Long.parseLong(department_id))));
        } else {
            return employeeDAO.updateEmployee(new Employee(Long.parseLong(id),name,email,address,phone,Double.parseDouble(salary),departmentDAO.findDepartmentById(Long.parseLong(department_id))));
        }
    }

    public List<Employee> findByNameContaining(HttpServletRequest request) {
        String name = request.getParameter("search");
        return employeeDAO.findAllByNameContaining(name);
    }


    public boolean deleteById(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        return employeeDAO.deleteEmployee(id);
    }



}
