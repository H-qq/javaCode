package day05;

/**
 * @author hongtao
 * @create 2022-04-14-13:48
 * 使用enum关键字定义枚举类
 */

public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 autumn = Season1.AUTUMN;
        System.out.println(autumn);
        System.out.println(Season1.class.getSuperclass());
        Season1[] values = Season1.values();
        for (Season1 value : values) {
            System.out.println(value);
            value.show();
        }
        Season1 winter = Season1.valueOf("WINTER");

    }
}

//使用 enum 定义
enum Season1 implements Info{
    //1.创建 当前枚举类的对象，多个对象之间用逗号隔开，最后一个分号结束
     SPRING("春天","春暖花开"){
         public void show(){
            System.out.println("这是春天");
        }
    },
     SUMMER("夏天","夏日炎炎"){
         @Override
         public void show() {
             System.out.println("这是夏天");
         }
     },
     AUTUMN("秋天","秋高气爽"){
         @Override
         public void show() {
             System.out.println("这是秋天");
         }
     },
     WINTER("冬天","冰天雪地"){
         @Override
         public void show() {
             System.out.println("这是冬天");
         }
     };
    private final String seasonName;
    private final String seasonDesc;

    private Season1(String seasonName,String seasonDesc){
        this.seasonDesc = seasonDesc;
        this.seasonName = seasonName;
    }

    //4.其他诉求1，获取枚举类的属性

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
}

interface Info{
    void show();
}