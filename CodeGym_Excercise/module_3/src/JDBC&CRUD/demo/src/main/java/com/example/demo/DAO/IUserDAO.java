package com.example.demo.DAO;

import com.example.demo.Model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public void insertUsers(User user) throws SQLException;
    public User selectUser(int id);
    public List<User> selectAllUser();
    public boolean deleteUser(int id) throws SQLException;
    public boolean updateUser(User user) throws SQLException;
}

