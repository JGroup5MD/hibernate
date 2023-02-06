package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.SingerDAO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IDaoSinger;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Singers;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.SingerDTO;

import java.util.List;

public class SingerServise {
    private final IDaoSinger iDaoSinger;

    public SingerServise(IDaoSinger iDaoSinger) {
        this.iDaoSinger = iDaoSinger;
    }
    public List<Singers> get(){
        return iDaoSinger.get();
    }
    public boolean created(String newNameSinger){
        return iDaoSinger.created(newNameSinger);
    }
    public List<SingerDTO> update(Long id){
        return iDaoSinger.update();
    }

    public boolean delete(long id){
        return iDaoSinger.delete(id);
    }
    public boolean exist(long id){
        List<Singers> listSingers=iDaoSinger.get();
        for(Singers element:listSingers) {
            if(id == element.getId()) {
                return  true;
            }
        }
        return false;
    }
    public boolean validate(String SingerName) {
        List<Singers> listSingers = iDaoSinger.get();
        return true;
    }
    }

