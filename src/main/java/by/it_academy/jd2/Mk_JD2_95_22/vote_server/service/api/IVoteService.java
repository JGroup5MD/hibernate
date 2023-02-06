package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Vote;

import java.util.List;

public interface IVoteService {
    void save(Vote newVote);

    List<Vote> get();
}
