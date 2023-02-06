package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Singers;

import java.util.List;

public interface IDaoSinger {

    public List<Singers> get();
    public  boolean created(String newSinger);
    public  boolean delete(long id);
    public void update(Singers singers);
    public boolean exist(long id);
}
