package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class MailEntity {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;
    @Column(name = "text")
    private String messageText;
    @Column(name = "validateEmail")
    private boolean validateEmail;
    @Column(name = "sendMassage")
    private boolean sendMassage;
    @Column(name = "lastSendTime")
    private long lastSendTime;
    @Column(name = "email")
    private String adressMail;

    public MailEntity() {
    }

    public MailEntity(long id, String messageText, boolean validateEmail, boolean sendMassage, long lastSendTime, String adressMail) {
        this.id = id;
        this.messageText = messageText;
        this.validateEmail = validateEmail;
        this.sendMassage = sendMassage;
        this.lastSendTime = lastSendTime;
        this.adressMail = adressMail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public boolean isValidateEmail() {
        return validateEmail;
    }

    public void setValidateEmail(boolean validateEmail) {
        this.validateEmail = validateEmail;
    }

    public boolean isSendMassage() {
        return sendMassage;
    }

    public void setSendMassage(boolean sendMassage) {
        this.sendMassage = sendMassage;
    }

    public long getLastSendTime() {
        return lastSendTime;
    }

    public void setLastSendTime(long lastSendTime) {
        this.lastSendTime = lastSendTime;
    }

    public String getAdressMail() {
        return adressMail;
    }

    public void setAdressMail(String adressMail) {
        this.adressMail = adressMail;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "id=" + id +
                ", messageText='" + messageText + '\'' +
                ", validateEmail=" + validateEmail +
                ", sendMassage=" + sendMassage +
                ", lastSendTime=" + lastSendTime +
                ", adressMail='" + adressMail + '\'' +
                '}';
    }
}
