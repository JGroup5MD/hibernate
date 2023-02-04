package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto;

import java.util.List;
import java.util.Objects;

public class VoteDTO {
    private long IdSinger;
    private List<JenreDTO> IdJenres;
    private String AboutInfaormation;
    private String mail;

    public VoteDTO(long votingSinger, List<JenreDTO> IdJenres, String aboutInfaormation, String mail) {
        IdSinger = votingSinger;
        this.IdJenres = IdJenres;
        AboutInfaormation = aboutInfaormation;
        this.mail = mail;
    }

    public long getIdSinger() {
        return IdSinger;
    }

    public void setIdSinger(long idSinger) {
        IdSinger = idSinger;
    }

    public List<JenreDTO> getIdJenres() {
        return IdJenres;
    }

    public void setIdJenres(List<JenreDTO> idJenres) {
        IdJenres = idJenres;
    }

    public String getAboutInfaormation() {
        return AboutInfaormation;
    }

    public void setAboutInfaormation(String aboutInfaormation) {
        AboutInfaormation = aboutInfaormation;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoteDTO voteDTO = (VoteDTO) o;
        return IdSinger == voteDTO.IdSinger && Objects.equals(IdJenres, voteDTO.IdJenres) && Objects.equals(AboutInfaormation, voteDTO.AboutInfaormation) && Objects.equals(mail, voteDTO.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IdSinger, IdJenres, AboutInfaormation, mail);
    }

    @Override
    public String toString() {
        return "VoteDTO{" +
                "IdSinger=" + IdSinger +
                ", jenres=" + IdJenres +
                ", AboutInfaormation='" + AboutInfaormation + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}