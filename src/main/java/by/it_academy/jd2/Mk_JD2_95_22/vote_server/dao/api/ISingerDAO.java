package by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.SingersEntity;

import java.util.List;

public interface ISingerDAO {
    public List<SingersEntity> getAllSinger();
    public String getOneSinger(long id);
    public  boolean created(String newSinger);
    public boolean delete(long id);
    public void update(SingersEntity singers);
    public boolean exist(long id);
}
