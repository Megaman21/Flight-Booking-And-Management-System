import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static java.io.FileDescriptor.out;

@WebServlet(name = "SigninServelet", urlPatterns = {"/SigninServlet"})
public class SigninServelet extends HttpServlet {
    String email, password;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        email = request.getParameter("email");
        password =  request.getParameter("password");

        PrintWriter out = response.getWriter();
        out.println(email + " " + password);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
