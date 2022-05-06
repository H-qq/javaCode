package day05;

public class PensonTest {
    public static void main(String[] args) {
        //创建类的对象   new+构造器
        Penson p1 = new Penson();
        p1.setAge(22);
        System.out.println(p1.getAge());
    }

}
class  Penson{
    private String name;
    private  int age ;
    public Penson(){
        System.out.println("----");
    }
    public Penson(String n){
        name = n ;
    }
    public Penson(String n,int a){
        name = n;
        age = a;
    }
    public void setAge(int a){
        if (a<0 || a >130){
            throw new RuntimeException("传入数据非法");
        }else {
            age = a;
        }
    }
    public int getAge(){
        return age;
    }
}
