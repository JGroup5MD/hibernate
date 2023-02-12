package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.implementation;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IMailDAO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.MailEntity;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.main_entity.VoteDTO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IJenresService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IMailServise;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.ISingerService;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailServise implements IMailServise {
    private static final String EMAIL_REGEX =  "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]" +
                                               "+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)" +
                                               "+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private final ISingerService singerService;
    private final IJenresService genreService;
    private final IMailDAO mailDao;

    public MailServise(ISingerService singerService, IJenresService genreService, IMailDAO mailDao) {
        this.singerService = singerService;
        this.genreService = genreService;
        this.mailDao = mailDao;
    }


    @Override
    public void save(VoteDTO voteDTO) {
        MailEntity mail = new MailEntity();
        mail.setMessageText(messageText(voteDTO));
        mail.setValidateEmail(validateEmail(voteDTO.getMailAdress()));
        mail.setSendMassage(true);
        mail.setLastSendTime(System.currentTimeMillis());
        mail.setAdressMail(voteDTO.getMailAdress());
        mailDao.addMail(mail);
    }

    @Override
    public boolean update(long id, String message, boolean validateEmail,
                          boolean sendMessage, long lastSendTime, String mail) {
        boolean isUpdate;
        isUpdate = mailDao.updateEmail(id, message,validateEmail(mail),sendMessage,
                System.currentTimeMillis(),mail);
        return isUpdate;
    }

    @Override
    public List<MailEntity> getEmailForSend() {
        List<MailEntity> mails = mailDao.mailSender();
        return mails;
    }
    @Override
    public boolean validateEmail(String mail) {
        Matcher matcher = EMAIL_PATTERN.matcher(mail);
        return matcher.matches();
    }
    @Override
    public String messageText(VoteDTO voteDTO){
        StringBuilder message = new StringBuilder();
        message.append("Голос за артиста:\n        " + singerService.get() +".\n");
        message.append("Голос за жанры:\n");
        for(long id : voteDTO.getIdJenres()){
            message.append("        " + genreService.getOneJenre(id) + ".\n");
        }
        message.append("Ваше сообщение о себе:\n        " + voteDTO.getAboutInfaormation() + ".\n");
        message.append("Вы указали mail:\n        " + voteDTO.getMailAdress()+ ".\n");
        message.append("Голос оставлен:\n        " + voteDTO.getTimeCreated() + ".\n");
        return message.toString();
    }
}
