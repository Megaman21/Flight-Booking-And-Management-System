package Controllers;

import Models.model_db;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ValidateEmail")
public class ValidateEmail extends HttpServlet {
    String email;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        //email=request.getParameter("email");
        email=Jsoup.clean(request.getParameter("email"), Whitelist.basic());
        model_db obj=new model_db();
        boolean check=obj.checkemail(email);
        if(check==true) {
            response.getWriter().print("The given email is valid");

        }
        else
        {

            response.getWriter().print("Invalid email ID");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
