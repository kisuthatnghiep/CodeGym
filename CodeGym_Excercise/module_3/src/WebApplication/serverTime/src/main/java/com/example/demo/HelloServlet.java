package com.example.demo;

import java.io.*;
import java.util.Date;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        Date today = new Date();
        writer.println("<html>");
        writer.println("<h1>" + today + "</h1>");
        writer.println("</html>");

    }

    public void destroy() {
    }
}