package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.entity.Artists;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.entity.Genres;

import java.util.List;

public interface IGenresDao {
    List<Genres> get();

    boolean add (String newGenres);

    boolean delete(long id);

    boolean exist(long id);
}
