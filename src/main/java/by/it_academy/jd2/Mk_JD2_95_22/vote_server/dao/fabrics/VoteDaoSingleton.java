package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.fabrics;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.VoteDao;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IVoteDao;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.fabrics.VoteServiceSingleton;

public class VoteDaoSingleton {
    private volatile static VoteDao instance;

    private VoteDaoSingleton() {
    }

    public static IVoteDao getInstance() {
        if(instance == null){
            synchronized (VoteServiceSingleton.class){
                if(instance == null){
                    instance = new VoteDao();
                }
            }
        }
        return instance;
    }
}
