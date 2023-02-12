package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.fabrics;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.models.SingerDAO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.ISingerDAO;

public class SingerDaoSingleton {
    private volatile static ISingerDAO instance;

    private SingerDaoSingleton() {
    }

    public static ISingerDAO getInstance() {
        if (instance == null) {
            synchronized (SingerDaoSingleton.class) {
                if (instance == null) {
                    instance = new SingerDAO(ManagerEntitySingleton.getInstance());
                }
            }
        }
        return instance;
    }
}
