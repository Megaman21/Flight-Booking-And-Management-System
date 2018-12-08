package Controllers;

import Models.model_db;
import Models.searchResult;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BookingController")
public class BookingController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd=null;
        model_db helper=new model_db();
        if(helper.checkBookingDeatails(request))
        {
            rd = request.getRequestDispatcher("confirmbooking.jsp");
            searchResult result=helper.getFlight(request);
            request.setAttribute("flight",result);
        }
        else {
            rd = request.getRequestDispatcher("Error.jsp");
        }

        rd.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
