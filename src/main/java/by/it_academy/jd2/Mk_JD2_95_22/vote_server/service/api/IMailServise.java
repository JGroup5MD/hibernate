package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.MailEntity;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.main_entity.VoteDTO;


import java.util.List;

public interface IMailServise {
    public void save(VoteDTO voteDTO);
    public boolean update(long id, String message, boolean validateEmail,
                          boolean sendMessage, long lastSendTime, String mail);
    public List<MailEntity> getEmailForSend();
    public boolean validateEmail(String mail);
    public String messageText(VoteDTO voteDTO);
}

