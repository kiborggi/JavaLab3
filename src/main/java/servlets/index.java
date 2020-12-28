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
        name = "index",
        urlPatterns = {"/index" })

public class index extends HttpServlet {
    protected void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ArrayList<User> list = new ArrayList<>();
        try {
             list = new JDBSConnector().show();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.setAttribute("users",list);
        req.getRequestDispatcher("indexPage.jsp").forward(req, res);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doService(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doService(req, resp);
    }

}
