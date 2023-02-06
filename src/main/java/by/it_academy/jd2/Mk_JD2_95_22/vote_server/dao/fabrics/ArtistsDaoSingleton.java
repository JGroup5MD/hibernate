package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.fabrics;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.SingerDAO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IDaoSinger;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.fabrics.VoteServiceSingleton;

public class ArtistsDaoSingleton {
    private volatile static SingerDAO instance;

    private ArtistsDaoSingleton() {
    }

    public static IDaoSinger getInstance() {
        if (instance == null) {
            synchronized (VoteServiceSingleton.class) {
                if (instance == null) {
                    instance = new SingerDAO();
                }
            }
        }
        return instance;
    }
}
