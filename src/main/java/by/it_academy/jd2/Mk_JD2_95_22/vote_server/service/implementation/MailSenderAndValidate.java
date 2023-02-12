package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.implementation;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.main_entity.JenreDTO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.main_entity.SingerDTO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.main_entity.VoteDTO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IJenresService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IMailSenderAndVAlidate;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.ISingerService;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailSenderAndValidate implements IMailSenderAndVAlidate {
    private static final String PROTOCOL = "mail.transport.protocol";
    private static final String AUTH = "mail.smtps.auth";
    private static final String HOST = "mail.smtps.host";
    private static final String EMAIL_SENDER = "mail.smtps.user";
    private static final String EMAIL_USER_PASSWORD = "user.password";
    private static final String EMAIL_REGEX =  "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private Properties properties = new Properties();

    final private  IJenresService genreService;
    final private ISingerService singerService;

    public MailSenderAndValidate(IJenresService genreService, ISingerService singerService) {
        this.genreService = genreService;
        this.singerService = singerService;
    }

    public void SendingEmailService(Properties prop) {
        this.properties.setProperty(PROTOCOL, prop.getProperty(PROTOCOL));
        this.properties.setProperty(AUTH, prop.getProperty(AUTH));
        this.properties.setProperty(HOST, prop.getProperty(HOST));
        this.properties.setProperty(EMAIL_SENDER, prop.getProperty(EMAIL_SENDER));
        this.properties.setProperty(EMAIL_USER_PASSWORD, prop.getProperty(EMAIL_USER_PASSWORD));
    }

    @Override
    public void sendEmail(VoteDTO vdto) {
        if (validateEmail(vdto.getMailAdress())) {
            System.out.println("Адрес электронной почты: " + vdto.getMailAdress() + " указан корректно");
        } else {
            throw new IllegalArgumentException("Укажите корректный адрес электронной почты");
        }

        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);

            // from sender
            message.setFrom(new InternetAddress(properties.getProperty(EMAIL_SENDER)));

            // to distanation recipient
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(vdto.getMailAdress()));

            StringBuilder stringBuilder = new StringBuilder();
            // text message:
            message.setSubject("Ваш голос учтен. Спасибо за ваш голос!");
            //message.setContent("<h1>Это актуальное сообщение</h1>", "text/html");

            List<SingerDTO> singers = new ArrayList<>();
            for (SingerDTO sdto : singers) {
                if(sdto.getIdSinger() == vdto.getIdSinger()){
                    String nameSinger = sdto.getSingerName();
                    stringBuilder.append("Вы проголосовали за исполнителя: " + nameSinger + "\n");
                }
            }

            List<JenreDTO> genres = new ArrayList<>();
            for (JenreDTO gdto : genres) {
                for (long item : vdto.getIdJenres()) {
                    if(gdto.getIdJenre() == item){
                        String nameJenre = gdto.getJenreName();
                        stringBuilder.append("Вы проголосовали за жанр: " + nameJenre + "\n");
                    }
                }
            }

            stringBuilder.append("Вы оставили о себе следующее сообщение: " + vdto.getAboutInfaormation() + ".\n");
            message.setText(stringBuilder.toString());

            // Отправить сообщение
            Transport tr = session.getTransport();
            tr.connect(null, properties.getProperty(EMAIL_USER_PASSWORD) );
            tr.sendMessage(message, message.getAllRecipients());
            tr.close();

            System.out.println("Сообщение успешно отправлено!");

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    @Override
    public boolean validateEmail(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }
}
