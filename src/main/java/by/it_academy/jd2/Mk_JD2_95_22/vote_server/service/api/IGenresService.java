package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.entity.Genres;

import java.util.List;

public interface IGenresService {
    List<Genres> get();

    Genres get(long id);
    boolean add (String newGenres);

    boolean delete(long id);

    boolean exist(long id);

}
