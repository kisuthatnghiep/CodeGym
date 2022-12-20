package com.example.casestudy3.controller;

import com.example.casestudy3.DAO.AdminDAO;
import com.example.casestudy3.service.user.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    private UserService userService;
    private AdminDAO adminDAO;
    @Override
    public void init()  {
        userService = new UserService();
        adminDAO = new AdminDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action ="";
        }
        switch (action){
            case "detailUser": detailUser(request,response); break;
            case "deleteSongUser": deleteSongUser(request,response); break;

            default: homeUser(request,response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action ="";
        }
        switch (action){
            case "createPlayList": createPlayList(request,response); break;
            case "buySong": userBuySong(request,response); break;
            case "search": searchSong(request,response); break;
            case "searchDetail": searchSongDetail(request,response); break;
            case "addSongToPlayList":
                try {
                    addSongToPlayList(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "recharge":
                try {
                    recharge(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default: homeUser(request,response);
        }
    }
    private void createPlayList(HttpServletRequest request,HttpServletResponse response) throws IOException {
        userService.createPlayList(request);
        response.sendRedirect("/UserServlet?action=detailUser");
    }
    private void detailUser(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/detail_user/detail_user.jsp");
        request.setAttribute("user",userService.detailUser(request));
        request.setAttribute("listSongUser",userService.listSongByUser());
        request.setAttribute("listPlayListUser",userService.findPlaylistUser());
        request.setAttribute("sumPrice",userService.sumPriceBuySongUser());
        requestDispatcher.forward(request, response);

    }
    private void userBuySong(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        if (userService.buySong(request)){
            response.sendRedirect("/UserServlet");
        }else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/UserServlet");
            request.setAttribute("notify","Buy failed, because you don't have enough money");
            requestDispatcher.forward(request, response);
        }
    }
    private void searchSong(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("homeUser.jsp");
        request.setAttribute("listSong",  userService.searchSong(request));
        informationHomeUser(request);
        requestDispatcher.forward(request, response);
    }

    private void informationHomeUser(HttpServletRequest request) {
        request.setAttribute("listMapSinger", userService.mapListSinger());
        request.setAttribute("user", userService.detailUser(request));
        request.setAttribute("listPlayList", userService.findPlaylistUser());
        request.setAttribute("listMapSongPlayList", userService.searchMapSongByPlayList());
        request.setAttribute("listSongPlayList", userService.searchListSongByPlayList());
        request.setAttribute("mapPlayListDetail", userService.mapPlayListDetail());
    }

    private void homeUser(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("homeUser.jsp");
        request.setAttribute("listSong", userService.findAllSong());
        informationHomeUser(request);
        requestDispatcher.forward(request, response);
    }
    private void deleteSongUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
        userService.deleteSongUser(request);
        response.sendRedirect("/UserServlet");
    }
    private void addSongToPlayList(HttpServletRequest request,HttpServletResponse response) throws  SQLException {
        try {
            userService.addSongToPlayList(request);
            response.sendRedirect("/UserServlet?action=detailUser");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void recharge(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/detail_user/detail_user.jsp");
        request.setAttribute("user",userService.detailUser(request));
        request.setAttribute("listSongUser",userService.listSongByUser());
        request.setAttribute("listPlayListUser",userService.findPlaylistUser());
        request.setAttribute("sumPrice",userService.sumPriceBuySongUser());
        if (userService.recharge(request)){

        }else {
            request.setAttribute("notify","Recharge failed");
        }
        requestDispatcher.forward(request, response);
    }
    private void searchSongDetail(HttpServletRequest request,HttpServletResponse response) throws  IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("homeUser.jsp");
        request.setAttribute("listSong",  userService.searchSongDetail(request));
        informationHomeUser(request);
        requestDispatcher.forward(request, response);
    }
}