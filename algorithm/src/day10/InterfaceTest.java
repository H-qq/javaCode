package day10;

public class InterfaceTest {
    public static void main(String[] args) {
        System.out.println(Flyable.Max_SPEED);
        Plane p1 = new Plane();
        p1.Fly();
    }
}

interface Flyable{
    //全局常量
    public static final int Max_SPEED = 7900;
    public static final int MIN_SPEED = 1;

    //抽象方法
    public abstract void Fly();
    void stop();
}

class Plane implements Flyable{

    @Override
    public void Fly() {
        System.out.println("通过引擎起飞");
    }

    @Override
    public void stop() {
        System.out.println("驾驶员减速停止");
    }
}