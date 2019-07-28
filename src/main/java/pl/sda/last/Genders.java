package pl.sda.last;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import static pl.sda.last.Greetings.ATTRIBUTE_NAME;
import static pl.sda.last.Greetings.NAME;

@WebServlet("/genders")
public class Genders extends HttpServlet {
    private static final Logger logger = Logger.getLogger(Genders.class.getSimpleName());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Object attribute = request.getAttribute(ATTRIBUTE_NAME);
        boolean attributeValue;
        if (attribute == null) {
            attributeValue = false;
        } else {
            attributeValue = (boolean) attribute;
        }
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");

        if (attributeValue) {
            String name = request.getParameter(NAME);
            if (isFemaleName(name)) {
                Names.FEMALE_NAMES.add(name);
                logger.info("Female name added: " + name);
            } else {
                Names.MALE_NAMES.add(name);
                logger.info("Male name added: " + name);
            }
            writer.println("<h1>Hello, " + name + "!</h1>");
        } else {
            logger.warning("Unauthorized access to Genders!");
            writer.println("<h1>Wrong request!</h1>");
        }
    }


    private boolean isFemaleName(String name) {
        return name.matches(".+a");
    }

}