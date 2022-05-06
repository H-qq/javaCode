package day02;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * @author hongtao
 * @create 2022-04-12-13:02
 */

public class DateTimeTest {
    @Test
    public void test4(){
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        //of():
        LocalDate test1 = LocalDate.of(2022, 4, 9);
        System.out.println(test1);
        double pow  = Math.pow(20,22);
        LocalDate d1 = test1.plusDays((int) pow);
        DayOfWeek res = d1.getDayOfWeek();
        System.out.println(res);


    }
    @Test
    public void test3(){
        Calendar c1 = Calendar.getInstance();
        System.out.println(c1.get(Calendar.DAY_OF_YEAR));
        double pow = Math.pow(20, 22);
        c1.add(Calendar.DAY_OF_YEAR, (int) pow);
        System.out.println(c1.get(Calendar.DAY_OF_MONTH));

        Date date1 = new Date(2022,4,9);
        System.out.println(date1);

    }
    @Test
    public void test2(){
        //构造器一：Date()
        Date d1 = new Date();
        System.out.println(d1);
        System.out.println(d1.getTime());

        //构造器二：指定时间
        Date d2 = new Date(1649740457464L);

        java.sql.Date d3 = new java.sql.Date(1649740870483L);
        System.out.println(d3);
    }
    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        System.out.println(time);
    }
}
