package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.fabrics;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.GenresDao;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IGenresDao;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.fabrics.VoteServiceSingleton;

public class GenresDaoSingleton {
    private volatile static GenresDao instance;

    private GenresDaoSingleton() {
    }

    public static IGenresDao getInstance() {
        if (instance == null) {
            synchronized (VoteServiceSingleton.class) {
                if (instance == null) {
                    instance = new GenresDao();
                }
            }
        }
        return instance;
    }
}
