package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.fabrics;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.VoteDAO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.fabrics.MailDaoSingleton;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.fabrics.ManagerEntitySingleton;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.fabrics.VoteDaoSingleton;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.VoteService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IVoteService;

public class VoteServiceSingleton {
    private volatile static VoteService instance;

    private VoteServiceSingleton() {
    }

    public static VoteService getInstance() {
        if(instance == null){
            synchronized (VoteServiceSingleton.class){
                if(instance == null){
                    instance = new VoteService(
                            new VoteDAO(ManagerEntitySingleton.getInstance()),
                            SingerServiceSingleton.getInstance(),
                            JenresServiceSingleton.getInstance(),
                            MailSingleton.getInstance() );
                }
            }
        }
        return instance;
    }
}
