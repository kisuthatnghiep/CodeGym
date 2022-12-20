package com.example.casestudy3.DAO;

import com.example.casestudy3.connection.MyConnection;
import com.example.casestudy3.model.Singer;
import com.example.casestudy3.model.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SingerDAO {
    private Connection connection;

    private final String CREATE_SONG = "insert into song(name, link, description, price, singerId, status)" +
            "values(?,?,?,?,?,?);";
    private final String DELETE_SONG = "update song set status = 0 where id = ?;";

    private final String LIST_SINGER_SONG = "select song.id, song.name,song.link, song.price, song.description from song where status = 1 and singerId = ?;";
    private final String FIND_ALL_SINGER = "select * from singer;";
    public SingerDAO() {
        connection =  MyConnection.getConnection();
    }

    public void createSong(Song song){
        try(PreparedStatement preparedStatement = connection.prepareStatement(CREATE_SONG)){
            preparedStatement.setString(1, song.getName());
            preparedStatement.setString(2, song.getLink());
            preparedStatement.setString(3, song.getDescription());
            preparedStatement.setDouble(4, song.getPrice());
            preparedStatement.setLong(5, song.getSingerId());
            preparedStatement.setInt(6, song.getStatus());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteSong(Long id){
        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SONG)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Song> listSingerSong(Singer singer){
            List<Song> songs = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(LIST_SINGER_SONG)){
            preparedStatement.setLong(1,singer.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String link = resultSet.getString("link");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                songs.add(new Song(id, name,link, description, price));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return songs;
    }

    public List<Singer> findAllSinger(){
        List<Singer> singers = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SINGER)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");

                String account = resultSet.getString("userAccount");
                String password = resultSet.getString("userPassword");
                String email = resultSet.getString("email");
                String name = resultSet.getString("fullName");
                String phone = resultSet.getString("telephone");
                double income = resultSet.getDouble("income");
                int status = resultSet.getInt("status");
                singers.add(new Singer(id,name,account,password,phone,email,income,status));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return singers;
    }
}
