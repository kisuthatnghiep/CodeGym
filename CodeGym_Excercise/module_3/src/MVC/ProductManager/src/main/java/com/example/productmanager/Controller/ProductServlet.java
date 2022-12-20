package com.example.productmanager.Controller;

import com.example.productmanager.Model.Product;
import com.example.productmanager.Service.ProductService;
import com.example.productmanager.Service.ProductServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {

    private ProductService productService = new ProductServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "update":
            case "delete":
            case "view":
            default:
                listCustomer(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                create(request,response);
                break;
            default:
                listCustomer(request,response);
                break;
        }
    }

    private void listCustomer(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.findAll();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product.jsp");
        request.setAttribute("products", products);
        requestDispatcher.forward(request,response);
    }

    private void create(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String producer = request.getParameter("producer");
        productService.save(new Product(id, name, price, description, producer));
        response.sendRedirect("http://localhost:8080/products");
    }
}
