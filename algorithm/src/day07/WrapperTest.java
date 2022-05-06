package day07;
 import org.junit.Test;

public class WrapperTest {
 //基本数据类型 --> 包装类:调用包装类的构造器
 @Test
 public void test1(){
  int num1 = 10;
  Integer in1 = new Integer(num1);
  System.out.println(in1.toString());
 }
 @Test
 public void test2() {
  Integer in1 = new Integer(12);
  int i1 = in1.intValue();
  System.out.println(i1 + 1);
 }

  @Test
 public void test3(){
    int num1 = 10;
    //方式一
    String str1 = num1 + "";
    //方式二：
   float f1 = 12.3f;
   String str2 = String.valueOf(f1);
   System.out.println(str1);
   System.out.println(str2);
  }
  @Test
 public void test5(){
  String str1 = "123";

   int i1 = Integer.parseInt(str1);
   System.out.println(i1);

  }

}

