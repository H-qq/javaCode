package doy03;

public class UserTest {
    public static void main(String[] args) {
        User u1 = new User();
        System.out.println(u1.name);
        System.out.println(u1.age);
    }
}
class User{
    //属性
    String name;
    int age;
    boolean isMale;

    public void talk(String language){  //language ：形参  也是局部变量
        System.out.println("我们使用"+language);
    }
    public void eat(){
        String food = "烙饼";   //局部变量
        System.out.println("北方人吃"+food);
    }

}