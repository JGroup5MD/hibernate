package by.it_academy.jd2.Mk_JD2_95_22.vote_server.web.listener;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.fabrics.MailSendingServiseSingleton;

import javax.servlet.ServletContextEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyLisner {
    public void contextInitialized(ServletContextEvent sce) {
        File confDir = new File(System.getenv("catalina_base") + "/conf");
        File prop = new File(confDir + "/application.properties");
        try{
            Properties properties = new Properties();
            properties.load(new FileReader(prop));


            MailSendingServiseSingleton.setProperties(properties);
        } catch (FileNotFoundException e) {
            throw new IllegalStateException("Файл с настройками не найден!", e);
        } catch (IOException e) {
            throw new RuntimeException("Ощибка чтения файла настроек прилажения application.properties", e);
        }
    }


    public void contextDestroyed(ServletContextEvent sce) {       
    }
}
