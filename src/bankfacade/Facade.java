/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankfacade;

import bankcustomers.BankAccount;
import bankcustomers.BankCustomer;
import gencustaccount.AccountIf;
import gencustaccount.CustomerIf;
import java.util.ArrayList;

/**
 *
 * @author Reo
 */
public class Facade {
    private ArrayList<CustomerIf> customers = new ArrayList();
    private static Facade FacadeObj = null;
    public static Facade getMyFacadeObject() {
        
        if (FacadeObj == null) {
            FacadeObj = new Facade();
        } 
        return FacadeObj;
    }
    
    
    Facade(){
        
        /*
        Jane
        acc 16901 - 500
        acc 16902 - 300
        */
        ArrayList<AccountIf> cust1Accounts = new ArrayList();
        AccountIf account = new BankAccount(16901);
        account.deposit(500);
        cust1Accounts.add(account);
        account = new BankAccount(16902);
        account.deposit(300);
        cust1Accounts.add(account);
        CustomerIf cust1 = new BankCustomer("Jane", cust1Accounts);
        customers.add(cust1);

        /*
        Joey
        acc 16903 - 500
        acc 16904 - 300
        */
        ArrayList<AccountIf> cust2Accounts = new ArrayList();
        account = new BankAccount(16903);
        account.deposit(200);
        cust2Accounts.add(account);
        account = new BankAccount(16904);
        account.deposit(400);
        cust2Accounts.add(account);
        CustomerIf cust2 = new BankCustomer("Joey", cust2Accounts);
        customers.add(cust2);
    }

    public void doDeposit(double amt, CustomerIf cust, int accNo){
        //เพือฝากเงินเข้าบัญชีของ customer ตามหมายเลขบัญชีทีระบุ
        cust.getAccount(accNo).deposit(amt);
    }

    public AccountIf getBankAccount(CustomerIf cust, int accNo){
        //เพือแสดงข้อมูลจากบัญชีเงินฝากของ customer ตามหมายเลขบัญชีทีระบุ
        return cust.getAccount(accNo);
    }

    public CustomerIf getBankCustomer(String custName){
        //เพือแสดงข้อมูลของผู้ใช้ รวมถึงบัญชีทั งหมดทีมีและเงินในบัญชีด้วย
        for(CustomerIf cust : customers){
            if(cust.getCustomerName().equals(custName)){
               return cust;
            }
        }
        return null;
    }
    
}
