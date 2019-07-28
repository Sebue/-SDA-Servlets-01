package pl.sda.sex;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/male")
public class Male extends HttpServlet {
    private static final Logger logger = Logger.getLogger(Male.class.getSimpleName());


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.warning("Users still use /male endpoint!");
        request.getRequestDispatcher("/greetings")
                .forward(request, response);
    }

}