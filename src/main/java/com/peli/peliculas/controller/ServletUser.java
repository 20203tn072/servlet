package com.peli.peliculas.controller;

import com.peli.peliculas.model.pelicula.BeanPelicula;
import com.peli.peliculas.model.pelicula.DaoPelicula;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletUser", value = "/ServletUser")
public class ServletUser extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(ServletUser.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listUsers", new DaoPelicula().findAll());
        request.getRequestDispatcher("/views/user/pelis.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        switch(action){
            case "create":
                // do something

                String nombre = request.getParameter("nombre");
                String descripcion = request.getParameter("password");
                String estreno = request.getParameter("estreno");
                int recaudacion = Integer.parseInt(request.getParameter("recaudacion"));

                BeanPelicula beanPelicula = new BeanPelicula(0, nombre, descripcion, estreno, recaudacion, 0);

                if(new DaoPelicula().create(beanPelicula)){
                    request.setAttribute("message", "Pelicula registrada correctamente");
                } else {
                    request.setAttribute("message", "Pelicula no registrada");
                }

                doGet(request, response);
                break;

            case "getUserById":
                // do something
                long id = Long.parseLong(request.getParameter("id"));
                request.setAttribute("user", new DaoPelicula().findById(id));
                request.getRequestDispatcher("/views/peli/update.jsp").forward(request, response);
                break;
            case "update":
                // do something

                long id1 = Long.parseLong(request.getParameter("id"));
                String nombre1 = request.getParameter("nombre");
                String descripcion1 = request.getParameter("password");
                String estreno1 = request.getParameter("estreno");
                int recaudacion1 = Integer.parseInt(request.getParameter("recaudacion"));

                BeanPelicula BeanPelicula1 = new BeanPelicula(id1, nombre1, descripcion1, estreno1, recaudacion1, 0);

                if(new DaoPelicula().update(BeanPelicula1)){
                    request.setAttribute("message", "Pelicula modificada correctamente");
                } else {
                    request.setAttribute("message", "Pelicula no modificada");
                }

                doGet(request, response);
                break;
            case "delete":
                long id2 = Long.parseLong(request.getParameter("id"));
                if(new DaoPelicula().delete(id2)){
                    request.setAttribute("message", "Pelicula eliminada correctamente");
                } else {
                    request.setAttribute("message", "Pelicula no eliminada");
                }
                doGet(request, response);
                break;
            default:
                // no supported
                break;
        }
    }
}
