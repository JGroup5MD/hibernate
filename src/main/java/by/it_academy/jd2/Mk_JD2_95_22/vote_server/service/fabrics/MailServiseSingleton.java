package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.fabrics;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.MailSendingServise;

import java.util.Properties;

public class MailServiseSingleton {
    private static Properties properties;
    private volatile static MailSendingServise instance;

    private MailServiseSingleton() {}

    public static void setProperties(Properties properties) {
        synchronized (MailServiseSingleton.class){
            if(instance != null){
                throw new IllegalStateException("Нельзя изменять насторойки отправки email при подключении");
            }
            MailServiseSingleton.properties = properties;
        }
    }


    public static MailSendingServise getInstance() {
        if(instance == null){
            synchronized (MailServiseSingleton.class){
                if(instance == null){
                    instance = new MailSendingServise();
                }
            }
        }
        return instance;
    }
}
