package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.fabrics;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.fabrics.MailDaoSingleton;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.MailServise;


public class MailSingleton {
    private volatile static MailServise instance;

    private MailSingleton() {
    }

    public static MailServise getInstance() {
        if(instance == null){
            synchronized (MailSingleton.class){
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
