package pl.sda.last;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/female")
public class Female extends HttpServlet {
    private static final Logger logger = Logger.getLogger(Female.class.getSimpleName());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.warning("Users still use /female endpoint!");
        request.getRequestDispatcher("/greetings")
                .forward(request, response);
    }

}