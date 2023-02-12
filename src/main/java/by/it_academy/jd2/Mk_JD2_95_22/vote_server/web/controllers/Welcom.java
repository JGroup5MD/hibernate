package by.it_academy.jd2.Mk_JD2_95_22.vote_server.web.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Welcom", urlPatterns = {"/welcom"})

public class Welcom extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer=resp.getWriter();
        writer.write("<p>Добро подаловать на голосование</p>");
        writer.write("<p>Можно проголосовать только за одного артиста</p>");
        writer.write("<p>При выболе жанров действуют ограничения: не меньше трех и не больше пяти</p>");
        writer.write("<p>Незабудьте оставить информацию о себе и указать свой e-mail</p>");

    }
}
