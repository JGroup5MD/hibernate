package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.fabrics;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.ManagerConnection;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IManagerConnection;



public class ManagerEntitySingleton {
    private volatile static ManagerConnection instance;
    public static IManagerConnection getInstance(){
        if(instance==null){
            synchronized (ManagerEntitySingleton.class){
                if(instance==null){
                    instance= new ManagerConnection();
                }
            }
        }
        return instance;
    }
}
