package doy03;

public class StudentTest {
    public static void main(String[] args) {
        Studen[] stus = new Studen[20];
        for (int i = 0; i < stus.length; i++) {
            stus[i] = new Studen();
            //给Student 对象属性赋值
            stus[i].number = (i + 1);
            //年级【1，6】
            stus[i].state = (int) (Math.random() * (6 - 1 + 1) + 1);
            //成绩：【0，100】
            stus[i].score = (int) (Math.random() * (100 - 0 + 1));
        }
        for (int i = 0; i < stus.length; i++) {
            System.out.println(stus[i].info());
        }
        System.out.println("------------------");
        StudentTest test = new StudentTest();
        test.search(stus, 3);
        System.out.println("----------------------");
        test.sort(stus);
        for (int i = 0; i < stus.length; i++) {
            System.out.println(stus[i].info());
        }
    }
    public void search(Studen[] stus, int state) {
        for (int i = 0; i < stus.length; i++) {
            if (stus[i].state == state) {
                System.out.println(stus[i].info());
            }
        }
    }
    public void sort(Studen[] stus) {
        for (int i = 0; i < stus.length - 1; i++) {
            for (int j = 0; j < stus.length - 1 - i; j++) {
                if (stus[j].score > stus[j + 1].score) {
                    //如果需要交换顺序，交换的是数组的元素，是Student对象
                    Studen temp = stus[j];
                    stus[j] = stus[j + 1];
                    stus[j + 1] = temp;
                }
            }
        }
    }
}
class Studen {
    int number;
    int state;//年级
    int score;
    public String info() {
        return "学号：" + number + "，年级：" + state + "，成绩：" + score;
    }
}


