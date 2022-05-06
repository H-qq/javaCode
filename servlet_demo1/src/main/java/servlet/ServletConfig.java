package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;



/**
 * @author hongtao
 * @create 2022-04-15-19:42
 */

public class ServletConfig extends HttpServlet  {
    //1.声明ServletConfig
    private  javax.servlet.ServletConfig config;
     //2.通过init的方法，来对ServletConfig进行赋值


    @Override
    public void init(javax.servlet.ServletConfig config) throws ServletException{
        this.config = config;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //3.演示ServletConfig的方法
        String encodingValue = config.getInitParameter("encoding");
        System.out.println(encodingValue);

        //获取所有key
        Enumeration<String> keys = config.getInitParameterNames();
        while (keys.hasMoreElements()){
            //获取每一个keys
            String key = keys.nextElement();
            //根据key获取value
            String value = config.getInitParameter(key);

            System.out.println(key+","+value);
        }

        //获取Servlet名称
        String servletName = config.getServletName();
        System.out.println(servletName);

        //获取ServletContext的对象
        ServletContext servletContext = config.getServletContext();
        System.out.println(servletContext);

        //获取共享数据
        Object value = servletContext.getAttribute("username");
        System.out.println(value);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
