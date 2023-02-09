package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IMailDAO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Mail;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.VoteDTO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.VotingWithTimeCreated;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IJenresService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IMailServise;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.ISingerService;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailServise implements IMailServise {
    private static final String EMAIL_REGEX =  "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
            "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private final ISingerService singerService;
    private final IJenresService genreService;
    private final IMailDAO mailDao;

    public MailServise(ISingerService singerService, IJenresService genreService, IMailDAO mailDao) {
        this.singerService = singerService;
        this.genreService = genreService;
        this.mailDao = mailDao;
    }


    public void save(VoteDTO voteDTO, VotingWithTimeCreated votingWithTimeCreated) {
        Mail mail = new Mail();
        mail.setMessageText(messageText(voteDTO,votingWithTimeCreated));
        mail.setValidateEmail(validateEmail(voteDTO.getMail()));
        mail.setSendMassage(true);
        mail.setLastSendTime(System.currentTimeMillis());
        mail.setAdressMail(voteDTO.getMail());
        mailDao.addMail(mail);
    }


    public boolean update(long id, String message, boolean validateEmail,
                          boolean sendMessage, long lastSendTime, String mail) {
        boolean isUpdate;
        isUpdate = mailDao.updateEmail(id, message,validateEmail(mail),sendMessage,
                System.currentTimeMillis(),mail);
        return isUpdate;
    }


    public List<Mail> getEmailForSend() {
        List<Mail> mails = mailDao.mailSender();
        return mails;
    }

    public boolean validateEmail(String mail) {
        Matcher matcher = EMAIL_PATTERN.matcher(mail);
        return matcher.matches();
    }

   public String messageText(VoteDTO voteDTO, VotingWithTimeCreated votingWithTimeCreated){
        StringBuilder message = new StringBuilder();
        message.append("Голос за артиста:\n        " + singerService.get(voteDTO.getIdSinger()) +".\n");
        message.append("Голос за жанры:\n");
        for(long id : voteDTO.getIdJenres()){
            message.append("        " + genreService.getOneJenre(id) + ".\n");
        }
        message.append("Ваше сообщение о себе:\n        " + voteDTO.getAboutInfaormation() + ".\n");
        message.append("Вы указали mail:\n        " + voteDTO.getMail()+ ".\n");
        message.append("Голос оставлен:\n        " + votingWithTimeCreated.getTimeCreated() + ".\n");
        return message.toString();
    }
}
