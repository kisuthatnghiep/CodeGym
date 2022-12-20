package com.example.casestudy3.controller;

import com.example.casestudy3.DAO.AdminDAO;
import com.example.casestudy3.service.login.LoginService;
import com.example.casestudy3.service.singerService.SingerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SingerServlet", value = "/SingerServlet")
public class SingerServlet extends HttpServlet {
    SingerService singerService = new SingerService();
    AdminDAO adminDAO = new AdminDAO();
    LoginService loginService = new LoginService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action){
            case "delete":
                delete(request,response);
                break;
            default:
                displayListSong(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action){
            case "createSong":
                createSong(request,response);
                break;
            default:
                displayListSong(request,response);
        }
    }

    private void createSong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        singerService.createSong(request);
        response.sendRedirect("http://localhost:8080/SingerServlet");

    }

    private void displayListSong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("homeSinger.jsp");
        request.setAttribute("listSong", singerService.findAllSingerSong());
        request.setAttribute("singer",adminDAO.findByIdSinger(loginService.checkOnline()));
        requestDispatcher.forward(request,response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        singerService.deleteById(request);
        response.sendRedirect("http://localhost:8080/SingerServlet");
    }
}
