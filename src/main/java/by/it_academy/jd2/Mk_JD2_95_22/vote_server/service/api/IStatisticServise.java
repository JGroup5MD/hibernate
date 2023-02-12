package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.main_entity.JenreDTO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.main_entity.MessageDTO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.statistic.StatisticDTO;

import java.util.List;

public interface IStatisticServise {
    public List<StatisticDTO> getResultGenre();
    public List<StatisticDTO> getResultSinger();
    public List<MessageDTO> getResultMessage();
}
