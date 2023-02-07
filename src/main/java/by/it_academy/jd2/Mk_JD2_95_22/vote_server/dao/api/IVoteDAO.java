package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Jenres;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Singers;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Vote;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.VoteDTO;

import java.util.List;

public interface IVoteDAO {
    public List<Vote>  getVote();
    public void save(VoteDTO votes);
    public Singers Vote_Singer(VoteDTO votes);
    public List<Jenres> Vote_Janre(VoteDTO votes);
}
