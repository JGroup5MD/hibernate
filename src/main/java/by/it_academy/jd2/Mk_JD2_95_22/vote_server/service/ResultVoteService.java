package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.ResultVoteDto;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.entity.Artists;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.entity.Genres;
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
    public ResultVoteDto getResult() {

        return null;
    }

    @Override
    public Map<Artists, Long> getTopArtist() {
        return null;
    }

    @Override
    public List<Genres> getTopGenre() {
        return null;
    }
}
