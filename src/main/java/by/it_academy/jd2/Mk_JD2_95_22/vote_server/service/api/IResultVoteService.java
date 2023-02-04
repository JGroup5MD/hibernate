package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.VotingResault;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.entity.Artists;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.entity.Genres;

import java.util.List;
import java.util.Map;

public interface IResultVoteService {
    VotingResault getResult();
    Map<Artists, Long> getTopArtist();
    List<Genres> getTopGenre();
}
