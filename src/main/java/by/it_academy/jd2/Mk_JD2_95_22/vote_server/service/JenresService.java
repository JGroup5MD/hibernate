package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IJenreDAO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Jenres;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IJenresService;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class JenresService implements IJenresService {
    private final IJenreDAO iJenreDAO;

    public JenresService(IJenreDAO iJenreDAO) {
        this.iJenreDAO = iJenreDAO;
    }
    public List<Jenres> getAllJenres(){

        return iJenreDAO.getAllJenres();
    }


    public String getOneJenre(long id) {
        List<Jenres> list = getAllJenres();
        for (Jenres element : list) {
            if (Objects.equals(element.getId(), id)) {

            }else {
                throw new IllegalArgumentException("С таким " + id + " исполнителя не найдено");
            }
        }
        return getOneJenre(id);
    }

    public boolean created(String newNameJenre){
        Jenres jenres=new Jenres();
        List<Jenres> list=getAllJenres();
        Iterator<Jenres> iterator=list.iterator();
        if(!iterator.hasNext()){
            iterator.next().setNameGenre(newNameJenre);
            for(Jenres item: list){
                if(!newNameJenre.equals(jenres.getNameGenre())){
                    list.add(jenres);
                }
            }
        }
        return  iJenreDAO.created(newNameJenre);
    }


    public List<Jenres> update(long id){
        List<Jenres> list=getAllJenres();
        if (iJenreDAO.exist(id)){
            Jenres Jenres=new Jenres();
            iJenreDAO.update(Jenres);
        } else {
            throw new IllegalArgumentException("С таким " + id + " исполнителя не найдено");
        }
        return list;
    }

    public boolean delete(long id){
        List<Jenres> list=getAllJenres();
        if (iJenreDAO.exist(id)){
            iJenreDAO.delete(id);
        }else {
            throw new IllegalArgumentException("С таким " + id + " исполнителя не найдено");
        }
        return iJenreDAO.delete(id);
    }

    public boolean exist(long id){
        List<Jenres> listJenres=iJenreDAO.getAllJenres();
        for(Jenres element:listJenres) {
            if(id == element.getId()) {
                return  true;
            }
        }
        return false;
    }
    public boolean validate(String jenreName) {
        List<Jenres> listJenres = iJenreDAO.getAllJenres();
        for(Jenres item: listJenres){
            if ( listJenres.isEmpty() || item.getNameGenre()==null){
                throw new IllegalArgumentException(" В коллекции нет ни одного артиста");
            }
            if(listJenres.size()>256){
                throw  new IllegalArgumentException("Имя артиста не может быть болше чем 256 символоы");
            }
        }

        return true;
    }
}
