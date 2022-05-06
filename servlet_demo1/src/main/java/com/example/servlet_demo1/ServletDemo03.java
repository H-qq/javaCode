package com.example.servlet_demo1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hongtao
 * @create 2022-04-13-17:07
 * Servlet 生命周期
 */

public class ServletDemo03 extends HttpServlet {
    @Override
    //对象出生的过程
    public void init() throws ServletException {
        System.out.println("对象创建并初始化成功");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收到了客户端的请求");
    }

    //对象销毁的过程
    @Override
    public void destroy() {
        System.out.println("对象死亡过程");
    }
}
