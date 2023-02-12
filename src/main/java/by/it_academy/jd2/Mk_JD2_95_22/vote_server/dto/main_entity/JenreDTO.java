package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.main_entity;

import java.util.Objects;

public class JenreDTO {
    private long IdJenre;
    private String JenreName;


    public JenreDTO(long IdJenre,String jenreName) {
        this.IdJenre =IdJenre;
        this.JenreName = jenreName;
    }

    public String getJenreName() {
        return JenreName;
    }

    public long getIdJenre() {
        return IdJenre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JenreDTO jenreDTO = (JenreDTO) o;
        return IdJenre == jenreDTO.IdJenre && Objects.equals(JenreName, jenreDTO.JenreName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IdJenre, JenreName);
    }

    @Override
    public String toString() {
        return "JenreDTO{" +
                "IdJenre=" + IdJenre +
                ", JenreName='" + JenreName + '\'' +
                '}';
    }
}
