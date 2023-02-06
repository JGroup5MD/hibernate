package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.fabrics;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.JenreDAO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IJenreDAO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.fabrics.VoteServiceSingleton;

public class GenresDaoSingleton {
    private volatile static JenreDAO instance;

    private GenresDaoSingleton() {
    }

    public static IJenreDAO getInstance() {
        if (instance == null) {
            synchronized (VoteServiceSingleton.class) {
                if (instance == null) {
                    instance = new JenreDAO();
                }
            }
        }
        return instance;
    }
}
