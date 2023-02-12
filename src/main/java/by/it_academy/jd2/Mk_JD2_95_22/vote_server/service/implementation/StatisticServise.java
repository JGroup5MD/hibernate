package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.implementation;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.JenresEntity;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.SingersEntity;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.VoteEntity;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.main_entity.MessageDTO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.statistic.StatisticDTO;
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

    public List<StatisticDTO> getResultGenre() {
        List<JenresEntity> jenres = genreService.getAllJenres();
        List<VoteEntity> votes = voteService.getVote();
        List<StatisticDTO> statisticJenre = new ArrayList<>();
        for(JenresEntity jenreID : jenres){
            statisticJenre.add(new StatisticDTO(jenreID.getId(), jenreID.getNameGenre()));
        }

        for(VoteEntity vote : votes){
//            for(int i = 0;i<vote.getGenres().size();i++){
//                boolean notAddingCount = true;
//                for(int j = 0;j<statisticJenre.size();j++){
//                    if(statisticJenre.get(j).getId()==vote.getGenres().get(i).getId()){
//                        statisticJenre.get(j);
            for(JenresEntity sizeVoteJenre : vote.getGenres()){
                boolean notAddingCount = true;
                for(StatisticDTO item: statisticJenre){
                    if(item.getId()==sizeVoteJenre.getId()){
//                }
//            }
                        notAddingCount = false;
                        break;
                    }
                }
                if(notAddingCount){
                    throw new ArrayStoreException("Такого голоса не существует в жанрах");
                }
            }
        }
        List<StatisticDTO> sortList = statisticJenre.stream().sorted(Comparator.comparing(StatisticDTO::getCount).reversed()).collect(Collectors.toList());
        return sortList;
    }


    public List<StatisticDTO> getResultSinger() {
        List<SingersEntity> singers = singerService.get();
        List<VoteEntity> votes = voteService.getVote();
        List<StatisticDTO> statisticSinger = new ArrayList<>();
        for(SingersEntity singer: singers){
            statisticSinger.add(new StatisticDTO(singer.getId(),singer.getNameArtist()));
        }
        for(VoteEntity vote : votes){
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

    public List<MessageDTO> getResultMessage() {
        List<VoteEntity> votes = voteService.getVote();
        List<MessageDTO> messages = new ArrayList<>();
        for(VoteEntity vote : votes){
            messages.add(new MessageDTO(vote.getDate(),vote.getAbout()));
        }
        List<MessageDTO> sortList = messages.stream().sorted(Comparator.comparing(MessageDTO::getTime)).collect(Collectors.toList());
        return sortList;
    }
}
