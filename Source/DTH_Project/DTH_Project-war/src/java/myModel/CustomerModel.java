/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myModel;

import com.mybean.Customer;
import com.mysessionbean.CustomerFacadeLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author r0cklee147
 */
public class CustomerModel {
    CustomerFacadeLocal customerFacade = lookupCustomerFacadeLocal();


    public CustomerFacadeLocal getCustomerFacade() {
        return customerFacade;
    }

    public void setCustomerFacade(CustomerFacadeLocal customerFacade) {
        this.customerFacade = customerFacade;
    }

    public String getCus_id() {
        return cus_id;
    }

    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;
    }
    private String cus_id;

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
    private double money;
    
    public double getWallet(String cus_id){
        
        List<Customer> list = customerFacade.findByCusID(cus_id);
        for (int i = 0; i < list.size(); i++) {
            Customer cus = list.get(i);
            return cus.getDigitalMoney();
        }
        return 0;
    }
    
    public String getCustomerName(String cus_id){
        
        List<Customer> list = customerFacade.findByCusID(cus_id);
        for (int i = 0; i < list.size(); i++) {
            Customer cus = list.get(i);
            return cus.getCusName();
        }
        return "";
    }
    
    
    public void register (String cus_id , String password , String cus_name , String address , int loca_id , String card , String phone , String email ){
        Customer cus = new Customer();
        cus.setCusID(cus_id);
        cus.setPassword(password);
        cus.setCusName(cus_name);
        cus.setAddress(address);
        cus.setLocationID(loca_id);
        cus.setCardNumber(card);
        cus.setPhoneNumber(phone);
        cus.setEmail(email);
        cus.setDigitalMoney(0.0);
        cus.setMoneySpent(0.0);
        customerFacade.create(cus);
    }

    private CustomerFacadeLocal lookupCustomerFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (CustomerFacadeLocal) c.lookup("java:global/DTH_Project/DTH_Project-ejb/CustomerFacade!com.mysessionbean.CustomerFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    

    
    
}
