package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.main_entity.VoteDTO;

import java.util.Properties;

public interface IMailSenderAndVAlidate {
    public void SendingEmailService(Properties prop);
    public void sendEmail(VoteDTO vdto);
    public boolean validateEmail(String email);
}
