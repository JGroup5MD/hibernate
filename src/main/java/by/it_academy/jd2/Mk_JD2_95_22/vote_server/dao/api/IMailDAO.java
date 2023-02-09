package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Mail;

import java.util.List;

public interface IMailDAO {
    public List<Mail> getAllMails();
    public List<Mail> mailSender();
    public Mail getSpecialMail(long id);
    public boolean addMail(Mail email);
    public boolean updateEmail(Long id,String message, boolean validateEmail,
                              boolean sendMessage, long lastSendTime, String email);
    public boolean deleteEmail(long id);
}
