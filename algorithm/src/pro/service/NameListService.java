package pro.service;
import static pro.service.Data.*;

import pro.domain.*;

public class NameListService {
    private Employee[] employees;
    //给employees及数组元素初始化
    public NameListService(){
        employees = new Employee[EMPLOYEES.length];

        for (int i = 0;i<employees.length;i++){
            int type = Integer.parseInt(EMPLOYEES[i][0]);
            //获取Employee的4个基本信息
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);
            Equipment equipment;
            double bonus ;
            int stock;
            switch (type){
                case EMPLOYEE :
                    employees[i] = new Employee(id,name,age,salary);
                    break;
                case PROGRAMMER:
                    equipment = creatEquipment(i);
                    employees[i] = new Programmer(id,name,age,salary,equipment);
                    break;
                case DESIGNER:
                    equipment = creatEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id,name,age,salary,equipment,bonus);
                    break;
                case ARCHITECT:
                    equipment = creatEquipment(i);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Archietect(id,name,age,salary,equipment,bonus,stock);
                    break;
            }

        }
    }
//获取指定员工的设备
    private Equipment creatEquipment(int index) {
        int type = Integer.parseInt(EQUIPMENTS[index][0]);
        String model = EQUIPMENTS[index][1];
        switch (type) {
            case PC:
                String display = EQUIPMENTS[index][2];
                return new PC(model,display);
            case NOTEBOOK:
                double price = Double.parseDouble(EQUIPMENTS[index][2]);
                return new NoteBook(model,price);

            case PRINTER:
                return new Printer(model,EQUIPMENTS[index][2]);

        }
        return  null;
    }

    public Employee[] getAllEmployees(){

        return  employees;
    }
    public Employee getEmployee(int id) throws TemException {
        for (int i =0 ; i< employees.length;i++){
            if (employees[i].getId() == id){
                return employees[i];
            }
        }
        throw new TemException("找不到指定的员工");
    }
}
