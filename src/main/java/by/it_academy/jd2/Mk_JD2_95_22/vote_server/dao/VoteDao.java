package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IVoteDao;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.entity.Vote;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VoteDao implements IVoteDao {
    EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("tutorial");

    private List<Vote> voteList = new ArrayList<>();

    public List<Vote> getVoteList() {
        return voteList;
    }

    @Override
    public List<Vote> get() {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        voteList = entityManager.createQuery("FROM Vote").getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return voteList;
    }


    @Override
    public boolean save(Vote newVote) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(new Vote(newVote.getArtist(), newVote.getGenre_1(), newVote.getGenre_2(), newVote.getGenre_3(),
                newVote.getGenre_4(), newVote.getGenre_5(), newVote.getAbout(), newVote.getEmail(), newVote.getDt_create()));

        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

}
