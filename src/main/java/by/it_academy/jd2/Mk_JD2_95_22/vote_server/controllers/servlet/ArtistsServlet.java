package by.it_academy.jd2.Mk_JD2_95_22.vote_server.controllers.servlet;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dto.entity.Artists;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IArtistsService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.fabrics.ArtistsServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;


@WebServlet(name = "ArtistsServlet", urlPatterns = "/artist")
public class ArtistsServlet extends HttpServlet {
    private final String ADD = "add";
    private final String DELETE = "delete";

    private final IArtistsService service;

    public ArtistsServlet() {
        this.service = ArtistsServiceSingleton.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        List<Artists> artistsList = service.get();

        PrintWriter writer = resp.getWriter();
        artistsList.forEach(p->writer.println(p));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String newArtist = req.getParameter(ADD);

        try {
            if (newArtist.isBlank()) {
                throw new IllegalArgumentException("Отсутствуют данные для выполнения добавления артиста");
            }

            service.add(newArtist);

        } catch (RuntimeException e) {
            writer.write("<p>" + e.getMessage() + "</p>");
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        Map<String, String[]> mapParam = req.getParameterMap();

        String[] deleteArtists = mapParam.get(DELETE);

        try {
            if (!mapParam.containsKey(DELETE) || deleteArtists == null) {
                throw new IllegalArgumentException("Отсутствуют данные для удаления");
            }

            int idDel = Integer.parseInt(deleteArtists[0]);

            if (service.exist(idDel)) {
                service.delete(idDel);
            } else {
                throw new IllegalArgumentException("Такого id для удаления не существует");
            }

        } catch (RuntimeException e) {
            writer.write("<p>" + e.getMessage() + "</p>");
        }


    }
}
