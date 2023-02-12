package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.JenresEntity;

import java.util.List;

public interface IJenreDAO {
    public List<JenresEntity> getAllJenres();
    public String getOneJenre(long id);
    public  boolean created(String newJenre);
    public boolean delete(long id);
    public void update(JenresEntity jenres);
    public boolean exist(long id);

}
