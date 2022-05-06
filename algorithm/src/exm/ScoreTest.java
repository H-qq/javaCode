package exm;

import java.util.Scanner;
import java.util.Vector;

public class ScoreTest {
    public static void main(String[] args) {
        //1.实例化Scanner，用于获取键盘学生成绩
        Scanner  scan = new Scanner(System.in);
        //2.创建Vector对象；
        Vector v = new Vector();
        int maxScore = 0;
        //3.for循环方式 给Vector中添加数组
        for (;;) {
            System.out.println("输入学生成绩（以负数为代表表示结束）");
            int score = scan.nextInt();
            //3.2 输入为负数 跳出循环
            if (score < 0) {
                break;
            } else if (score > 100) {
                continue;
            }
            //3.1 添加操作  v.addElement
            Integer inScore = new Integer(score);
            v.addElement(inScore);//多态
            //4.获取最大值
            if (maxScore < score){
                maxScore = score;
            }
        }
        //5.遍历Vector 得到每一个学生成绩 并与最大成绩比较 得到等级
        for (int i =0;i< v.size();i++){
            char lever = 0;
            Object obj = v.elementAt(i);
            int score =(int) obj;
            if (maxScore - score <= 10){
                lever = 'A';
            }else if (maxScore - score <= 20){
                lever = 'B';
            }else if (maxScore - score <= 30){
                lever = 'C';
            }else{
                lever = 'D';
            }
            System.out.println("Student"+i+" score is"+score+",level is"+lever);
        }
    }

}
