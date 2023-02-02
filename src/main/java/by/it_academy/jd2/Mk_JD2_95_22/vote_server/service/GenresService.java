package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IGenresDao;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.entity.Genres;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IGenresService;

import java.util.List;

public class GenresService implements IGenresService {
    private final IGenresDao dao;

    public GenresService(IGenresDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Genres> get() {
        return dao.get();
    }

    @Override
    public Genres get(long id) {
        List<Genres> genres = this.dao.get();
        for (Genres gen : genres){
            if (id == gen.getId()){
                return gen;
            }
        }
        return null;
    }

    @Override
    public boolean add(String newGenre) {
        return dao.add(newGenre);
    }

    @Override
    public boolean delete(long id) {
        return dao.delete(id);
    }

    @Override
    public boolean exist(long id) {
        List<Genres> genres = this.dao.get();
        for (Genres gen : genres){
            if (id == gen.getId()){
                return true;
            }
        }
        return false;
    }
}
