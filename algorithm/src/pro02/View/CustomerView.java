package pro02.View;

import pro02.service.CustomerList;
import pro02.uitl.CMUtility;

public class CustomerView {
    CustomerList customerList = new CustomerList(10);

    public void enterMainMenu(){
       boolean isFlag = true;
       while (isFlag){
           System.out.println("\n-----------------客户信息管理系统------------------------");
           System.out.println("                    1.添加客户");
           System.out.println("                    2.修改客户");
           System.out.println("                    3.删除客户");
           System.out.println("                    4.客户列表");
           System.out.println("                    5.退出\n");
           System.out.println("                   请选择（1-5）");

           char menu = CMUtility.readMenuSelection();
           switch (menu){
               case '1':
                   addNewCustomer();
                    break;
               case '2':
                   modifyCustomer();
                    break;
               case '3':
                   deleteCustomer();
                    break;
               case '4':
                    listAllCustomers();
                    break;
               case '5':
                   //System.out.println("退出");
                   System.out.println("确实是否退出（Y/N");
                   char isexit = CMUtility.readConfirmSelection();
                   if (isexit == 'Y'){
                       isFlag = false;
                   }
                   break;
           }
           //isFlag = false;
       }
    }
    private void addNewCustomer(){
        System.out.println("添加客户操作");
    }
    private void modifyCustomer(){
        System.out.println("添加客户操作");
    }
    private void deleteCustomer(){
        System.out.println("添加客户操作");
    }
    private void listAllCustomers(){
        System.out.println("----------------客户列表------------------\n");


        System.out.println("----------------客户列表完成------------------\n");
    }
    public static void main(String[] args){
        CustomerView view = new CustomerView();
        view.enterMainMenu();
    }

}
