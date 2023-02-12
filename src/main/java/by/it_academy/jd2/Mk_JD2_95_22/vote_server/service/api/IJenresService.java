package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.JenresEntity;

import java.util.List;

public interface IJenresService {
    public List<JenresEntity> getAllJenres();
    public String getOneJenre(long id);
    public boolean created(String newNameJenre);
    public List<JenresEntity> update(long id);
    public boolean delete(long id);
    public boolean exist(long id);
    public boolean validate(String jenreName);

}
