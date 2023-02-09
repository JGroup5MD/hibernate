package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api;

import java.util.Properties;

public interface IMailSendingServise {
    public void startEmailSender(long timeSendSec);
    public void stopEmailSender();
}
