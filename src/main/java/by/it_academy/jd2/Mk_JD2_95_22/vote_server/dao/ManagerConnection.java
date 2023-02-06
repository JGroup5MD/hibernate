package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IManagerConnection;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.fabrics.SingerServiceSingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManagerConnection implements IManagerConnection {
    private volatile static EntityManagerFactory instance;
    public EntityManager EntityManager(){
        EntityManagerFactory factory= Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager=factory.createEntityManager();
        return entityManager;
    }


public  EntityManagerFactory getInstance(){
    if(instance==null){
        synchronized (SingerServiceSingleton.class){
            if(instance==null){
                instance=Persistence.createEntityManagerFactory("tutorial");
            }
        }
    }
    return instance;
}
}
