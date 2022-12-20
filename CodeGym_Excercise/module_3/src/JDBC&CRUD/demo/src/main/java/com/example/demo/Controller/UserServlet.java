package com.example.demo.Controller;

import com.example.demo.DAO.UserDAO;
import com.example.demo.Model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/users")
public class UserServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init(){
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                case "sortByName":
                    sortByName(request,response);
                    break;
                default:
                    listUsers(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertUser(request, response);
                    break;
                case "searchByCountry":
                    searchByCountry(request,response);
                    break;
                case "edit":
                    updateUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> listUser = userDAO.selectAllUser();
        request.setAttribute("listUser",listUser);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/list.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/create.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDAO.selectUser(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/edit.jsp");
        request.setAttribute("user",user);
        requestDispatcher.forward(request,response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException,ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name, email, country);
        userDAO.insertUsers(user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/create.jsp");
        requestDispatcher.forward(request,response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException,ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id, name, email, country);
        userDAO.updateUser(user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/edit.jsp");
        requestDispatcher.forward(request,response);
    }
    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException,ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.deleteUser(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/list.jsp");
        List<User> users = userDAO.selectAllUser();
        request.setAttribute("listUser", users);
        requestDispatcher.forward(request,response);
    }

    private void searchByCountry(HttpServletRequest request, HttpServletResponse response) throws SQLException,ServletException, IOException {
        String country = request.getParameter("country");
        List<User> users = userDAO.searchByCountry(country);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/list.jsp");
        request.setAttribute("listUser",users);
        requestDispatcher.forward(request,response);
    }

    private void sortByName(HttpServletRequest request, HttpServletResponse response) throws SQLException,ServletException, IOException {
        List<User> users = userDAO.sortByName();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/list.jsp");
        request.setAttribute("listUser",users);
        requestDispatcher.forward(request,response);
    }

    }
