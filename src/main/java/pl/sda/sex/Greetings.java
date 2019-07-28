package pl.sda.sex;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/greetings")
public class Greetings extends HttpServlet {
    private static final Logger logger = Logger.getLogger(Greetings.class.getSimpleName());
    public static final String NAME = "name";
    public static final String ATTRIBUTE_NAME = "valid";
    private static final List<String> FORBIDDEN_NAMES = ImmutableList.<String>builder()
            .add("Kupa")
            .add("Jessica")
            .add("Brian")
            .build();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        request.setAttribute(ATTRIBUTE_NAME, true);
        String name = request.getParameter(NAME);
        if (Strings.isNullOrEmpty(name)) {
            String msg = "Name was empty!";
            logger.warning(msg);
            writer.println("<h1>" + msg + "</h1>");
        } else if (FORBIDDEN_NAMES.contains(name)) {
            logger.warning("User used forbidden name: " + name);
            writer.println("<h1>FORBIDDEN NAME!</h1>");
        } else {
            request.getRequestDispatcher("/genders")
                    .forward(request, response);
        }

    }
}
