package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.fabrics;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.fabrics.JenresDaoSingleton;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.implementation.JenresService;


public class JenresServiceSingleton {
    private volatile static JenresService instance;

    private JenresServiceSingleton() {
    }

    public static JenresService getInstance() {
        if(instance == null){
            synchronized (JenresServiceSingleton.class){
                if(instance == null){
                    instance = new JenresService(JenresDaoSingleton.getInstance());
                }
            }
        }
        return instance;
    }
}
