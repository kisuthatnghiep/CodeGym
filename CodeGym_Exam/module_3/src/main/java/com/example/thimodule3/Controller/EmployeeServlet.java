package com.example.thimodule3.Controller;

import com.example.thimodule3.DAO.DepartmentDAO;
import com.example.thimodule3.Service.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EmployeeServlet", value = "/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeService();
    DepartmentDAO departmentDAO = new DepartmentDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "editForm":
                displayUpdateForm(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
            case "openCreate":
                openCreate(request,response);
                break;
            default:
                displayListEmployee(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                create(request, response);
                break;
            case "edit":
                update(request,response);
                break;
            case "search":
                search(request,response);
                break;
        }
    }


    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        employeeService.save(request);
        response.sendRedirect("http://localhost:8080/EmployeeServlet");
    }

    private void openCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("addEmployee.jsp");
        request.setAttribute("department",departmentDAO.findAll());
        requestDispatcher.forward(request,response);
    }

        private void displayListEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("displayEmployee.jsp");
        request.setAttribute("employees", employeeService.findAll(request));
        requestDispatcher.forward(request, response);
    }
    private void displayUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("editEmployee.jsp");
        request.setAttribute("department",departmentDAO.findAll());
        request.setAttribute("employee", employeeService.findById(request));
        requestDispatcher.forward(request, response);
    }
    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        employeeService.save(request);
        response.sendRedirect("http://localhost:8080/EmployeeServlet");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        employeeService.deleteById(request);
        response.sendRedirect("http://localhost:8080/EmployeeServlet");
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws  ServletException,IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("displayEmployee.jsp");
        request.setAttribute("employees", employeeService.findByNameContaining(request));
        requestDispatcher.forward(request, response);
    }
    }
