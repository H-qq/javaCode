package com.example.servlet_demo1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hongtao
 * @create 2022-04-13-20:16
 */

public class ServletDemo06 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.定义商品价格
        int money = 1000;
        //2.获取访问资源入径
        String path = req.getRequestURI();
        path = path.substring(path.lastIndexOf("/"));
        //3.条件判断
        if ("/vip".equals(path)){
            System.out.println("商品原价为："+money+"优惠后价格为："+money*0.9);
        }else if ("/vvip".equals(path)){
            System.out.println("商品原价为："+money+"优惠后价格为："+money*0.5);
        }else {
            System.out.println("价格为："+money);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
