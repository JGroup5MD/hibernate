package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.models;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IJenreDAO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IManagerConnection;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.JenresEntity;

import java.util.ArrayList;
import java.util.List;

public class JenreDAO implements IJenreDAO {

 private  final IManagerConnection mc;

    public JenreDAO(IManagerConnection manager) {
        this.mc = manager;
    }



    public List<JenresEntity> getAllJenres() {
        List<JenresEntity> list=new ArrayList<>();
        try{
            mc.EntityManager().getTransaction().begin();
            List <JenresEntity> jenres=mc.EntityManager().createQuery("SELECT id, name FROM app.Jenre ORDER BY id;", JenresEntity.class).getResultList();
            mc.EntityManager().getTransaction().commit();
            list.addAll(jenres);
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

    public String getOneJenre(long id) {
        List<JenresEntity> list=new ArrayList<>();
        try{
            mc.EntityManager().getTransaction().begin();
            JenresEntity jenres=mc.EntityManager().find(JenresEntity.class, id);
            mc.EntityManager().getTransaction().commit();
            if(jenres==null){
                throw new IllegalArgumentException("Not singer this is id " + id);
            }
            return jenres.getNameGenre();
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

    public  boolean created(String newJenre) {
        try{
            mc.EntityManager().getTransaction().begin();
            mc.EntityManager().persist(new JenresEntity(newJenre));
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
            JenresEntity findJenre = mc.EntityManager().find(JenresEntity.class, id);
            if (findJenre  != null) {
                mc.EntityManager().remove(findJenre );
            }
            mc.EntityManager().getTransaction().commit();
            return findJenre != null;
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

    public void update(JenresEntity jenres){
        try{
            mc.EntityManager().getTransaction().begin();
            JenresEntity singersUpdate=mc.EntityManager().find(JenresEntity.class,jenres.getId());
            if(singersUpdate!=null){
                mc.EntityManager().merge(jenres);
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
            JenresEntity jenres=mc.EntityManager().find(JenresEntity.class, id);
            mc.EntityManager().getTransaction().commit();
            return jenres!=null;
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
