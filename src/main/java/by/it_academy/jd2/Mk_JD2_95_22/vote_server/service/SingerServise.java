package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.ISingerDAO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Singers;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.fabrics.SingerDaoSingleton;


import java.util.Iterator;
import java.util.List;

public class SingerServise {
    private final ISingerDAO iDaoSinger;

    public SingerServise(ISingerDAO iDaoSinger) {
        this.iDaoSinger = SingerDaoSingleton.getInstance();
    }
    public List<Singers> get(){

        return iDaoSinger.getAllSinger();
    }


    public String getNameSinger(long id){

    }

    public boolean created(String newNameSinger, Singers singers){
        List<Singers> list=get();
        Iterator <Singers> iterator=list.iterator();
        if(!iterator.hasNext()){
            iterator.next().setNameArtist(newNameSinger);
            for(Singers item: list){
                if(!newNameSinger.equals(singers.getNameArtist())){
                    list.add(singers);
                }
            }
        }
        return  iDaoSinger.created(newNameSinger);
    }


    public List<Singers> update(long id){
        List<Singers> list=get();
        if (iDaoSinger.exist(id)){
            Singers singers=new Singers();
            iDaoSinger.update(singers);
        } else {
            throw new IllegalArgumentException("С таким " + id + " исполнителя не найдено");
        }
     return list;
    }

    public boolean delete(long id){
        List<Singers> list=get();
        if (iDaoSinger.exist(id)){
            iDaoSinger.delete(id);
        }else {
            throw new IllegalArgumentException("С таким " + id + " исполнителя не найдено");
        }
        return iDaoSinger.delete(id);
    }

    public boolean exist(long id){
        List<Singers> listSingers=iDaoSinger.getAllSinger();
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

