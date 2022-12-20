package com.example.casestudy3.service.singerService;

import com.example.casestudy3.DAO.SingerDAO;
import com.example.casestudy3.model.Singer;
import com.example.casestudy3.model.Song;
import com.example.casestudy3.service.login.LoginService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class SingerService {

    SingerDAO singerDAO = new SingerDAO();
    LoginService loginService = new LoginService();

    public void createSong(HttpServletRequest request){
        String name = request.getParameter("nameSong");
        String url = request.getParameter("url");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        singerDAO.createSong(new Song(name,url,description,price,loginService.checkOnline(),1));
    }

    public List<Song> findAllSingerSong(){
        return singerDAO.listSingerSong(findSingerById());
    }

    private Singer findSingerById() {
        for (Singer singer: singerDAO.findAllSinger()){
            if (singer.getId() == loginService.checkOnline()){
                return singer;
            }
        }
        return null;
    }

    public void deleteById(HttpServletRequest request){
        Long id = Long.parseLong(request.getParameter("id"));
        singerDAO.deleteSong(id);
    }
}
