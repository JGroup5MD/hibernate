package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.models;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IManagerConnection;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IVoteDAO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.JenresEntity;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.SingersEntity;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.VoteEntity;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.main_entity.VoteDTO;

import java.util.ArrayList;
import java.util.List;

public class VoteDAO implements IVoteDAO {
    private  final IManagerConnection mc;

    public VoteDAO(IManagerConnection manager) {
        this.mc = manager;
    }
    public List<VoteEntity>  getVote(){
        List<VoteEntity> list=new ArrayList<>();
        try{
            mc.EntityManager().getTransaction().begin();
            List <VoteEntity> votes=mc.EntityManager().createQuery("SELECT id  FROM app.Singer_Vote ORDER BY id",  VoteEntity.class).getResultList();
            mc.EntityManager().getTransaction().commit();
            list.addAll(votes);
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

    public void save(VoteDTO votes){
        List<JenresEntity> jenres=Vote_Janre(votes);
        SingersEntity singers=Vote_Singer(votes);
        VoteEntity vote_entity=new VoteEntity();
        try{
            mc.EntityManager().getTransaction().begin();
            mc.EntityManager().persist(vote_entity);
            mc.EntityManager().getTransaction().commit();
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

    public SingersEntity Vote_Singer(VoteDTO votes){
        try{
            mc.EntityManager().getTransaction().begin();
           return mc.EntityManager().find(SingersEntity.class,votes.getIdSinger());
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

    public List<JenresEntity> Vote_Janre(VoteDTO votes){
        List <JenresEntity> list=new ArrayList<>();
        try{
            mc.EntityManager().getTransaction().begin();
            for(long jenre:votes.getIdJenres()){
                list.add(mc.EntityManager().find(JenresEntity.class,jenre));
            }
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

    }

