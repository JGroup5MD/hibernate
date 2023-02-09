package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Jenres;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Singers;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Vote;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.JenreDTO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.Message;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.SingerDTO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.StatisticDTO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IJenresService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.ISingerService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IVoteService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StatisticServise {

    private final ISingerService singerService;
    private final IJenresService genreService;
    private final IVoteService voteService;

    public StatisticServise(ISingerService singerService, IJenresService genreService, IVoteService voteService) {
        this.singerService = singerService;
        this.genreService = genreService;
        this.voteService = voteService;
    }

    public List<JenreDTO> getResultGenre() {
        List<Jenres> genres = genreService.getAllJenres();
        List<Vote> votes = voteService.getVote();
        List<JenreDTO> statisticGenre = new ArrayList<>();
        for(Jenres genreID : genres){
            statisticGenre.add(new JenreDTO(genreID.getId(),genreID.getNameGenre()));
        }

        for(Vote vote : votes){
            for(int i = 0;i<vote.getGenres().size();i++){
                boolean notAddingCount = true;
                for(int j = 0;j<statisticGenre.size();j++){
                    if(statisticGenre.get(j).getIdJenre()==vote.getGenres().get(i).getId()){
                        statisticGenre.get(j);
                        notAddingCount = false;
                        break;
                    }
                }
                if(notAddingCount){
                    throw new ArrayStoreException("Такого голоса не существует в жанрах");
                }
            }
        }
        List<JenreDTO> sortList = statisticGenre.stream().sorted().collect(Collectors.toList());
        return sortList;
    }


    public List<StatisticDTO> getResultSinger() {
        List<Singers> singers = singerService.get();
        List<Vote> votes = voteService.getVote();
        List<StatisticDTO> statisticSinger = new ArrayList<>();
        for(Singers singer: singers){
            statisticSinger.add(new StatisticDTO(singer.getId(),singer.getNameArtist(), statisticSinger.stream().count()));
        }
        for(Vote vote : votes){
            boolean notAddingCount = true;
            for(int i = 0;i<statisticSinger.size();i++){
                if(vote.getSinger().getId()==statisticSinger.get(i).getId()){
                    statisticSinger.get(i).addCount();
                    notAddingCount = false;
                    break;
                }
            }
            if(notAddingCount){
                throw new ArrayStoreException("Такого исполнителя не существует в жанрах");
            }
        }
        List<StatisticDTO> sortList = statisticSinger.stream().sorted(Comparator.comparing(StatisticDTO::getCount).reversed()).collect(Collectors.toList());
        return sortList;
    }

    public List<Message> getResultMessage() {
        List<Vote> votes = voteService.getVote();
        List<Message> messages = new ArrayList<>();
        for(Vote vote : votes){
            messages.add(new Message(vote.getDate(),vote.getAbout()));
        }
        List<Message> sortList = messages.stream().sorted(Comparator.comparing(Message::getTime)).collect(Collectors.toList());
        return sortList;
    }
}
