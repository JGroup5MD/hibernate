package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Jenres;

import java.util.List;

public interface IJenresService {
    public List<Jenres> getAllJenres();
    public String getOneJenre(long id);
    public boolean created(String newNameJenre);
    public List<Jenres> update(long id);
    public boolean delete(long id);
    public boolean exist(long id);
    public boolean validate(String jenreName);

}
