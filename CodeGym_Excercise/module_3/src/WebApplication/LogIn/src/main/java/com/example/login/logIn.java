package com.example.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "logIn", value = "/logIn")
public class logIn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        if (userName.equals("admin") && password.equals("admin")){
            writer.println("<h1>Welcome " + userName + " to website<h1>");
        }else {
            writer.println("<h1>Log In error</h1>");
        }
        writer.println("</html>");
    }
}
