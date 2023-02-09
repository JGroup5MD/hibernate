package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.fabrics;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.JenreDAO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IJenreDAO;

public class JenresDaoSingleton {
    private volatile static IJenreDAO instance;

    private JenresDaoSingleton(){}

    public static IJenreDAO getInstance() {
        if(instance == null){
            synchronized (JenresDaoSingleton.class){
                if(instance == null){
                    instance = new JenreDAO(ManagerEntitySingleton.getInstance());
                }
            }
        }
        return instance;
    }
}
