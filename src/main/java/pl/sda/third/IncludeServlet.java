package pl.sda.third;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static pl.sda.third.ForwardServlet.REDIRECT_PARAMETER;


@WebServlet("/include")
public class IncludeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException, ServletException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        writer.println("<h1>Strona przekierowania po stronie serwera - include</h1>");

        request.setAttribute(REDIRECT_PARAMETER, "Sebastian");
        request.getRequestDispatcher("/finalServlet")
                .include(request, response);
    }


}