package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.fabrics;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.fabrics.MailDaoSingleton;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IMailServise;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.implementation.MailServise;

public class MailSingleton {
    private volatile static IMailServise instance;
    private MailSingleton() {
    }
    public static IMailServise getInstance() {
        if(instance == null){
            synchronized (JenresServiceSingleton.class){
                if(instance == null){
                    instance = new MailServise(SingerServiceSingleton.getInstance(),
                                               JenresServiceSingleton.getInstance(),
                                               MailDaoSingleton.getInstance());
                }
            }
        }
        return instance;
    }
}
