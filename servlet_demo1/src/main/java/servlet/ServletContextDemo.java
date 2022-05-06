package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hongtao
 * @create 2022-04-19-22:29
 */

public class ServletContextDemo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取ServletContext对象
        ServletContext context = getServletContext();

        //常用方法
            //获取全局配置参数 就是配置文件中的数据  name value
        String value = context.getInitParameter("globalDesc");
        System.out.println(value);

            //获取文件虚拟目录 getContextPath();
        String contextPath = context.getContextPath();
        System.out.println(contextPath);

            //重要：根据虚拟目录获取绝对路径: getRealPath()  获取文件绝对路径
        String realPath = context.getRealPath("/");
        System.out.println(realPath);

        String realPath1 = context.getRealPath("/a.txt");
        System.out.println(realPath1);

        String realPath2 = context.getRealPath("/WEB-INF/b.txt");
        System.out.println(realPath2);

        //设置一共共享数据
        context.setAttribute("username","小七");

        //删除共享数据
        context.removeAttribute("username");


    }
}
