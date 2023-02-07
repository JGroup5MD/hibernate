package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Jenres;

import java.util.List;

public interface IJenreDAO {
    public List<Jenres> getAllJenres();
    public String getOneJenre(long id);
    public  boolean created(String newJenre);
    public boolean delete(long id);
    public void update(Jenres jenres);
    public boolean exist(long id);

}
