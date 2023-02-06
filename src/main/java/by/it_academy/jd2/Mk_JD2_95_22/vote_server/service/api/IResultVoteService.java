package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.VotingResault;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Singers;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Jenres;

import java.util.List;
import java.util.Map;

public interface IResultVoteService {
    VotingResault getResult();
    Map<Singers, Long> getTopArtist();
    List<Jenres> getTopGenre();
}
