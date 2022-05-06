package day08;

public class StaticTest {
    public static void main(String[] args) {
        Chinese c1 = new Chinese();
        c1.name = "姚明";
        c1.age = 41;
        c1.nation = "CHINA";
        System.out.println();
    }
}

class Chinese{
    String name;
    int age;
    static String nation;
}
