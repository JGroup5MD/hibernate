package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Jenres;

import java.util.List;

public interface IJenreDAO {
    List<Jenres> get();

    boolean add (String newGenres);

    boolean delete(long id);

    boolean exist(long id);
}
