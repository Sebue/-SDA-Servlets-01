package pl.sda.last;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/common")
public class Common extends HttpServlet {
    private static final Logger logger = Logger.getLogger(Common.class.getSimpleName());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.warning("Users still use /common endpoint!");
        request.getRequestDispatcher("/greetings")
                .forward(request, response);
    }
}
