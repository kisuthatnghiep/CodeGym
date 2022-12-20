package com.example.demo1;

import jdk.nashorn.internal.ir.RuntimeNode;
import sun.misc.Request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TranslateServlet", value = "/translate")
public class TranslateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String> dictionary = new HashMap<>();
        dictionary.put("mom","mẹ");
        dictionary.put("dad","bố");
        dictionary.put("sister","chị");
        dictionary.put("brother","anh");
        String search = request.getParameter("word");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        String result = dictionary.get(search);
        if (result != null){
            writer.println("Word: " + search);
            writer.println("Result: " + result);
        }else {
            writer.println("Not Found");
        }
        writer.println("</html>");
    }
}
