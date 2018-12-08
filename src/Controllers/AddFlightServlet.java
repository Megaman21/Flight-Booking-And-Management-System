package Controllers;

import Models.flight;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "AddFlightServlet" ,urlPatterns = {"/AddFlightServlet"})
public class AddFlightServlet extends HttpServlet {
    String flight_name,from_city,to_city;
    java.util.Date departure_date,arrival_date;
    int total,business_seats,economy_seats,firstclass_seats;
    int economy_price,firstclass_price,business_price;
    int status;
    String f_date,t_date;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        status=0;
        flight obj= new flight();
        //flight_name=request.getParameter("flight no.");
        //from_city=request.getParameter("from");
        //to_city=request.getParameter("to");
        flight_name= Jsoup.clean(request.getParameter("flight no."), Whitelist.basic());
        from_city=Jsoup.clean(request.getParameter("from"), Whitelist.basic());
        to_city=Jsoup.clean(request.getParameter("to"), Whitelist.basic());

        //f_date=request.getParameter("departure date");
        //t_date=request.getParameter("arrival date");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            departure_date = formatter.parse(request.getParameter("departure date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        try {
//            arrival_date = formatter.parse(request.getParameter("arrival date"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

        String temp;
        temp=Jsoup.clean((request.getParameter("total")), Whitelist.basic());
        total=Integer.parseInt(temp);
        temp=Jsoup.clean((request.getParameter("business seats")), Whitelist.basic());
        business_seats=Integer.parseInt(temp);
        temp=Jsoup.clean((request.getParameter("economy seats")), Whitelist.basic());
        economy_seats=Integer.parseInt(temp);
        temp=Jsoup.clean((request.getParameter("first seats")), Whitelist.basic());
        firstclass_seats=Integer.parseInt(temp);
        temp=Jsoup.clean((request.getParameter("first price")), Whitelist.basic());
        firstclass_price=Integer.parseInt(temp);
        temp=Jsoup.clean((request.getParameter("economy price")), Whitelist.basic());
        economy_price=Integer.parseInt(temp);
        temp=Jsoup.clean((request.getParameter("business price")), Whitelist.basic());
        business_price=Integer.parseInt(temp);
      //  business_seats=Integer.parseInt(request.getParameter("business seats"));
        //economy_seats=Integer.parseInt(request.getParameter("economy seats"));
      //  firstclass_seats=Integer.parseInt(request.getParameter("first seats"));
       // firstclass_price=Integer.parseInt(request.getParameter("first price"));
       // economy_price=Integer.parseInt(request.getParameter("economy price"));
       // business_price=Integer.parseInt(request.getParameter("business price"));
        obj.setFlight_name(flight_name);
        obj.setFrom_city(from_city);
        obj.setTo_city(to_city);
        obj.setFrom_date(departure_date);

        obj.setTotal_seats(total);
        obj.setEconomy_seats(economy_seats);
        obj.setBusiness_seats(business_seats);
        obj.setFirstclass_seats(firstclass_seats);
        obj.setFirstclass_price(firstclass_price);
        obj.setEconomy_price(economy_price);
        obj.setBusiness_price(business_price);
        obj.save();

        RequestDispatcher rd = null;
        rd = request.getRequestDispatcher("addflight.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
