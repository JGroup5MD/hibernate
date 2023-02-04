package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class VotingWithTimeCreated {
    private VoteDTO votes;
    private LocalDateTime TimeCreated;

    public VotingWithTimeCreated(VoteDTO votes, LocalDateTime timeCreated) {
        this.votes = votes;
        TimeCreated = timeCreated;
    }

    public VoteDTO getVotes() {
        return votes;
    }

    public void setVotes(VoteDTO votes) {
        this.votes = votes;
    }

    public LocalDateTime getTimeCreated() {
        return TimeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        TimeCreated = timeCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VotingWithTimeCreated that = (VotingWithTimeCreated) o;
        return Objects.equals(votes, that.votes) && Objects.equals(TimeCreated, that.TimeCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(votes, TimeCreated);
    }

    @Override
    public String toString() {
        return "VotingWithTimeCreated{" +
                "votes=" + votes +
                ", TimeCreated=" + TimeCreated +
                '}';
    }
}
