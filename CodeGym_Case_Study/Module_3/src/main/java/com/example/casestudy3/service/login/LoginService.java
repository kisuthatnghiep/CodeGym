package com.example.casestudy3.service.login;

import com.example.casestudy3.DAO.AdminDAO;
import com.example.casestudy3.model.Singer;
import com.example.casestudy3.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;;import java.io.IOException;

public class LoginService<E> {
    private static long userID;
    private AdminDAO adminDAO;

    public LoginService() {
        adminDAO = new AdminDAO();
    }
    public Long checkOnline(){
        return userID;
    }

    public int logIn(HttpServletRequest request) {
        HttpSession session = request.getSession();
        boolean flagAccount = false;
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        if (account.equals("admin") && password.equals("admin")){
            return 1;
        } else {
            for (User user : adminDAO.findAllUser()) {
                if (account.equals(user.getAccount())) {
                    flagAccount = true;
                    if (password.equals(user.getPassword())) {
                        userID = user.getId();
                        return 2;
                    }
                }
            }
            for (Singer singer : adminDAO.findAllSinger()){
                if (account.equals(singer.getAccount())){
                    flagAccount = true;
                    if (password.equals(singer.getPassword())) {
                        userID = singer.getId();
                        return  3;
                    }
                }
            }
        }
        if (!flagAccount) {
            session.setAttribute("messageLoginAccount", "**Tài khoản không tồn tại");
        } else {
            session.setAttribute("messageLoginPassword", "**Mật khẩu không đúng");
        }
        return 0;
    }


    public void registration(HttpServletRequest request){

    }
}
