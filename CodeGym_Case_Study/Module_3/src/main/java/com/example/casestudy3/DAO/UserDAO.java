package com.example.casestudy3.DAO;

import com.example.casestudy3.connection.MyConnection;
import com.example.casestudy3.model.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAO {
    private Connection connection;
    private final String SELECT_SONG = "select s.id as id, s.name  as name, s.link as link, s.description as description," +
                                                    " s.price as price, s.singerId as singerId, s.status as status \n" +
                                                    "from singer join song s on singer.id = s.singerId \n"+
                                                    "where   singer.fullName = ? or s.name like concat('%',?,'%')\n"+
                                                    "and singer.status = 1\n"+
                                                    "group by s.id;";
    private final String SELECT_ALL_SONGS = "select s.id as id, s.name  as name, s.link as link, s.description as description," +
                                            " s.price as price, s.singerId as singerId, s.status as status \n" +
                                            "from song s join singer on s.singerId = singer.id\n" +
                                            "where singer.status = 1;";
    private final String INSERT_PLAYLIST = "insert into playlist (name,date,userId) value ( ? , ? , ? );";
    private final String USER_BY_SONG = "update users set wallet = ? where id = ?;";
    private final String SINGER_SELL_SONG = "update singer set income = ? where id = ?;";
    private final String INSERT_PLAYLISTDETAIL = "insert into playlistdetail (playlistId,songID,date,status) value ( ? , ? , ? , 1 );";
    private final String SELECT_USER_PLAYLIST = "select p.id, p.name, p.date \n" +
                                                "from users u join playlist p on u.id = p.userId\n" +
                                                "where u.id = ? ;";
    private final String SELECT_SONG_BY_USER = "select s.id as id, s.name  as name, s.link as link, s.description as description," +
                                                " s.price as price, s.singerId as singerId, s.status as status \n" +
                                                "from users u join playlist p on u.id = p.userId\n" +
                                                "join playlistdetail dtl on p.id = dtl.playlistId\n" +
                                                "join song s on dtl.songId = s.id\n" +
                                                "where u.id = ?\n" +
                                                "group by s.id;";
    private final String SELECT_SUM_PRICE_USER ="select s.price as sumPrice \n" +
                                                "from users u join playlist p on u.id = p.userId\n" +
                                                "join playlistdetail dtl on p.id = dtl.playlistId\n" +
                                                "join song s on dtl.songId = s.id\n" +
                                                "where u.id = ?\n" +
                                                "group by s.id;";
    private final String DELETE_SONG_PLAYLIST = "update playlistdetail set status = 0 where playlistId = ? & songId = ?;";
    private final String SELECT_PLAYLIST = "select * from playlistdetail where status = 1;";
    private final String UPDATE_WALLET = "update users set wallet = ? where id = ?;";
    private final String SELECT_ALL_SINGERS = "select * from singer where status = 1;";
    private final String SELECT_PLAYLISTDETAIL = "select * from playlistdetail dtl join song s on dtl.songId = s.id where dtl.status = 1 and s.status = 1;";
    private final String SELECT_SONG_BY_PLAYLIST =  "select s.id as id, s.name  as name, s.link as link, s.description as description," +
                                                    " s.price as price, s.singerId as singerId, s.status as status \n" +
                                                    "from singer join song s on singer.id = s.singerId\n" +
                                                    "join playlistdetail dtl on s.id = dtl.songId\n" +
                                                    "join playlist p on dtl.playlistId = p.id \n" +
                                                    "join users u on p.userId = u.id\n" +
                                                    "where singer.status = 1\n" +
                                                    "group by s.id;";
    private final String SELECT_SONG_DETAIL ="select s.id as id, s.name  as name, s.link as link, s.description as description," +
                                            " s.price as price, s.singerId as singerId, s.status as status\n" +
                                            "from singer join song s on singer.id = s.singerId\n" +
                                            "join playlistdetail dtl on s.id = dtl.songId\n" +
                                            "join playlist p on dtl.playlistId = p.id\n" +
                                            "join users u on p.userId = u.id\n" +
                                            "where (p.name  = ? or s.name like concat('%',?,'%'))\n" +
                                            "and (singer.status = 1 and u.id = ?)\n"+
                                            "group by s.id; ";

    public UserDAO() {
        connection =  MyConnection.getConnection();
    }
    public List<Song> findAllSong() {
        List<Song> songs = new ArrayList<Song>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SONGS)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                addListSong(songs, resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return songs;
    }
    public Map<Long,Song> listMapSongByPlayList() {
        Map<Long,Song> songs = new HashMap<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_SONG_BY_PLAYLIST)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String link = resultSet.getString("link");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                long singerId =  resultSet.getLong("singerId");
                int status = resultSet.getInt("status");
                songs.put(id,new Song(id, name,link,description,price,singerId,status ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return songs;
    }
    public List<Song> listSongByPlayList() {
        List<Song> songs = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_SONG_BY_PLAYLIST)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
               addListSong(songs, resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return songs;
    }
    public List<Song> searchSongDetail(String search, Long userId) {
        List<Song> songs = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_SONG_DETAIL)){
            statement.setString(1, search);
            statement.setString(2, search);
            statement.setLong(3, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                addListSong(songs, resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return songs;
    }
    public HashMap<Long,Long> mapPlayListDetail (){
        HashMap<Long,Long> mapPlayListDetail = new HashMap<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_PLAYLISTDETAIL)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                long playlistId = resultSet.getLong("playlistId");
                long songId = resultSet.getLong("id");
                long id = playlistId*10 + songId;
                mapPlayListDetail.put(id,playlistId);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return mapPlayListDetail;
    }
    public List<Song> searchSong(String search){
        List<Song> songs = new ArrayList<Song>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SONG)){
            preparedStatement.setString(1,search);
            preparedStatement.setString(2,search);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                addListSong(songs, resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return songs;
    }
    // Tao album cua user
    public void createPlayList(Playlist playlist){
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PLAYLIST)){
            preparedStatement.setString(1,playlist.getName());
            preparedStatement.setDate(2,playlist.getDate());
            preparedStatement.setLong(3,playlist.getUserId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//    public boolean userBuySong(double wallet,long id) throws SQLException {
//        try (PreparedStatement preparedStatement = connection.prepareStatement(USER_BY_SONG)){
//            preparedStatement.setDouble(1,wallet);
//            preparedStatement.setLong(2,id);
//            return preparedStatement.executeUpdate()>0;
//        }
//    }
//    public boolean singerSellSong(double income,long id) throws SQLException {
//        try (PreparedStatement preparedStatement = connection.prepareStatement(SINGER_SELL_SONG)){
//            preparedStatement.setDouble(1,income);
//            preparedStatement.setLong(2,id);
//            return preparedStatement.executeUpdate()>0;
//        }
//    }
    public void addPlayList(long playListId,long songId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PLAYLISTDETAIL)){
            preparedStatement.setLong(1,playListId);
            preparedStatement.setLong(2,songId);
            preparedStatement.setDate(3, Date.valueOf(LocalDate.now()));
            preparedStatement.executeUpdate();
        }
    }
    public boolean buySong(double wallet,double income,long playListId,long userId,long singerId,long songId){
        boolean flag = false;
        try (PreparedStatement preparedStatementUser = connection.prepareStatement(USER_BY_SONG);
             PreparedStatement preparedStatementSinger = connection.prepareStatement(SINGER_SELL_SONG);
             PreparedStatement preparedStatementPlayList = connection.prepareStatement(INSERT_PLAYLISTDETAIL)
        ){
            connection.setAutoCommit(false);
            preparedStatementUser.setDouble(1,wallet);
            preparedStatementUser.setLong(2,userId);
            preparedStatementSinger.setDouble(1,income);
            preparedStatementSinger.setLong(2,singerId);
            preparedStatementPlayList.setLong(1,playListId);
            preparedStatementPlayList.setLong(2,songId);
            preparedStatementPlayList.setDate(3, Date.valueOf(LocalDate.now()));
            if (preparedStatementUser.executeUpdate()>0 &&
                    preparedStatementSinger.executeUpdate()> 0 &&
                    preparedStatementPlayList.executeUpdate() > 0) {
                flag = true;
            }
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException sql) {
                e.printStackTrace();
            }
            e.printStackTrace();
        }
        return flag;
    }
    public List<Playlist> playlistUser( long userId) {
        List<Playlist> playList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_PLAYLIST)){
            preparedStatement.setLong(1,userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                long id = resultSet.getLong("p.id");
                String name = resultSet.getString("p.name");
                Date date = resultSet.getDate("p.date");
                playList.add(new Playlist(id, name, date));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return playList;
    }
    public List<Song> songByUser(long userId){
        List<Song> songs = new ArrayList<Song>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SONG_BY_USER)){
            preparedStatement.setLong(1,userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                addListSong(songs, resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return songs;
    }
    public double sumPriceBuySongUser(long userId){
        double sumPrice =0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SUM_PRICE_USER)){
            preparedStatement.setLong(1,userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                sumPrice += resultSet.getDouble("sumPrice") ;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sumPrice;
    }
    public void deleteSongByPlayList(long playlistId, long songId){
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SONG_PLAYLIST)){
            preparedStatement.setLong(1,playlistId);
            preparedStatement.setLong(2,songId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<PlaylistDetail> findAllPlayListDetail() {
        List<PlaylistDetail> playlistDetails = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PLAYLIST)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                long songId = rs.getLong("songId");
                long playListId = rs.getLong("playListId");
                int status = rs.getInt("status");
                Date date = rs.getDate("date");
                playlistDetails.add(new PlaylistDetail(songId, playListId,date,status));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return playlistDetails;
    }
    public boolean recharge(long userId, double wallet){
        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_WALLET)){
            preparedStatement.setDouble(1, wallet);
            preparedStatement.setLong(2, userId);
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Map<Long,Singer> mapListSinger(){
        Map<Long,Singer> singers = new HashMap<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SINGERS)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                long id = resultSet.getLong("id");
                String name = resultSet.getString("fullName");
                String account = resultSet.getString("userAccount");
                String password = resultSet.getString("userPassword");
                String phone = resultSet.getString("telephone");
                String email = resultSet.getString("email");
                double income = resultSet.getDouble("income");
                int status = resultSet.getInt("status");
                singers.put(id,new Singer(id, name,account,password,phone,email,income,status ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return singers;
    }

    private static void addListSong(List<Song> songs, ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String link = resultSet.getString("link");
        String description = resultSet.getString("description");
        double price = resultSet.getDouble("price");
        long singerId =  resultSet.getLong("singerId");
        int status = resultSet.getInt("status");
        songs.add(new Song(id, name,link,description,price,singerId,status ));
    }
}
