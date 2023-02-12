package by.it_academy.jd2.Mk_JD2_95_22.vote_server.web.controllers;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.main_entity.VoteDTO;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IVoteService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.fabrics.VoteServiceSingleton;
import org.apache.commons.lang3.math.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Map;

@WebServlet(name="VoteServlet", urlPatterns = "/vote" +
        "")
public class VoteServlet extends HttpServlet {

        private final String SINGER_PARAM = "singer";
        private final String GENRE_PARAM = "genre";
        private final String MESSAGE_PARAM = "message";
        private final String EMAIL = "email";

        private final IVoteService service;

       public VoteServlet(IVoteService service) {
           this.service = VoteServiceSingleton.getInstance();
    }

    @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");

            Map<String, String[]> mapRequest = req.getParameterMap();
            PrintWriter writer = resp.getWriter();

            String[] singerID = mapRequest.get(SINGER_PARAM);
            try {
                if (singerID == null)
                    throw new IllegalArgumentException("Нет исполнителя с таким номером ID");
                if (singerID.length != 1) {
                    throw new IllegalArgumentException("Не может быть два одинаковых номера ID исполнителя");
                }
                int intExecutorID = Integer.parseInt(singerID[0]);


                String[] genresID = mapRequest.get(GENRE_PARAM);
                if (genresID == null)
                    throw new IllegalArgumentException("Нет жанра с таким номером ID");
                for (String genre : genresID) {
                    if (!NumberUtils.isNumber(genre) || genre == null) {
                        throw new IllegalArgumentException("НОмер ID дожен быть в виде числа");
                    }
                }
                long[] intGenresID = new long[genresID.length];
                for (int i = 0; i < genresID.length; i++) {
                    intGenresID[i] = Integer.parseInt(genresID[i]);
                }


                String[] message = mapRequest.get(MESSAGE_PARAM);
                if (message == null||message[0].length() == 0 || message[0].isBlank()) {
                    throw new IllegalArgumentException("Нет такого сообщения");
                }


                String[] email = mapRequest.get(EMAIL);
                if (email == null||email[0].length() == 0 || email[0].isBlank()) {
                    throw new IllegalArgumentException("Не найдено адреса Вашей электронной почты");
                }
                service.save((new VoteDTO(
                        intExecutorID,
                        intGenresID,
                        message[0],
                        email[0],
                        LocalDateTime.now()
                       )));

                String path = req.getContextPath() + "/result";
                resp.sendRedirect(path);
            }catch(RuntimeException e){
                writer.write("<p>" + e.getMessage() + "</p>");
            }
        }
}
