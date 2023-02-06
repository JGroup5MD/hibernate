package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IDaoSinger;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Singers;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.ISingerService;

import java.util.List;

public class ArtistsService implements ISingerService {
    private final IDaoSinger dao;

    public ArtistsService(IDaoSinger dao) {
        this.dao = dao;
    }

    @Override
    public List<Singers> get() {
        return dao.get();
    }

    @Override
    public Singers get(long id) {
        List<Singers> artists = this.dao.get();
        for (Singers art : artists){
            if (id == art.getId()){
                return art;
            }
        }
        return null;
    }

    @Override
    public boolean add(String newArtist) {
        return dao.add(newArtist);
    }

    @Override
    public boolean delete(long id) {
        return dao.delete(id);
    }

    @Override
    public boolean exist(long id) {
        List<Singers> artists = this.dao.get();
        for (Singers art : artists){
            if (id == art.getId()){
                return true;
            }
        }
        return false;
    }
}
