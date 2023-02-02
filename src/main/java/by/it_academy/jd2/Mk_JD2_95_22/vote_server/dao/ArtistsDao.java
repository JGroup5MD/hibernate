package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IArtistsDao;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.entity.Artists;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class ArtistsDao implements IArtistsDao {
    EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("tutorial");
    private List<Artists> artists = new ArrayList<>();

    public List<Artists> getArtists() {
        return artists;
    }

    @Override
    public List<Artists> get() {

        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        artists = entityManager.createQuery("FROM Artists").getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return artists;
    }

    @Override
    public synchronized boolean add(String newArtist) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(new Artists(newArtist));

        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    @Override
    public synchronized boolean delete(long id) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Artists reference = entityManager.find(Artists.class, id);
        entityManager.remove(reference);

        entityManager.getTransaction().commit();
        entityManager.close();
        return false;
    }

    @Override
    public boolean exist(long id) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Artists> artistsList = get();
        for (Artists artists : artistsList) {
            if(id == artists.getId()){
                return true;
            }
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return false;
    }



}
