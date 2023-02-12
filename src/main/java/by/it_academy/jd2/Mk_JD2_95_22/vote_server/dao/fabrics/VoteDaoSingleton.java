package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.fabrics;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.models.VoteDAO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IVoteDAO;

public class VoteDaoSingleton {
    private volatile static IVoteDAO instance;

    private VoteDaoSingleton() {
    }

    public static IVoteDAO getInstance() {
        if(instance == null){
            synchronized (VoteDaoSingleton.class){
                if(instance == null){
                    instance = new VoteDAO(ManagerEntitySingleton.getInstance());
                }
            }
        }
        return instance;
    }
}
