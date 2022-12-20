package com.example.casestudy3.DAO;
import com.example.casestudy3.connection.MyConnection;
import com.example.casestudy3.model.Singer;
import com.example.casestudy3.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {
    private Connection connection;
    private final String INSERT_USER = "insert into " +
            "users(userAccount, userPassword, fullName, telephone, email, wallet, status) value (?,?,?,?,?,?,?);";
    private final String INSERT_SINGER = "insert into " +
            "singer(userAccount, userPassword, fullName, telephone, email, income, status) value (?,?,?,?,?,?,?);";
    public RegisterDAO() {
        connection = MyConnection.getConnection();
    }
    public void createUser(User user) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(INSERT_USER)) {
            preparedStatement.setString(1, user.getAccount());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setDouble(6, user.getWallet());
            preparedStatement.setInt(7,user.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void createSinger(Singer singer) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(INSERT_SINGER)) {
            preparedStatement.setString(1, singer.getAccount());
            preparedStatement.setString(2, singer.getPassword());
            preparedStatement.setString(3, singer.getName());
            preparedStatement.setString(4, singer.getPhone());
            preparedStatement.setString(5, singer.getEmail());
            preparedStatement.setDouble(6, singer.getIncome());
            preparedStatement.setInt(7,singer.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
