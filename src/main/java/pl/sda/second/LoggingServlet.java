package pl.sda.second;

import com.google.common.base.Throwables;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;


@WebServlet(urlPatterns = {"/logger", "/log"})
public class LoggingServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(LoggingServlet.class.getSimpleName());
    private static final String PARAMETER = "valid";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String parameterValue = request.getParameter(PARAMETER);

        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        if (parameterValue == null) {
            logger.warning("Client used servlet incorrectly.");
        } else if (!parameterValue.equals("hello")) {
            try {
                Integer integer = Integer.valueOf(parameterValue);
                int i = 30 / integer;
                writer.println("Wynik: " + i);
            } catch (Exception e) {
                logger.warning("Exception from: " + parameterValue);
                logger.warning(Throwables.getStackTraceAsString(e));
            }

        } else {
            logger.info("Parameter value is " + parameterValue);
        }

        writer.println("Test logowania");
    }


}
