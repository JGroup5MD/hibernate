package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.implementation;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.MailEntity;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IMailSendingServise;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IMailServise;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

public class MailSendingServise  implements IMailSendingServise {


    private static final String PROTOCOL = "mail.transport.protocol";
    private static final String AUTH = "mail.smtps.auth";
    private static final String HOST = "mail.smtps.host";
    private static final String EMAIL_SENDER = "mail.smtps.user";
    private static final String USER_PASSWORD = "user.password";
    private final Properties properties = new Properties();

    private final IMailServise mailService;
    private boolean isSendingEmails = true;

    public MailSendingServise(Properties prop, IMailServise mailService) {
        this.properties.setProperty(PROTOCOL, prop.getProperty(PROTOCOL));
        this.properties.setProperty(AUTH, prop.getProperty(AUTH));
        this.properties.setProperty(HOST, prop.getProperty(HOST));
        this.properties.setProperty(EMAIL_SENDER, prop.getProperty(EMAIL_SENDER));
        this.properties.setProperty(USER_PASSWORD, prop.getProperty(USER_PASSWORD));
        this.mailService = mailService;
    }


        public void startEmailSender(long timeSendSec){
            while (isSendingEmails){
                sendEmail();
                try {
                    Thread.sleep(timeSendSec*10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public void stopEmailSender(){
            this.isSendingEmails = false;
        }

        public void sendEmail() {
            List<MailEntity> emails = mailService.getEmailForSend();
            if(emails==null){
                return;
            }
            if(emails.size()==0){
                return;
            }
            for(MailEntity email : emails) {

                Session session = Session.getDefaultInstance(properties);

                try {
                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(properties.getProperty(EMAIL_SENDER)));
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getAdressMail()));
                    message.setSubject("Ваш голос учтен. Спасибо за ваш голос!");
                    message.setText(email.getAdressMail());

                    Transport tr = session.getTransport();
                    tr.connect(null, properties.getProperty(USER_PASSWORD));
                    tr.sendMessage(message, message.getAllRecipients());
                    tr.close();

                    System.out.println("Сообщение успешно отправлено!");
                    mailService.update(email.getId(), email.getMessageText(),email.isValidateEmail(),false,
                            System.currentTimeMillis(), email.getAdressMail());
                } catch (MessagingException mex) {
                    mex.printStackTrace();
                }
            }
        }
    }


