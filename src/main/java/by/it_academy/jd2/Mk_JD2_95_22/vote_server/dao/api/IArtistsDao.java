package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.entity.Artists;

import java.util.List;

public interface IArtistsDao {
    List<Artists> get();

    boolean add (String newArtist);

    boolean delete(long id);

    boolean exist(long id);


}
