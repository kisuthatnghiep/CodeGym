package com.example.casestudy3.DAO;

import com.example.casestudy3.connection.MyConnection;
import com.example.casestudy3.model.Singer;
import com.example.casestudy3.model.Song;
import com.example.casestudy3.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {
    private Connection connection;
    private UserDAO userDAO;
    private final String SELECT_ALL_USERS = "select * from users where status = 1;";
    private final String SELECT_ALL_SINGERS = "select * from singer where status = 1;";
    private final String TOTAL_PRICE = "select sum(singer.income) as totalPrice\n" +
                                        "from singer ;";
    private final String DELETE_SINGER = "update singer set status = 0 where id = ? ;";
    private final String SUM_PRICE_BY_DATE = "select sum(price) as sumPrice from song\n" +
            "join playlistdetail on song.id = playlistdetail.songid\n" +
            "where year(playlistdetail.date) = ? and month(playlistdetail.date) = ?;";
    private final String SUM_PRICE_BY_YEAR = "select sum(price) as sumPrice from song\n" +
            "join playlistdetail on song.id = playlistdetail.songid\n" +
            "where year(playlistdetail.date) = ?;";
    public AdminDAO() {
        connection = MyConnection.getConnection();
        userDAO = new UserDAO();
    }
    public List<User> findAllUser() {
        List<User> users = new ArrayList<User>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_USERS)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("fullName");
                String account = resultSet.getString("userAccount");
                String password = resultSet.getString("userPassword");
                String phone = resultSet.getString("telephone");
                String email = resultSet.getString("email");
                double wallet = resultSet.getDouble("wallet");
                int status = resultSet.getInt("status");
                users.add(new User(id, name,account,password,phone,email,wallet,status ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
    public List<Singer> findAllSinger() {
        List<Singer> singers = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SINGERS)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("fullName");
                String account = resultSet.getString("userAccount");
                String password = resultSet.getString("userPassword");
                String phone = resultSet.getString("telephone");
                String email = resultSet.getString("email");
                double income = resultSet.getDouble("income");
                int status = resultSet.getInt("status");
                singers.add(new Singer(id, name,account,password,phone,email,income,status ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return singers;
    }
    public User findByIdUser(long id) {
        for (User u : findAllUser()){
            if (u.getId() == id){
                return u;
            }
        }
        return null;
    }
    public Singer findByIdSinger(long id) {
        for (Singer s : findAllSinger()){
            if (s.getId() == id){
                return s;
            }
        }
        return null;
    }
    public Singer findByNameSinger(String name) {
        for (Singer s : findAllSinger()){
            if (s.getName().equals(name)){
                return s;
            }
        }
        return null;
    }
    public Song findByIdSong(long id) {
        for (Song s : userDAO.findAllSong()){
            if (s.getId() == id){
                return s;
            }
        }
        return null;
    }
    public double totalPrice(){
        double totalPrice = 0;
        try(PreparedStatement preparedStatement = connection.prepareStatement( TOTAL_PRICE)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                totalPrice += resultSet.getDouble("totalPrice");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  totalPrice;
    }
    public double sumPriceByDate(String month, String year){
        double sumPrice = 0;
        try(PreparedStatement preparedStatement = connection.prepareStatement(SUM_PRICE_BY_DATE)){
            preparedStatement.setString(1, year);
            preparedStatement.setString(2, month);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                sumPrice += resultSet.getDouble("sumPrice");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  sumPrice;
    }
    public double sumPriceByYear(String year){
        double sumPrice = 0;
        try(PreparedStatement preparedStatement = connection.prepareStatement(SUM_PRICE_BY_YEAR)){
            preparedStatement.setString(1, year);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                sumPrice += resultSet.getDouble("sumPrice");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  sumPrice;
    }
    public boolean deleteSingerByAdmin(long singerId){
        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SINGER)){
            preparedStatement.setLong(1,singerId);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
