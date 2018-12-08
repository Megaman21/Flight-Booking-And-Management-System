package Controllers;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "EmailController")
public class EmailController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String host;
        String port;
        String user;
        String pass;
        String res;

        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");

        HttpSession session=request.getSession();
        String subject="Booking Details";
        String content="Dear Customer your Flight "+request.getAttribute("flightname")+" will depart from "+request.getAttribute("from")+" to "+request.getAttribute("to")+" on "+session.getAttribute("date");
        String resultMessage = "";

        try {
            EmailUtility.sendEmail(host, port, user, pass, (String) session.getAttribute("username"), subject,content);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        }
        response.sendRedirect("home.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);

    }
}
