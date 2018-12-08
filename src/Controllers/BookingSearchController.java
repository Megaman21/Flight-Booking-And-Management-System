package Controllers;

import Models.model_db;
import Models.searchResult;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;

@WebServlet(name = "BookingSearchController")
public class BookingSearchController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd=null;

        //String date=request.getParameter("date");
        String date= Jsoup.clean(request.getParameter("date"), Whitelist.basic());
        //String type=request.getParameter("class");
        String type= Jsoup.clean(request.getParameter("class"), Whitelist.basic());
        //String seats=request.getParameter("seats");
        String seats= Jsoup.clean(request.getParameter("seats"), Whitelist.basic());
        HttpSession session=request.getSession();
        session.setAttribute("date",date);
        session.setAttribute("class",type);
        session.setAttribute("seats",seats);
        Principal principal = request.getUserPrincipal();
        String username = principal.getName();
        session.setAttribute("username",username);
        model_db helper=new model_db();
        ArrayList<searchResult> flights=helper.searchFlights(request);
        request.setAttribute("list",flights);
        rd = request.getRequestDispatcher("searchresults.jsp");
        rd.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
