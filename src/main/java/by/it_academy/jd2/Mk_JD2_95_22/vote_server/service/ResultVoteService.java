package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.VotingResault;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Singers;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Jenres;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IResultVoteService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Map;

public class ResultVoteService implements IResultVoteService {
    private final String INQUIRY_ARTIST = "";
    private final String INQUIRY_GENRE = "";

    EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("tutorial");

    @Override
    public VotingResault getResult() {

        return null;
    }

    @Override
    public Map<Singers, Long> getTopArtist() {
        return null;
    }

    @Override
    public List<Jenres> getTopGenre() {
        return null;
    }
}
