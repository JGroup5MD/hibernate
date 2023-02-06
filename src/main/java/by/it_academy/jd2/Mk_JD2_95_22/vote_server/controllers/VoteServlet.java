package by.it_academy.jd2.Mk_JD2_95_22.vote_server.controllers;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Vote;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IVoteService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.fabrics.VoteServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "VoteServlet", urlPatterns = "/vote")
public class VoteServlet extends HttpServlet {

    private final String ARTIST = "artist";
    private final String GENRES = "genre";
    private final String ABOUT = "about";
    private final String EMAIL = "email";
    private int genre_1;
    private int genre_2;
    private int genre_3;
    private int genre_4;
    private int genre_5;
    public List<Vote> newVote = new ArrayList<>();

    private final IVoteService service;

    public VoteServlet() {
        this.service = VoteServiceSingleton.getInstance();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        List<Vote> voteList = service.get();

        PrintWriter writer = resp.getWriter();
        voteList.forEach(p -> writer.println(p));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        Map<String, String[]> parameterMap = req.getParameterMap();
        LocalDateTime time = LocalDateTime.now();
        PrintWriter writer = resp.getWriter();

        String[] artists = parameterMap.get(ARTIST);
        String newVoteArtist = (artists == null) ? null : artists[0];
        if (newVoteArtist == null || artists.length > 1) {
            throw new IllegalArgumentException("Должен быть указан 1 артист");
        }
        int artist = Integer.parseInt(newVoteArtist);

        String[] newVoteGenre = parameterMap.get(GENRES);
        if (newVoteGenre.length < 3 & newVoteGenre.length > 5) {
            throw new IllegalArgumentException("Необходимо выбрать от 3 до 5 жанров");

        }

        if (newVoteGenre.length == 3) {
            genre_1 = (newVoteGenre[0] == null) ? null : Integer.parseInt(newVoteGenre[0]);
            genre_2 = (newVoteGenre[1] == null) ? null : Integer.parseInt(newVoteGenre[1]);
            genre_3 = (newVoteGenre[2] == null) ? null : Integer.parseInt(newVoteGenre[2]);
            genre_4 = 0;
            genre_5 = 0;
        } else if (newVoteGenre.length == 4) {
            genre_1 = (newVoteGenre[0] == null) ? null : Integer.parseInt(newVoteGenre[0]);
            genre_2 = (newVoteGenre[1] == null) ? null : Integer.parseInt(newVoteGenre[1]);
            genre_3 = (newVoteGenre[2] == null) ? null : Integer.parseInt(newVoteGenre[2]);
            genre_4 = (newVoteGenre[3] == null) ? null : Integer.parseInt(newVoteGenre[3]);
            genre_5 = 0;
        } else {
            genre_1 = (newVoteGenre[0] == null) ? null : Integer.parseInt(newVoteGenre[0]);
            genre_2 = (newVoteGenre[1] == null) ? null : Integer.parseInt(newVoteGenre[1]);
            genre_3 = (newVoteGenre[2] == null) ? null : Integer.parseInt(newVoteGenre[2]);
            genre_4 = (newVoteGenre[3] == null) ? null : Integer.parseInt(newVoteGenre[3]);
            genre_5 = (newVoteGenre[4] == null) ? null : Integer.parseInt(newVoteGenre[4]);
        }


        String[] abouts = parameterMap.get(ABOUT);
        String newVoteAbout = (abouts == null) ? null : abouts[0];

        String[] email = parameterMap.get(EMAIL);
        String newVoteEmail = (email == null) ? null : email[0];
        if (newVoteEmail == null) {
            throw new IllegalArgumentException("Вы не указали адрес электронной почты");
        }

        this.service.save(new Vote(artist, genre_1, genre_2, genre_3, genre_4, genre_5, newVoteAbout, newVoteEmail, time));

    }


}
