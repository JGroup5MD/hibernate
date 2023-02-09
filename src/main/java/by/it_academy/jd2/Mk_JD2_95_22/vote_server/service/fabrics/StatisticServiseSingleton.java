package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.fabrics;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.StatisticServise;

public class StatisticServiseSingleton {
    private volatile static StatisticServise instance;

    private StatisticServiseSingleton() {
    }

    public static StatisticServise getInstance() {
        if(instance == null){
            synchronized (StatisticServiseSingleton.class){
                if(instance == null){
                    instance = new StatisticServise(SingerServiceSingleton.getInstance(),
                                                    JenresServiceSingleton.getInstance(),
                                                     VoteServiceSingleton.getInstance());
                }
            }
        }
        return instance;
    }
}
