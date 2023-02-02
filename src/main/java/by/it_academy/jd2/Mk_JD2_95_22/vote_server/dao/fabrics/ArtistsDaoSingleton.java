package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.fabrics;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.ArtistsDao;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IArtistsDao;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.fabrics.VoteServiceSingleton;

public class ArtistsDaoSingleton {
    private volatile static ArtistsDao instance;

    private ArtistsDaoSingleton() {
    }

    public static IArtistsDao getInstance() {
        if (instance == null) {
            synchronized (VoteServiceSingleton.class) {
                if (instance == null) {
                    instance = new ArtistsDao();
                }
            }
        }
        return instance;
    }
}
