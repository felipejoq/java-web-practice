package com.uncodigo.crudloginweb;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Mostrar el id de la sesion
        HttpSession session = request.getSession();
        System.out.println("Session ID: " + session.getId());
        // Responder con el jsp de login
        request.getRequestDispatcher("/login/login.jsp").forward(request, response);
    }

    public void destroy() {
    }
}