package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Map;
import java.util.Objects;

public class VotingResault {
   private final Map<SingerDTO, Integer> topSingers;
   private final Map<JenreDTO, Integer> topJenres;
   private final Map<VotingWithTimeCreated, Integer> voting;

    public VotingResault(Map<SingerDTO, Integer> topSingers, Map<JenreDTO, Integer> topJenres, Map<VotingWithTimeCreated, Integer> voting) {
        this.topSingers = topSingers;
        this.topJenres = topJenres;
        this.voting = voting;
    }

    public Map<SingerDTO, Integer> getTopSingers() {
        return topSingers;
    }

    public Map<JenreDTO, Integer> getTopJenres() {
        return topJenres;
    }

    public Map<VotingWithTimeCreated, Integer> getVoting() {
        return voting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VotingResault that = (VotingResault) o;
        return Objects.equals(topSingers, that.topSingers) && Objects.equals(topJenres, that.topJenres) && Objects.equals(voting, that.voting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topSingers, topJenres, voting);
    }

    @Override
    public String toString() {
        return "VotingResault{" +
                "topSingers=" + topSingers +
                ", topJenres=" + topJenres +
                ", voting=" + voting +
                '}';
    }
}
