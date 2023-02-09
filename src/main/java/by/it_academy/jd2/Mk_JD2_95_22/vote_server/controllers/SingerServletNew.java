package by.it_academy.jd2.Mk_JD2_95_22.vote_server.controllers;

import by.it_academy.jd2.Mk_JD2_95_22.vote_server.dao.entity.Singers;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.SingerServise;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.api.ISingerService;
import by.it_academy.jd2.Mk_JD2_95_22.vote_server.service.fabrics.SingerServiceSingleton;
import org.apache.commons.lang3.math.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "SingersServlet", urlPatterns = "/singer")

public class SingerServletNew  extends HttpServlet {


        private final String DELETE = "deleteId";
        private final String ADD = "add";
        private final String ID = "updateId";
        private final String NEW_NAME = "newName";

        private final SingerServise service;

        public SingerServletNew() {
            this.service = SingerServiceSingleton.getInstance();
        }


        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");

            List<Singers> singerDTOS = service.get();

            PrintWriter writer = resp.getWriter();

            for (Singers singerID : singerDTOS) {
                writer.write("<p>" + singerID.getId() + ". " + singerID.getNameArtist() + "</p>");
            }
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");

            PrintWriter writer = resp.getWriter();

            Map<String, String[]> mapParameters = req.getParameterMap();

            List<Singers> singers = service.get();

            String[] addSinger = mapParameters.get(ADD);

            try{
                if (!mapParameters.containsKey(ADD) || addSinger == null) {
                    throw new IllegalArgumentException("Ключ операции не передан или передан не правильно");
                }
                service.created(addSinger[0]);

                writer.write("<p> Вы добавили исполнителя - " + addSinger[0] + "!</p>");
            }catch(RuntimeException e){
                writer.write("<p>" + e.getMessage() + "</p>");
            }
        }

        @Override
        protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");

            PrintWriter writer = resp.getWriter();
            Map<String, String[]> mapParameters = req.getParameterMap();

            String[] singerId = mapParameters.get(ID);
            String[] newName = mapParameters.get(NEW_NAME);

            try {
                if (!mapParameters.containsKey(ID) || singerId == null ||
                        !mapParameters.containsKey(NEW_NAME) || newName == null) {
                    throw new IllegalArgumentException("Ключ операции не передан или передан не правильно");
                }
                if (!NumberUtils.isDigits(singerId[0])) {
                    throw new IllegalArgumentException("Singer ID must be number");
                }

            }catch(RuntimeException e){
                writer.write("<p>" + e.getMessage() + "</p>");
            }
        }

        @Override
        protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");

            PrintWriter writer = resp.getWriter();

            Map<String, String[]> mapParameters = req.getParameterMap();

            List<Singers> singers = service.get();

            String[] deleteSinger = mapParameters.get(DELETE);

            try{
                if (!mapParameters.containsKey(DELETE) || deleteSinger == null ) {
                    throw new IllegalArgumentException("Ключ операции не передан или передан не правильно");
                }
                if (!NumberUtils.isDigits(deleteSinger[0])) {
                    throw new IllegalArgumentException("Singer ID must be number");

                    } else {
                        throw new IllegalArgumentException("Такого id для удаления не существует");
                    }

            }catch(RuntimeException e){
                writer.write("<p>" + e.getMessage() + "</p>");
            }
        }
    }

