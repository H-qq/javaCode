package day04;

public class OverLoadTest {

    public void mOL(int i){
        System.out.println(i*i);
    }
    public void mOL(int i,int j){
        System.out.println(i*j);
    }
    public void mOL(String s){
        System.out.println(s);
    }

    public int  max(int i,int j){
        return (i>j)? i:j;
    }
}
