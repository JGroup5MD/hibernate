package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.fabrics;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.implementation.MailSendingServise;
import java.util.Properties;

public class MailSendingServiseSingleton {
    private static Properties properties;
    private volatile static MailSendingServise instance;

    private MailSendingServiseSingleton() {}

    public static void setProperties(Properties properties) {
        synchronized (MailSendingServiseSingleton.class){
            if(instance != null){
                throw new IllegalStateException("Нельзя изменять насторойки отправки email при подключении");
            }
            MailSendingServiseSingleton.properties = properties;
        }
    }


    public static MailSendingServise getInstance() {
        if(instance == null){
            synchronized (MailSendingServiseSingleton.class){
                if(instance == null){
                    instance = new MailSendingServise(new Properties(),MailSingleton.getInstance());
                }
            }
        }
        return instance;
    }
}
