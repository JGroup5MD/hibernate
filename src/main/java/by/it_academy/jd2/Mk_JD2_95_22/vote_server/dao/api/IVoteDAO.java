package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.JenresEntity;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.SingersEntity;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.VoteEntity;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.main_entity.VoteDTO;

import java.util.List;

public interface IVoteDAO {
    public List<VoteEntity>  getVote();
    public void save(VoteDTO votes);
    public SingersEntity Vote_Singer(VoteDTO votes);
    public List<JenresEntity> Vote_Janre(VoteDTO votes);
}
