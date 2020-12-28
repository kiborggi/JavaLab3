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
        name = "modify",
        urlPatterns = {"/modify"})

public class modify extends HttpServlet {
    protected void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {



        String idStr = req.getParameter("id");
        int id = Integer.parseInt(idStr);
        boolean exist;

        if (new JDBSConnector().getByID(id) != null){
            exist = true;
        }
        else {exist= false;}

        req.setAttribute("id", req.getParameter("id"));
        req.setAttribute("exists", exist);
        req.setAttribute("messages", new MessageDAO().getMessagesFrom(Integer.parseInt(req.getParameter("id"))));
        req.getRequestDispatcher("modifyPage.jsp").forward(req, res);

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
