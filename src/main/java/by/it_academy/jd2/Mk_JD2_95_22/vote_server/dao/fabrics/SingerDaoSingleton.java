package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.fabrics;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.JenreDAO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.ManagerConnection;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.SingerDAO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IJenreDAO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IManagerConnection;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.ISingerDAO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.fabrics.VoteServiceSingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SingerDaoSingleton {
    private volatile static SingerDAO instance;

    private SingerDaoSingleton() {
    }

    public static ISingerDAO getInstance() {
        if (instance == null) {
            synchronized (VoteDaoSingleton.class) {
                if (instance == null) {
                    instance = new SingerDAO(ManagerEntitySingleton.getInstance());
                }
            }
        }
        return instance;
    }
}
