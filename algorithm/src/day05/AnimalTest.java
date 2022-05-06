package day05;

public class AnimalTest {
    public static void main(String[] args) {
        Animal a = new Animal();


        a.setLegs(-2);
        a.show();
    }
}

class Animal{
    private String name;
    private int age;
    private int legs; //腿的个数
    public void setLegs(int l){
        if (l>0){
            legs = l;
        }else {
            legs = 0;
        }
    }
    public int getLegs(){
        return legs;
    }
    public void eat(){
        System.out.println("动物进食：");
    }
    public void show(){
        System.out.println("name:"+name+",age:"+age+",legs:"+legs);
    }
    public int getAge(){
        return age;
    }
    public void setAge(int a){
        age = a;
    }
}
