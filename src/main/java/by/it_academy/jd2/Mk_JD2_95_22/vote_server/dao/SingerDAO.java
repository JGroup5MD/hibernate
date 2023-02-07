package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IManagerConnection;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Singers;

import java.util.ArrayList;
import java.util.List;

public class SingerDAO  {
    private  final IManagerConnection mc;
    public SingerDAO(ManagerConnection mc) {
        this.mc = mc;
    }

    public List<Singers> getAllSinger() {
        List<Singers> list=new ArrayList<>();
        try{
        mc.EntityManager().getTransaction().begin();
        List <Singers> singers=mc.EntityManager().createQuery("SELECT id, name FROM app.Singer ORDER BY id;").getResultList();
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
        List<Singers> list=new ArrayList<>();
        try{
            mc.EntityManager().getTransaction().begin();
            Singers singers=mc.EntityManager().find(Singers.class, id);
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
        mc.EntityManager().persist(new Singers(newSinger));
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
            Singers findSinger = mc.EntityManager().find(Singers.class, id);
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

    public void update(Singers singers){
        try{
        mc.EntityManager().getTransaction().begin();
        Singers singersUpdate=mc.EntityManager().find(Singers.class,singers.getId());
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
        Singers singers=mc.EntityManager().find(Singers.class, id);
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

