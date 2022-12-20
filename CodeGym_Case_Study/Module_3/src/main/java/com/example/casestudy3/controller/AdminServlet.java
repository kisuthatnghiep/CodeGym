package com.example.casestudy3.controller;

import com.example.casestudy3.service.admin.AdminService;
import com.example.casestudy3.service.user.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    private AdminService adminService;
    @Override
    public void init()  {
        adminService = new AdminService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "deleteSinger": deleteSinger(request, response);break;
            default: homeAdmin(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "priceByDate" : homeAdmin(request, response);
        }
    }
    private void homeAdmin(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("homeAdmin.jsp");
        request.setAttribute("totalPrice",adminService.totalPrice());
        request.setAttribute("sumPriceByDate",adminService.sumPriceByDate(request));
        request.setAttribute("listSinger",adminService.findAllSinger());
        requestDispatcher.forward(request,response);
    }
    private void deleteSinger(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        adminService.deleteSinger(request);
        response.sendRedirect("http://localhost:8080/AdminServlet");
    }

}
