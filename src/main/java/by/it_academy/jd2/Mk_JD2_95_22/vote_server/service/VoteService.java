package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IVoteDao;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.entity.Vote;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IArtistsService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IGenresService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IVoteService;

import java.util.List;

public class VoteService implements IVoteService {
    private final IVoteDao dao;
    private final IArtistsService artistsService;
    private final IGenresService genresService;

    public VoteService(IVoteDao dao, IArtistsService artistsService, IGenresService genresService) {
        this.dao = dao;
        this.artistsService = artistsService;
        this.genresService = genresService;
    }

    @Override
    public List<Vote> get() {
        return this.dao.get();
    }

    @Override
    public void save(Vote newVote) {
        this.dao.save(newVote);
    }

}
