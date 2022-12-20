package com.example.minitest.Controller;

import com.example.minitest.Model.Brand;
import com.example.minitest.Model.Product;
import com.example.minitest.Service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javafx.scene.input.KeyCode.R;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {

    private final ProductServiceImpl productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "delete":
                delete(request,response);
                break;
            case "showEditForm":
                showEditForm(request,response);
                break;
            default:
                displayListProduct(request,response);
        }
        response.sendRedirect("http://localhost:8080/products");
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
            case "update":
                update(request,response);
                break;
            default:
                displayListProduct(request,response);
        }
        response.sendRedirect("http://localhost:8080/products");
    }

    private void displayListProduct(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list-product.jsp");
        request.setAttribute("products",productService.findAll());
        requestDispatcher.forward(request, response);
    }
    private void create(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        List<Brand> brands = productService.findAllBrand();
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        String brand =request.getParameter("brand");
        for (Brand brand1: brands){
            if (brand1.getName().equals(brand)){
                productService.save(new Product(name,price,brand1,quantity));
                break;
            }
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        Long id = Long.parseLong(request.getParameter("id"));
        List<Product> products = productService.findAll();
        products.remove(productService.findById(id));
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        Long id = Long.parseLong(request.getParameter("id"));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("update-product.jsp");
        request.setAttribute("product",productService.findById(id));
        ArrayList<Brand> brands = new ArrayList<>();
        for (Brand brand: productService.findAllBrand()){
            if (!brand.getName().equals(productService.findById(id).getBrand().getName())){
                brands.add(brand);
            }
        }
        request.setAttribute("brands",brands);
        requestDispatcher.forward(request,response);
    }
    private void update(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        Long id = Long.parseLong(request.getParameter("id"));
        Product product = productService.findById(id);
        product.setName(request.getParameter("name"));
        product.setPrice(Double.parseDouble(request.getParameter("price")));
        product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        List<Brand> brands = productService.findAllBrand();
        for (Brand brand: brands){
            if (brand.getName().equals(request.getParameter("brand"))){
                product.setBrand(brand);
                break;
            }
        }
    }
}
