package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.models;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IManagerConnection;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.ISingerDAO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.SingersEntity;


import java.util.ArrayList;
import java.util.List;

public class SingerDAO  implements ISingerDAO {
    private  final IManagerConnection mc;
    public SingerDAO(IManagerConnection manager) {
        this.mc = manager;
    }

    public List<SingersEntity> getAllSinger() {
        List<SingersEntity> list=new ArrayList<>();
        try{
        mc.EntityManager().getTransaction().begin();
        List <SingersEntity> singers=mc.EntityManager().createQuery("SELECT id, name FROM Singer;", SingersEntity.class).getResultList();
        mc.EntityManager().getTransaction().commit();
        list.addAll(singers);
        return list;
        }catch (Exception e){
            if(mc.EntityManager()!=null){
               mc.EntityManager().getTransaction().rollback();
            }
            throw new RuntimeException("Erorr DataBase", e);
            }finally {
            if (mc.EntityManager()!=null){
                mc.EntityManager().close();
            }
        }
    }


    public String getOneSinger(long id) {
        List<SingersEntity> list=new ArrayList<>();
        try{
            mc.EntityManager().getTransaction().begin();
            SingersEntity singers=mc.EntityManager().find(SingersEntity.class, id);
            mc.EntityManager().getTransaction().commit();
            if(singers==null){
                throw new IllegalArgumentException("Not singer this is id " + id);
            }
            return singers.getNameArtist();
        }catch (Exception e){
            if(mc.EntityManager()!=null){
                mc.EntityManager().getTransaction().rollback();
            }
            throw new RuntimeException("Erorr DataBase", e);
        }finally {
            if (mc.EntityManager()!=null){
                mc.EntityManager().close();
            }
        }
    }


    public  boolean created(String newSinger) {
        try{
        mc.EntityManager().getTransaction().begin();
        mc.EntityManager().persist(new SingersEntity(newSinger));
        mc.EntityManager().getTransaction().commit();
        return true;
        }catch (Exception e){
            if(mc.EntityManager()!=null){
                mc.EntityManager().getTransaction().rollback();
            }
            throw new RuntimeException("Erorr DataBase", e);
        }finally {
            if (mc.EntityManager()!=null){
                mc.EntityManager().close();
            }
        }
    }

    public boolean delete(long id) {
        try {
            mc.EntityManager().getTransaction().begin();
            SingersEntity findSinger = mc.EntityManager().find(SingersEntity.class, id);
            if (findSinger != null) {
                mc.EntityManager().remove(findSinger);
            }
            mc.EntityManager().getTransaction().commit();
            return findSinger != null;
        }catch (Exception e){
            if(mc.EntityManager()!=null){
                mc.EntityManager().getTransaction().rollback();
            }
            throw new RuntimeException("Erorr DataBase", e);
        }finally {
            if (mc.EntityManager() != null) {
                mc.EntityManager().close();
            }
        }
    }

    public void update(SingersEntity singers){
        try{
        mc.EntityManager().getTransaction().begin();
        SingersEntity singersUpdate=mc.EntityManager().find(SingersEntity.class,singers.getId());
        if(singersUpdate!=null){
            mc.EntityManager().merge(singers);
        }
        mc.EntityManager().getTransaction().commit();
    }   catch (Exception e){
            if(mc.EntityManager()!=null){
                mc.EntityManager().getTransaction().rollback();
            }
        throw new RuntimeException("Erorr DataBase", e);
        }finally {
            if (mc.EntityManager() != null) {
                mc.EntityManager().close();
            }
        }
    }

    public boolean exist(long id) {
        try{
        mc.EntityManager().getTransaction().begin();
        SingersEntity singers=mc.EntityManager().find(SingersEntity.class, id);
        mc.EntityManager().getTransaction().commit();
        return singers!=null;
        }   catch (Exception e){
            if(mc.EntityManager()!=null){
                mc.EntityManager().getTransaction().rollback();
            }
            throw new RuntimeException("Erorr DataBase", e);
        }finally {
            if (mc.EntityManager() != null) {
                mc.EntityManager().close();
            }
        }
    }
    }

