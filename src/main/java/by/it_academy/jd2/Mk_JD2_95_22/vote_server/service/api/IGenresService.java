package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Jenres;

import java.util.List;

public interface IGenresService {
    List<Jenres> get();

    Jenres get(long id);
    boolean add (String newGenres);

    boolean delete(long id);

    boolean exist(long id);

}
