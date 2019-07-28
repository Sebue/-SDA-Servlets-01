package pl.sda.sex;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/names")
public class NamesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        writer.println("<h1>Female names: </h1><br>");
        for (String femaleName : Names.FEMALE_NAMES) {
            writer.println("<h2>" + femaleName + "</h2><br>");
        }
        writer.println("<h1>Male names: </h1><br>");
        for (String maleName : Names.MALE_NAMES) {
            writer.println("<h2>" + maleName + "</h2><br>");
        }

    }
}
