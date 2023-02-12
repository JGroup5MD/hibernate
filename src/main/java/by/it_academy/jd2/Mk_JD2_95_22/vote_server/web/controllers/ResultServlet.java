package by.it_academy.jd2.Mk_JD2_95_22.vote_server.web.controllers;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.statistic.StatisticDTO;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.fabrics.StatisticServiseSingleton;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.implementation.StatisticServise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name="ResultServlet", urlPatterns = "/result")
public class ResultServlet extends HttpServlet {
    private final StatisticServise ss;

    public ResultServlet(StatisticServise ss) {
        this.ss = StatisticServiseSingleton.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer=resp.getWriter();
        List<StatisticDTO> sortingSingers=ss.getResultSinger();
        int n=1;
        writer.write("<p> Пятерка лучших исполнителей</p>");
        for(StatisticDTO singers:sortingSingers){
            writer.write("<p>" + n + " Место: " + singers.getName() + singers.getCount() +
                            " голов" + "</p>");
            n++;
        }

        List<StatisticDTO> sortingJenres=ss.getResultGenre();
        int m=1;
        writer.write("<p> Пятерка лучших исполнителей</p>");
        for(StatisticDTO singers:sortingSingers){
            writer.write("<p>" + m+ " Место: " + singers.getName() + singers.getCount() +
                    " голов" + "</p>");
            n++;

    }
    }
}

