package com.example.servlet_demo1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author hongtao
 * @create 2022-04-13-19:41
 * 线程安全的问题
 */

public class ServletDemo04 extends HttpServlet {
    //1、定义一个用户名的成员变量
    private String username;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //private String username = null;
        //2、获取用户名
        synchronized (this) {
            username = req.getParameter("username");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //3、用户名响应给浏览器
            PrintWriter pw = resp.getWriter();
            pw.println("welcome:" + username);
            pw.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
