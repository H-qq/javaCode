package day11;

public class EcmDef {
    public static void main(String[] args)  {
        try {
            int i = Integer.parseInt(args[0]);
            int j = Integer.parseInt(args[1]);
            int result =ecm(i,j);
            System.out.println(result);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("缺少命令行参数");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public  static int ecm(int i,int j) throws Exception{
        if (i <0 || j<0){
            throw new Exception("分子或分母为负数");
        }
        return  i/j;
    }
}
