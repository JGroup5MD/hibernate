package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.VoteEntity;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.main_entity.VoteDTO;
import java.util.List;

public interface IVoteService {
    public void save(VoteDTO voteDTO);
    public void validation(VoteDTO voteDTO);
    public List<VoteEntity> getVote();

}
