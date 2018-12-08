package Controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogInServlet" ,urlPatterns = {"/LogInServlet"})
public class LogInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd=null;
       // response.sendRedirect("/managerhomepage");
        if(request.isUserInRole("admin"))
        {
           // response.sendRedirect("/admin");
            //return;
            rd = request.getRequestDispatcher("addflight.jsp");
            rd.forward(request,response);
        }
        else if(request.isUserInRole("manager"))
        {
            response.sendRedirect("/managerhomepage");
            return;
        }
        else if(request.isUserInRole("customer"))
        {
            rd = request.getRequestDispatcher("booking.jsp");
            rd.forward(request,response);
        }
//        else
//        {
//            rd = request.getRequestDispatcher("View/booking.jsp");
//        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
