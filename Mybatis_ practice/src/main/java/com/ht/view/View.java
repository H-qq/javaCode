package com.ht.view;

import com.ht.MybatisTest;

import java.io.*;

/**
 * @author hongtao
 * @create 2022-05-11-15:42
 */

public class View {
    public static void main(String[] args) {
        boolean isTrue = false;
        System.out.println("--输入--");
        System.out.println("1、进入");
        System.out.println("0、退出");
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));
        try {
            int choose = Integer.parseInt(bufferedReader.readLine());
            if (choose == 1) {
                isTrue = true;
            }
            while (isTrue) {
                view();
                choose = Integer.parseInt(bufferedReader.readLine());
                switch (choose) {
                    case 1:
                        MybatisTest.testSelectAll();
                        break;
                    case 2:
                        MybatisTest.selectByIdAfter();
                        break;
                    case 3:
                        System.out.println("进入条件查询");
                        MybatisTest.selectByCondition();
                        break;
                    case 4:
                        MybatisTest.addDate();
                        break;
                    case 5:
                        MybatisTest.upDate();
                        break;
                    case 6:
                        MybatisTest.delByName();
                        break;
                    case 7:
                        MybatisTest.delByIds();
                        break;
                    default:
                        isTrue = false;
                        break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void view() {
        System.out.println("==========系统内容===========");
        System.out.println("1、查看所有记录");
        System.out.println("2、通过id查询");
        System.out.println("3、条件查询");
        System.out.println("4、添加记录");
        System.out.println("5、修改记录");
        System.out.println("6、删除记录");
        System.out.println("7、删除多条记录");
    }
}
