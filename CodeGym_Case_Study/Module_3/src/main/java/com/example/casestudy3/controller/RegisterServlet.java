package com.example.casestudy3.controller;
import com.example.casestudy3.DAO.AdminDAO;
import com.example.casestudy3.DAO.RegisterDAO;
import com.example.casestudy3.model.Singer;
import com.example.casestudy3.model.User;
import com.example.casestudy3.service.regex.Regex;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    private RegisterDAO registerDAO;
    private AdminDAO adminDAO;

    public Regex regex ;
    public void init() {
        registerDAO = new RegisterDAO();
        regex = new Regex();
        adminDAO = new AdminDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        if ("create".equals(action)) {
            createForm(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        if ("create".equals(action)) {
            create(request, response);
        }
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("register/register.jsp");
        requestDispatcher.forward(request,response);
    }
    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("passwordConfirm");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        String telephone = request.getParameter("telephone");
        if (account.equals(findUserByAccount(account))) {
            session.setAttribute("messageAccount", "**Tài khoản đã tồn tại");
            response.sendRedirect("http://localhost:8080/register/register.jsp");
        } else if (account.equals(findSingerByAccount(account))) {
            session.setAttribute("messageAccount", "**Tài khoản đã tồn tại");
            response.sendRedirect("http://localhost:8080/register/register.jsp");
        } else if (account.equals("admin")) {
            session.setAttribute("messageAccount", "**Tài khoản không được đặt tên là admin");
            response.sendRedirect("http://localhost:8080/register/register.jsp");
        } else if (!regex.validateAccount(account)) {
            session.setAttribute("messageAccount", "**Tài khoản phải có ít nhất 6 kí tự");
            response.sendRedirect("http://localhost:8080/register/register.jsp");
        } else if (!regex.validatePassword(password)) {
            session.setAttribute("messagePassword", "**Sai định dạng mật khẩu. Xin mời nhập lại");
            response.sendRedirect("http://localhost:8080/register/register.jsp");
        } else if (!password.equals(passwordConfirm)) {
            session.setAttribute("messagePasswordConfirm", "**Xác nhận mật khẩu không đúng. Xin mời nhập lại");
            response.sendRedirect("http://localhost:8080/register/register.jsp");
        } else if (!regex.validateEmail(email)) {
            session.setAttribute("messageEmail", "**Sai định dạng email. Xin mời nhập lại");
            response.sendRedirect("http://localhost:8080/register/register.jsp");
        } else if (!regex.validateTelephone(telephone)) {
            session.setAttribute("messageTelephone", "**Số điện thoại phải có 10 số !");
            response.sendRedirect("http://localhost:8080/register/register.jsp");
        }else if (role.equals("")) {
            session.setAttribute("messageRole", "**Xin chọn kiểu tài khoản mong muốn");
            response.sendRedirect("http://localhost:8080/register/register.jsp");
        } else if (role.equals("singer")) {
            Singer newSinger = new Singer(name, account, password, telephone, email, 0, 1);
            registerDAO.createSinger(newSinger);
            response.sendRedirect("http://localhost:8080/login/login.jsp");
        } else {
            User newUser = new User(name, account, password, telephone, email, 0, 1);
            registerDAO.createUser(newUser);
            response.sendRedirect("http://localhost:8080/login/login.jsp");
        }
    }

    private String findUserByAccount(String account) {
        for (User user: adminDAO.findAllUser()) {
            if (user.getAccount().equals(account)) {
                return account;
            }
        } return null;
    }

    private String findSingerByAccount(String account) {
        for (Singer singer: adminDAO.findAllSinger()) {
            if (singer.getAccount().equals(account)) {
                return account;
            }
        } return null;
    }
}
