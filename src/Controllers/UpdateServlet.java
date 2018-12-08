package Controllers;

import Models.flight;
import Models.model_db;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        model_db helper=new model_db();
        helper.updateFlight(request);

        response.sendRedirect("/updatepage");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html");
        RequestDispatcher rd = null;

        flight obj=new flight();
        try {
            List<flight> flights_list =obj.geteveryFlight();
            System.out.println(flights_list.size());
            request.setAttribute("flights_list",flights_list);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        rd = request.getRequestDispatcher("update.jsp");
        rd.forward(request, response);
    }
}
