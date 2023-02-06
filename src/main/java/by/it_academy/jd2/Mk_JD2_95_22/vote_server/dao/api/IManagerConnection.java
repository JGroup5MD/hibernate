package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public interface IManagerConnection {
    public EntityManager EntityManager();
    public  EntityManagerFactory getInstance();
}
