package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.fabrics;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.MailDAO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.ManagerConnection;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IMailDAO;

public class MailDaoSingleton {
    public static volatile IMailDAO instance;

    private MailDaoSingleton(){}

    public static IMailDAO getInstance(){
        if(instance==null){
            synchronized (MailDaoSingleton.class){
                if(instance==null){
                    instance = new MailDAO(new ManagerConnection());
                }
            }
        }
        return instance;
    }
}
