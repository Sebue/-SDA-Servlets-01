package pl.sda.third;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static pl.sda.third.ForwardServlet.REDIRECT_PARAMETER;

@WebServlet("/finalServlet")
public class FinalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {
        String attributeValue = (String) request.getAttribute("name");
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        if (attributeValue != null) {
            writer.println("<h1>Hello, " + attributeValue + "!</h1>");
        } else {
            //logger
            writer.println("<h1>Unauthorized access!</h1>");
        }
    }


}