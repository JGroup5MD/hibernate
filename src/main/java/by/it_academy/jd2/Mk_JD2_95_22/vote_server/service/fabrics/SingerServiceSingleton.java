package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.fabrics;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.SingerDAO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IDaoSinger;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.fabrics.ArtistsDaoSingleton;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.ArtistsService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.SingerServise;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.ISingerService;

public class SingerServiceSingleton {
    private volatile static SingerServise instance;

    private SingerServiceSingleton() {
    }

    public static ISingerService getInstance() {
        if(instance == null){
            synchronized (SingerServiceSingleton.class){
                if(instance == null){
                    instance = new SingerServise();
                }
            }
        }
        return instance;
    }
}
