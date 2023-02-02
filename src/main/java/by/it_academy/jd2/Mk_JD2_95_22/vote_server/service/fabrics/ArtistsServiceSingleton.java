package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.fabrics;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.fabrics.ArtistsDaoSingleton;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.ArtistsService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IArtistsService;

public class ArtistsServiceSingleton {
    private volatile static ArtistsService instance;

    private ArtistsServiceSingleton() {
    }

    public static IArtistsService getInstance() {
        if(instance == null){
            synchronized (VoteServiceSingleton.class){
                if(instance == null){
                    instance = new ArtistsService(ArtistsDaoSingleton.getInstance());
                }
            }
        }
        return instance;
    }
}
