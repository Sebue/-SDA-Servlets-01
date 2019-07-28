package pl.sda.sex;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/common")
public class Common extends HttpServlet {

    private static final String SEX = "last";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String sexValue = request.getParameter(SEX);

        if(sexValue == null){
            showMessage("Choose your last!", response);

        } else if (sexValue.equals("F")){
            request.getRequestDispatcher("/female")
                    .forward(request, response);

        } else if (sexValue.equals("M")){
            request.getRequestDispatcher("/male")
                    .forward(request, response);

        } else {
            showMessage("Wrong last!", response);
        }
    }

    private void showMessage(String message, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        writer.println("<h1>" + message + "</h1>");
        writer.println("<a href=\"http://localhost:8080/servlets/common?sex=F\">Choose to be a female</a><br>");
        writer.println("<a href=\"http://localhost:8080/servlets/common?sex=M\">Choose to be a male</a>");
    }
}
