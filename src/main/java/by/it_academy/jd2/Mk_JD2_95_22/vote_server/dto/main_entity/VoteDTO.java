package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.main_entity;

import java.time.LocalDateTime;
import java.util.Arrays;


public class VoteDTO {
    private long IdSinger;
    private long[] IdJenres;
    private String AboutInfaormation;
    private String mailAdress;
    private LocalDateTime TimeCreated;

    public VoteDTO(long idSinger, long[] idJenres, String aboutInfaormation, String mailAdress, LocalDateTime timeCreated) {
        this.IdSinger = idSinger;
        this.IdJenres = idJenres;
        this.AboutInfaormation = aboutInfaormation;
        this.mailAdress = mailAdress;
        this.TimeCreated = timeCreated;
    }

    public long getIdSinger() {
        return IdSinger;
    }

    public long[] getIdJenres() {
        return IdJenres;
    }

    public String getAboutInfaormation() {
        return AboutInfaormation;
    }

    public String getMailAdress() {
        return mailAdress;
    }

    public LocalDateTime getTimeCreated() {
        return TimeCreated;
    }

    @Override
    public String toString() {
        return "VoteDTO{" +
                "IdSinger=" + IdSinger +
                ", IdJenres=" + Arrays.toString(IdJenres) +
                ", AboutInfaormation='" + AboutInfaormation + '\'' +
                ", mailAdress='" + mailAdress + '\'' +
                ", TimeCreated=" + TimeCreated +
                '}';
    }
}