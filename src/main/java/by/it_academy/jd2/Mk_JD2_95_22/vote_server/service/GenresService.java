package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IJenreDAO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Jenres;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IGenresService;

import java.util.List;

public class GenresService implements IGenresService {
    private final IJenreDAO dao;

    public GenresService(IJenreDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Jenres> get() {
        return dao.get();
    }

    @Override
    public Jenres get(long id) {
        List<Jenres> genres = this.dao.get();
        for (Jenres gen : genres){
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
        List<Jenres> genres = this.dao.get();
        for (Jenres gen : genres){
            if (id == gen.getId()){
                return true;
            }
        }
        return false;
    }
}
