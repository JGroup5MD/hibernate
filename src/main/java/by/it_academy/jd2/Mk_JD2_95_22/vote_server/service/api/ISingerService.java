package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Singers;

import java.util.List;

public interface ISingerService {
    List<Singers> get();

    Singers get(long id);
    boolean add (String newArtist);

    boolean delete(long id);

    boolean exist(long id);



}
