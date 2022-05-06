package test01;

import org.junit.Test;

/**
 * @author hongtao
 * @create 2022-04-21-17:06
 */

public class test1 {
    public static void main(String[] args) {

    }
    @Test
    public void testList(){
        Dao<Object> objectDao = new Dao<>();
        objectDao.save("1",new Uesr(1,10,"七七"));
        objectDao.save("2",new Uesr(2,11,"小七"));
        objectDao.save("3",new Uesr(3,12,"大七"));
        objectDao.save("4",new Uesr(4,14,"笨七"));

        System.out.println(objectDao.list());
        objectDao.upDate("3",new Uesr(3,12,"傻七"));
        System.out.println(objectDao.list());
        System.out.println(objectDao.get("3"));
    }
}
