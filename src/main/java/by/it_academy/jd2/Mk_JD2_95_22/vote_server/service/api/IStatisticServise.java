package by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.JenreDTO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.Message;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.StatisticDTO;

import java.util.List;

public interface IStatisticServise {
    public List<JenreDTO> getResultGenre();
    public List<StatisticDTO> getResultSinger();
    public List<Message> getResultMessage();
}
