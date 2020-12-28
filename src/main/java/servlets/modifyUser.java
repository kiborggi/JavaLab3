package servlets;

import clases.JDBSConnector;
import clases.MessageDAO;
import clases.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(
        name = "modifyUser",
        urlPatterns = {"/modifyUser"})

public class modifyUser extends HttpServlet {

    protected void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
        System.out.println("модифай юзер");
        System.out.println(req.getParameter("role"));
        System.out.println(req.getParameter("id"));
        System.out.println(req.getParameter("name"));
        if (req.getParameter("name") != null & req.getParameter("role") != null & req.getParameter("id") != null) {
            System.out.println("апдейтинг");
            new JDBSConnector().update(Integer.parseInt((String) req.getParameter("id")), (String) req.getParameter("role"), (String) req.getParameter("name"));
        }
        res.sendRedirect("index");


    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doService(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doService(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
