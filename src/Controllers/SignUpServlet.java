package Controllers;

import Models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignUpServlet",urlPatterns = {"/SignUpServlet"})
public class SignUpServlet extends HttpServlet {
    String email,password,type;
    boolean check;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        User user=new User();
        email=request.getParameter("email");
        password=request.getParameter("password");
        type=request.getParameter("type");
        user.setEmail(email);
        user.setPassword(password);
        user.setType(type);
        RequestDispatcher rd = null;
        check=user.signup_user();
        if(check==true){
            //session.setAttribute("user", user);
            rd = request.getRequestDispatcher("home.jsp");
        }
        else{
            //session.setAttribute("noUser", true);
            rd = request.getRequestDispatcher("signup.jsp");
        }
        rd.forward(request, response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
