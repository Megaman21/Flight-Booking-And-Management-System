package Controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignOutServlet")
public class SignOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.getSession().invalidate();
        request.logout();
        handleLogOutResponse(request,response);
        response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
        response.sendRedirect("home.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
    private void handleLogOutResponse(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            //  cookie.setValue(null);
            // cookie.setPath("/");
            response.addCookie(cookie);
        }


    }
}
