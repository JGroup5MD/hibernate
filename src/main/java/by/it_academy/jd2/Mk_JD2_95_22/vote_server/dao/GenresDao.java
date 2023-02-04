package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IGenresDao;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.entity.Genres;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class GenresDao implements IGenresDao {
    EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("tutorial");
    private List<Genres> genres = new ArrayList<>();

    public List<Genres> getGenres() {
        return genres;
    }

    @Override
    public List<Genres> get() {

        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        genres = entityManager.createQuery("FROM Genres").getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return genres;
    }

    @Override
    public synchronized boolean add(String newGenres) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(new Genres(newGenres));

        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    @Override
    public synchronized boolean delete(long id) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Genres reference = entityManager.find(Genres.class, id);
        entityManager.remove(reference);

        entityManager.getTransaction().commit();
        entityManager.close();
        return false;
    }

    @Override
    public boolean exist(long id) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Genres> genresList = get();
        for (Genres genres : genresList) {
            if(id == genres.getId()){
                return true;
            }
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return false;
    }
}
