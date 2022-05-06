package pro.junit;

import org.junit.Test;
import pro.domain.Employee;
import pro.service.NameListService;
import pro.service.TemException;

public class NameListServiceTest {

    @Test
    public void testGetAllEmployees(){
        NameListService service = new NameListService();
        Employee[] e = service.getAllEmployees();
        for (int i = 0;i<e.length;i++){
            System.out.println(e[i]);
        }
    }

    @Test
    public void testGetEmployee(){
        NameListService service = new NameListService();
        int id = 1;
        try {
            Employee employee = service.getEmployee(id);
            System.out.println(employee);
        } catch (TemException e) {
            System.out.println(e.getMessage());
        }
    }
}

