package by.it_academy.jd2.Mk_JD2_95_22.vote_server.web.controllers;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.JenresEntity;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.IJenresService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.fabrics.JenresServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "GenresServlet", urlPatterns = "/jenre")
public class JenresServlet extends HttpServlet {
    private final String ADD = "add";
    private final String DELETE = "delete";

    private final IJenresService service;

    public JenresServlet() {
        this.service = JenresServiceSingleton.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        List<JenresEntity> genresList = service.getAllJenres();

        PrintWriter writer = resp.getWriter();
        genresList.forEach(p->writer.println(p));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String newGenre = req.getParameter(ADD);

        try {
            if (newGenre.isBlank()) {
                throw new IllegalArgumentException("Отсутствуют данные для выполнения добавления артиста");
            }

            service.created(newGenre);

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

        String[] deleteGenres = mapParam.get(DELETE);

        try {
            if (!mapParam.containsKey(DELETE) || deleteGenres == null) {
                throw new IllegalArgumentException("Отсутствуют данные для удаления");
            }

            int idDel = Integer.parseInt(deleteGenres[0]);

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
