//package pl.sex;
//
//import com.google.common.base.Strings;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.logging.Logger;
//
//@WebServlet("/greetings")
//public class Greetings extends HttpServlet {
//    private static final Logger logger = Logger.getLogger(Greetings.class.getSimpleName());
//    private static final String NAME = "name";
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        PrintWriter writer = response.getWriter();
//        response.setContentType("text/html");
//        String name = request.getParameter(NAME);
//        if(Strings.isNullOrEmpty(name)){
//            String msg = "Name was empty!";
//            logger.warning(msg);
//            writer.println("<h1>" + msg + "</h1>");
//        } else {
//            if(isFemaleName(name)){
//                request.getRequestDispatcher("/female")
//                        .forward(request, response);
//            } else {
//                request.getRequestDispatcher("/male")
//                        .forward(request, response);
//            }
//        }
//
//    }
//
//    private boolean isFemaleName(String name){
//        return name.matches(".+a");
//    }
//}
