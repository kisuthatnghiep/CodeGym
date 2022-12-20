package com.example.casestudy3.service.admin;

import com.example.casestudy3.DAO.AdminDAO;
import com.example.casestudy3.DAO.UserDAO;
import com.example.casestudy3.model.Singer;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AdminService {
    private UserDAO userDAO;
    private AdminDAO adminDAO;

    public AdminService() {
        userDAO = new UserDAO();
        adminDAO = new AdminDAO();
    }
    public List<Singer> findAllSinger(){
       return adminDAO.findAllSinger();
    }
    public double totalPrice(){
        return adminDAO.totalPrice()/0.8;
    }
    public boolean deleteSinger(HttpServletRequest request){
        long singerId = Long.parseLong(request.getParameter("singerId"));
        return adminDAO.deleteSingerByAdmin(singerId);
    }
    public double sumPriceByDate(HttpServletRequest request){
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        if  (month.equals("0")){
            return adminDAO.sumPriceByYear(year);
        }else {
            return adminDAO.sumPriceByDate(month, year);
        }
    }
}
