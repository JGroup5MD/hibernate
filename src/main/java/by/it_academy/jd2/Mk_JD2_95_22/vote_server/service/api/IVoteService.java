package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Vote;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.VoteDTO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.VotingWithTimeCreated;

import java.util.List;

public interface IVoteService {
    public void save(VoteDTO voteDTO, VotingWithTimeCreated votingWithTimeCreated);
    public void validation(VoteDTO voteDTO);
    public List<Vote> getVote();

}
