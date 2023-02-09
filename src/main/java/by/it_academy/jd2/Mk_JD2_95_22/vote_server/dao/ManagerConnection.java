package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IManagerConnection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManagerConnection implements IManagerConnection {
    private EntityManagerFactory factory;

    public ManagerConnection() {
        this.factory = Persistence.createEntityManagerFactory("tutorial");
    }

    public EntityManager EntityManager(){
        return this.factory.createEntityManager();
    }

}
