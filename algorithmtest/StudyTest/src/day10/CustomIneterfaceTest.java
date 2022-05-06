package day10;

/**
 * @author hongtao
 * @create 2022-04-21-13:24
 */

public class CustomIneterfaceTest implements IA{
    @Override
    public Double get(String s) {
        return null;
    }

    @Override
    public void hi(Double aDouble) {

    }

    @Override
    public void run(Double r1, Double r2, Double r3) {

    }
}




interface IUsb<U,R>{

    //普通方法中，可以使用泛型接口
    R get(U u);

    void hi(R r);

    void run(R r1,R r2,R r3);

    //在jdk8中 可以在接口中，使用默认方法，也是可以使用泛型
    default R method(U u){
        return null;
    }
}

interface IA extends IUsb<String,Double>{

}