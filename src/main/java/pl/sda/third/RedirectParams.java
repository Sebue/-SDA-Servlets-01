package pl.sda.third;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/redirect")
public class RedirectParams extends HttpServlet {

    public static final String REDIRECT_PARAMETER = "name";

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute(REDIRECT_PARAMETER, "Sebastian");
        request.getRequestDispatcher("/finalServlet")
                .forward(request, response);
    }


}