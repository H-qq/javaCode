package pro02.service;

import pro02.bean.Customer;

public class CustomerList {
    private Customer[] customers;
    int total = 0;
    //用来初始化数组  totalCustomer指定长度
    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
    }
    //增加数组
    public boolean addCustomer(Customer customer){
        if (total >= customers.length){
            return false;
        }
        customers[total] = customer;
        total++;
        return true;
    }
    //修改指定索引位置的用户信息
    public boolean replaceCustomer(int index, Customer cust){
        if (index >= total|| index < 0){
            return  false;
        }
        customers[index] = cust;
        return true;
    }
    //删除用户
    public boolean deleteCustomer(int index){
        if (index >= total|| index < 0){
            return  false;
        }
        for (int i = index;i<total -1;i++){
            customers[i] = customers[i+1];
        }
        //最后有数据的元素要志玲
        customers[total-1] = null;
        total--;
        return true;
    }
    //获取所有用户信息
    public Customer[] getAllCustomers(){
        Customer[] custs = new Customer[total];
        for (int i = 0;i<total;i++){
            custs[i] = customers[i];
        }
        return custs;
    }
    public Customer getCustomer(int index){
        if (index < 0|| index>=total){
            return  null;
        }
        return customers[index];
    }
    //获取客户数量
    public int getTotal(){
        return total;
    }


}
