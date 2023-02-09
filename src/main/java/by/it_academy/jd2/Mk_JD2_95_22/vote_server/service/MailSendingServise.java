package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Mail;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IMailServise;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

public class MailSendingServise {
    public class SendingEmailServiceNew{

        private final Properties properties = new Properties();

        private final IMailServise mailService;



        private boolean isSendingEmails = true;

        public SendingEmailServiceNew(Properties prop, IMailServise mailService) {
            this.properties.setProperty("mail.transport.protocol", prop.getProperty("mail.transport.protocol"));
            this.properties.setProperty("mail.smtps.auth", prop.getProperty("mail.smtps.auth"));
            this.properties.setProperty("mail.smtps.host", prop.getProperty("mail.smtps.host"));
            this.properties.setProperty("mail.smtps.user", prop.getProperty("mail.smtps.user"));
            this.properties.setProperty("user.password", prop.getProperty("user.password"));
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
            List<Mail> emails = mailService.getEmailForSend();
            if(emails==null){
                return;
            }
            if(emails.size()==0){
                return;
            }
            for(Mail email : emails) {

                Session session = Session.getDefaultInstance(properties);

                try {
                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(properties.getProperty("mail.smtps.user")));
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getAdressMail()));
                    message.setSubject("Ваш голос учтен. Спасибо за ваш голос!");
                    message.setText(email.getAdressMail());

                    Transport tr = session.getTransport();
                    tr.connect(null, properties.getProperty("user.password"));
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
}

