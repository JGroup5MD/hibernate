package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.api.IVoteDAO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Vote;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.VoteDTO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.VotingWithTimeCreated;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IJenresService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IMailServise;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.ISingerService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IVoteService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VoteService implements IVoteService {
    private final IVoteDAO dao;
    private final ISingerService singerService;
    private final IJenresService genreService;

    private final IMailServise mailService;

    public VoteService(IVoteDAO dao, ISingerService singerService, IJenresService genreService, IMailServise mailService) {
        this.dao = dao;
        this.singerService = singerService;
        this.genreService = genreService;
        this.mailService = mailService;
    }


    public void save(VoteDTO voteDTO, VotingWithTimeCreated votingWithTimeCreated) {
        validation(voteDTO);
        this.dao.save(voteDTO);
        this.mailService.save(voteDTO,  votingWithTimeCreated);
    }

    public void validation(VoteDTO voteDTO){
        long singerID = voteDTO.getIdSinger();
        long[] genresID = voteDTO.getIdJenres();

        if(!singerService.exist(singerID)){
            throw new IllegalArgumentException("Такого исполнителя не существует");
        }

        Set<Long> set = new HashSet<>();
        for (long genreID : genresID){
            set.add(genreID);
        }

        if (set.size() != genresID.length){
            throw new IllegalArgumentException("В Вашем голосе жанры дублируются");
        }

        if (genresID.length > 5 || genresID.length < 3){
            throw new IllegalArgumentException("Количество жанров должно быть от 3 до 5, и жанры не должны повторяться");
        }

        for (long genreID : genresID){
            if(!genreService.exist(genreID)){
                throw new IllegalArgumentException("Жанра с id " + genreID + " не существует.");
            }
        }
        if(voteDTO.getAboutInfaormation().isBlank()||voteDTO.getAboutInfaormation().length()==0){
            throw new IllegalArgumentException("Сообщение о себе не может быть пустым");
        }
        if(voteDTO.getAboutInfaormation().length() <50){
            throw new IllegalArgumentException("Длина сообщения о себе не может быть короче чем 50 символов");
        }
        if(voteDTO.getMail().length() > 50){
            throw new IllegalArgumentException("Длина почты email не должна превышать 50 символов");
        }
    }


    public List<Vote> getVote() {
        return dao.getVote();
    }

}
