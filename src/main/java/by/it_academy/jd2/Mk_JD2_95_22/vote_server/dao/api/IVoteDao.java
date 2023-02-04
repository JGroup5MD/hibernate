package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.entity.Vote;

import java.util.List;

public interface IVoteDao {

    List<Vote> get();

    boolean save (Vote newVote);

}
