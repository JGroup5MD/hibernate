package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.implementation;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.ISingerDAO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.SingersEntity;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.ISingerService;


import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class SingerServise implements ISingerService {
    private final ISingerDAO iDaoSinger;

    public SingerServise(ISingerDAO iDaoSinger) {
        this.iDaoSinger = iDaoSinger;
    }

    public List<SingersEntity> get(){

        return iDaoSinger.getAllSinger();
    }


    public String getNameSinger(long id) {
        List<SingersEntity> list = get();
        for (SingersEntity element : list) {
            if (Objects.equals(element.getId(), id)) {

            }else {
                throw new IllegalArgumentException("С таким " + id + " исполнителя не найдено");
            }
        }
        return getNameSinger(id);
    }

    public boolean created(String newNameSinger){
       SingersEntity singers=new SingersEntity();
        List<SingersEntity> list=get();
        Iterator <SingersEntity> iterator=list.iterator();
        if(!iterator.hasNext()){
            iterator.next().setNameArtist(newNameSinger);
            for(SingersEntity item: list){
                if(!newNameSinger.equals(singers.getNameArtist())){
                    list.add(singers);
                }
            }
        }
        return  iDaoSinger.created(newNameSinger);
    }


    public List<SingersEntity> update(long id){
        List<SingersEntity> list=get();
        if (iDaoSinger.exist(id)){
            SingersEntity singers=new SingersEntity();
            iDaoSinger.update(singers);
        } else {
            throw new IllegalArgumentException("С таким " + id + " исполнителя не найдено");
        }
     return list;
    }

    public boolean delete(long id){
        List<SingersEntity> list=get();
        if (iDaoSinger.exist(id)){
            iDaoSinger.delete(id);
        }else {
            throw new IllegalArgumentException("С таким " + id + " исполнителя не найдено");
        }
        return iDaoSinger.delete(id);
    }

    public boolean exist(long id){
        List<SingersEntity> listSingers=iDaoSinger.getAllSinger();
        for(SingersEntity element:listSingers) {
            if(id == element.getId()) {
                return  true;
            }
        }
        return false;
    }
    public boolean validate(String SingerName) {
        List<SingersEntity> listSingers = iDaoSinger.getAllSinger();
        for(SingersEntity item: listSingers){
            if ( listSingers.isEmpty() || item.getNameArtist()==null){
                throw new IllegalArgumentException(" В коллекции нет ни одного артиста");
            }
            if(listSingers.size()>256){
                throw  new IllegalArgumentException("Имя артиста не может быть болше чем 256 символоы");
            }
        }

        return true;
    }
    }

