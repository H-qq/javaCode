package ServletDemo1;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hongtao
 * @create 2022-04-19-23:19
 *
 * 基于注解开发Servlet
 */
@WebServlet( "/ServletDemo1")
public class Demo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("注解开发 demo1!");
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("username","小七睡觉");
    }
}
