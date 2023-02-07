package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IManagerConnection;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IVoteDAO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Jenres;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Singers;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Vote;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.JenreDTO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.VoteDTO;

import java.util.ArrayList;
import java.util.List;

public class VoteDAO implements IVoteDAO {
    private  final IManagerConnection mc;

    public VoteDAO(IManagerConnection mc) {
        this.mc = mc;
    }
    public List<Vote>  getVote(){
        List<Vote> list=new ArrayList<>();
        try{
            mc.EntityManager().getTransaction().begin();
            List <Vote> votes=mc.EntityManager().createQuery("SELECT id,  FROM app.Singer-Vote ORDER BY id", Vote.class).getResultList();
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
        List<Jenres> jenres=Vote_Janre(votes);
        Singers singers=Vote_Singer(votes);
        Vote vote_entity=new Vote();
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

    public Singers Vote_Singer(VoteDTO votes){
        try{
            mc.EntityManager().getTransaction().begin();
           return mc.EntityManager().find(Singers.class,votes.getIdSinger());
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

    public List<Jenres> Vote_Janre(VoteDTO votes){
        List <Jenres> list=new ArrayList<>();
        try{
            mc.EntityManager().getTransaction().begin();
            for(JenreDTO jenre:votes.getIdJenres()){
                list.add(mc.EntityManager().find(Jenres.class,jenre));
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

