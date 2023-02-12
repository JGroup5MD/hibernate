package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.SingersEntity;

import java.util.List;

public interface ISingerService {

    public List<SingersEntity> get();
    public String getNameSinger(long id);
    public boolean created(String newNameSinger);
    public List<SingersEntity> update(long id);
    public boolean delete(long id);
    public boolean exist(long id);
    public boolean validate(String SingerName);
}
