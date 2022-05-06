package day11;
/*
* try -catch-finally的使用
* try{
*   //可能出现的异常
*  }catch（异常类型 1 变量名1）{
*   //处理异常类型方式1
* }catch（异常处理 2  变量名2）{
*
* }finally{
*           //一定执行的·代码
* }
*
* */

public class ExceionTest {
    public static void main(String[] args) {
        try {
            Student  s1 = new Student();
            s1.regist(-1001);
            System.out.println(s1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class Student{
    private int id ;
    public void regist(int id) throws Exception {
        if (id > 0){
            this.id = id ;
        }else {
            throw new Exception("您的输入非法!");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}