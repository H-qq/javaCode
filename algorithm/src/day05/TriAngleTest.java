package day05;

public class TriAngleTest {
    public static void main(String[] args) {
        TriAngle t1 = new TriAngle(2.0,5.0);
        System.out.println(t1.getBase()+","+t1.getHeight());
    }
}

class TriAngle{
    private double base ;//底边长
    private  double height;//高
    public TriAngle(){}  //一般提供空参
    public TriAngle(double b,double h){
        base  = b;
        height = h;
    }
    public void setBase(double b){
        base = b;
    }
    public double getBase(){
        return base;
    }
    public void setHeight(double h){
        height = h;
    }
    public double getHeight(){
        return height;
    }
}
