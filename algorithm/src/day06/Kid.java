package day06;

public class Kid extends Mankind{
    private int yearOld;
    public Kid(){}
    public Kid(int yearOld){
        this.yearOld = yearOld;
    }
    public void printAge(){
        System.out.println("I am "+yearOld+" year old");
    }

    public int getYearOld() {
        return yearOld;
    }

    public void setYearOld(int yearOld) {
        this.yearOld = yearOld;
    }
}
