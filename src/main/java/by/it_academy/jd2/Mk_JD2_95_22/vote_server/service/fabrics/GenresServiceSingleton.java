package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.fabrics;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.fabrics.GenresDaoSingleton;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.GenresService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IGenresService;

public class GenresServiceSingleton {
    private volatile static GenresService instance;

    private GenresServiceSingleton() {
    }

    public static IGenresService getInstance() {
        if(instance == null){
            synchronized (VoteServiceSingleton.class){
                if(instance == null){
                    instance = new GenresService(GenresDaoSingleton.getInstance());
                }
            }
        }
        return instance;
    }
}
