package com.example.thimodule3.DAO;

import com.example.thimodule3.Connection.MyConnection;
import com.example.thimodule3.Model.Department;
import com.example.thimodule3.Model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private DepartmentDAO departmentDAO;
    private Connection connection;
    private final String SELECT_ALL_EMPLOYEES = "select * from employee;";
    private final String SELECT_EMPLOYEE_BY_ID = "select * from employee where id = ?;";
    private final String INSERT_EMPLOYEE = "insert into employee(name, email, address, phone, salary, department_id) value (?,?,?,?,?,?);";
    private final String UPDATE_EMPLOYEE = "update employee set name = ?, email = ?, address = ?, phone = ?, salary = ?,department_id = ? where id = ?;";
    private final String DELETE_EMPLOYEE = "delete from employee where id = ?;";
    private final String SELECT_EMPLOYEE_BY_NAME = "select * from employee where name like ?;";

    public EmployeeDAO(){
        connection = MyConnection.getConnection();
        departmentDAO = new DepartmentDAO();
    }

    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        try(PreparedStatement preparedStatement =
                    connection.prepareStatement(SELECT_ALL_EMPLOYEES)) {
            getListEmployee(employees, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public List<Employee> findAllByNameContaining(String nameSearch) {
        List<Employee> employees = new ArrayList<>();
        try(PreparedStatement preparedStatement =
                    connection.prepareStatement(SELECT_EMPLOYEE_BY_NAME)) {
            preparedStatement.setString(1, "%" + nameSearch + "%");
            getListEmployee(employees, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public Employee findEmployeeById(Long id) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(SELECT_EMPLOYEE_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                double salary = resultSet.getDouble("salary");
                Long department_id = resultSet.getLong("department_id");
                Department department = departmentDAO.findDepartmentById(department_id);
                return new Employee(id, name, email, address,phone, salary, department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean createEmployee(Employee employee) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(INSERT_EMPLOYEE)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setDouble(5, employee.getSalary());
            preparedStatement.setLong(6, employee.getDepartment().getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateEmployee(Employee employee) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(UPDATE_EMPLOYEE)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setDouble(5, employee.getSalary());
            preparedStatement.setLong(6, employee.getDepartment().getId());
            preparedStatement.setLong(7,employee.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteEmployee(Long id) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(DELETE_EMPLOYEE)) {
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void getListEmployee(List<Employee> employees, PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Long id = Long.parseLong(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String address = resultSet.getString("address");
            String phone = resultSet.getString("phone");
            double salary = Double.parseDouble(resultSet.getString("salary"));
            Long department_id = Long.parseLong(resultSet.getString("department_id"));
            Department department = departmentDAO.findDepartmentById(department_id);
            employees.add(new Employee(id, name, email, address,phone, salary, department));
        }
    }
}
