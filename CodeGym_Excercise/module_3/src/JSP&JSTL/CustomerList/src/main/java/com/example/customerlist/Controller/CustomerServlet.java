package com.example.customerlist.Controller;

import com.example.customerlist.Model.Customer;
import com.example.customerlist.Service.CustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CustomerServlet", value = "/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerService customerService = new CustomerService();
        ArrayList<Customer> customers = customerService.display();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Customer.jsp");
        request.setAttribute("customers",customers);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
