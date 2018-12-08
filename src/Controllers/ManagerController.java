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
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ManagerController")
public class ManagerController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        flight obj=new flight();
      // System.out.println("servlet");
        List<flight> flights_list=new ArrayList<flight>();
        try {
             flights_list =obj.getAllFlights();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       // System.out.println(request.getParameter(String.valueOf(flights_list.get(0).getId())));
        //System.out.println(request.getParameter(String.valueOf(flights_list.get(1).getId())));
        model_db obj2=new model_db();

      for(int i=0;i<flights_list.size();i++)
      {
          String temp=request.getParameter(String.valueOf(flights_list.get(i).getId()));
          if(temp.equals("Accept")==true)
          {
              obj2.update_status(flights_list.get(i).getId());
          }
          else
          {
             obj2.delete_flight(flights_list.get(i).getId());
          }

      }
        RequestDispatcher rd = null;
        rd = request.getRequestDispatcher("manager.jsp");
        rd.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        RequestDispatcher rd = null;

        flight obj=new flight();
        try {
            List<flight> flights_list =obj.getAllFlights();
            System.out.println(flights_list.size());
            request.setAttribute("flights_list",flights_list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
       System.out.println("ok");
        rd = request.getRequestDispatcher("manager.jsp");
        rd.forward(request, response);

    }
}
