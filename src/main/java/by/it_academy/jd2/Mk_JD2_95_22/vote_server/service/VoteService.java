package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IVoteDAO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Vote;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.ISingerService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IGenresService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IVoteService;

import java.util.List;

public class VoteService implements IVoteService {
    private final IVoteDAO dao;
    private final ISingerService artistsService;
    private final IGenresService genresService;

    public VoteService(IVoteDAO dao, ISingerService artistsService, IGenresService genresService) {
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
