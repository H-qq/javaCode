package day09;

/**
 * @author hongtao
 * @create 2022-04-20-17:33
 */

public class CustomGeneric {
    public static void main(String[] args) {

    }
}
//1.Tiger 后面泛型，所以我们把Tiger就成称为自定义泛型
//2.T,R,N泛型的标识符，可以有多个
//3.普通成员可以使用泛型（属性、方法）
//4.使用泛型数组不能进行初始化,因为数组在new 的时候 不能确定T的类型，不能空间
//5.因为静态是和类的相关的，在类加载时，对象还没创建，所以如果静态方法和静态属性使用
//泛型 JVm不能完成初始化
class Tiget<T,R,N>{
    String  name;
    R r;
    N n;
    T t;
    public Tiget(){
    }

    public Tiget(String name, R r, N n, T t) {
        this.name = name;
        this.r = r;
        this.n = n;
        this.t = t;
    }
}